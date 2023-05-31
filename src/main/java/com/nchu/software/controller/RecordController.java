package com.nchu.software.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.nchu.software.common.Result;
import com.nchu.software.domain.Record;
import com.nchu.software.domain.User;
import com.nchu.software.dto.RecordDto;
import com.nchu.software.service.RecordService;
import com.nchu.software.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author JayHrn
 * @Date 2023-05-15 13:25
 * @Description
 */
@Slf4j
@RestController
@RequestMapping("/record")
public class RecordController {
    private final RecordService recordService;
    private final UserService userService;

    public RecordController(RecordService recordService, UserService userService) {
        this.recordService = recordService;
        this.userService = userService;
    }

    /**
     * 新增闯关记录
     *
     * @param record
     * @return
     */
    @PostMapping
    public Result<String> save(@RequestBody Record record) {
        log.info("闯关记录：{}", record.toString());
        // 保存
        recordService.save(record);
        return Result.success("新增成功");
    }

    /**
     * 获取指定关卡排行榜
     *
     * @return
     */
    @GetMapping("/{id}")
    public Result<List<RecordDto>> getLevelRank(@PathVariable Long id) {
        log.info("根据id查询关卡排行榜...，id={}", id);
        List<RecordDto> recordDtoList = new ArrayList<>();

        LambdaQueryWrapper<Record> recordLambdaQueryWrapper = new LambdaQueryWrapper<>();
        recordLambdaQueryWrapper.eq(Record::getLevelId, id);
        List<Record> recordList = recordService.list(recordLambdaQueryWrapper);

        for (Record value : recordList) {
            RecordDto recordDto = new RecordDto();
            // 复制record到recordDto中
            BeanUtils.copyProperties(value, recordDto);
            // 根据userId获取user
            User user = userService.getById(recordDto.getUserId());
            recordDto.setUser(user);
            // 集合存入recordDto对象
            recordDtoList.add(recordDto);
        }
        return Result.success(recordDtoList, "查询成功");
    }

    /**
     * 根据用户id查询闯关记录
     *
     * @param userId
     * @return
     */
    @GetMapping("/user/{userId}/{levelId}")
    public Result<Record> getByName(@PathVariable Long userId,@PathVariable Long levelId) {
        log.info("根据用户id查询闯关记录...{}", userId);
        LambdaQueryWrapper<Record> recordLambdaQueryWrapper = new LambdaQueryWrapper<>();
        recordLambdaQueryWrapper.eq(Record::getUserId, userId)
                .eq(Record::getLevelId,levelId);
        Record record = recordService.getOne(recordLambdaQueryWrapper);
        return Result.success(record, "查询成功");
    }

    /**
     * 更新闯关记录
     *
     * @param record 闯关记录
     * @return Result<String>
     */
    @PutMapping
    public Result<String> update(@RequestBody Record record) {
        log.info(record.toString());
        Record oldRecord = recordService.getById(record.getId());
        // 当前闯关时间更短
        if (oldRecord.getTime() > record.getTime()) {
            recordService.updateById(record);
        }
        return Result.success("修改成功");
    }
}
