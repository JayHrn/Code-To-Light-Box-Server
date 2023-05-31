package com.nchu.software.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.nchu.software.common.Result;
import com.nchu.software.domain.Level;
import com.nchu.software.service.LevelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author JayHrn
 * @Date 2023-05-15 14:06
 * @Description
 */
@Slf4j
@RestController
@RequestMapping("/level")
public class LevelController {
    @Autowired
    private LevelService levelService;

    /**
     * 查询第一关数据 (pre_level=null)
     *
     * @return
     */
    @GetMapping("/firstLevel")
    public Result<Level> getFirstLevel() {
        LambdaQueryWrapper<Level> levelLambdaQueryWrapper = new LambdaQueryWrapper<>();
        levelLambdaQueryWrapper.isNull(Level::getPreLevel);
        Level level = levelService.getOne(levelLambdaQueryWrapper);
        return Result.success(level, "查询成功");
    }

    /**
     * 根据上一关卡获取下一关关卡
     *
     * @param id
     * @return
     */
    @GetMapping("/nextLevel/{id}")
    public Result<Level> getLevelByPre(@PathVariable Long id) {
        LambdaQueryWrapper<Level> levelLambdaQueryWrapper = new LambdaQueryWrapper<>();
        levelLambdaQueryWrapper.eq(Level::getPreLevel, id);
        Level level = levelService.getOne(levelLambdaQueryWrapper);
        return Result.success(level, "查询成功");
    }

    /**
     * 获取所有关卡
     *
     * @return
     */
    @GetMapping("/list")
    public Result<List<Level>> list() {
        // 获取所有关卡
        List<Level> list = levelService.list();
        return Result.success(list, "查询成功");
    }

    /**
     * 根据关卡名称查询
     *
     * @param name
     * @return
     */
    @GetMapping("/{name}")
    public Result<Level> getByName(@PathVariable String name) {
        log.info("根据name查询关卡信息...{}", name);
        LambdaQueryWrapper<Level> levelLambdaQueryWrapper = new LambdaQueryWrapper<>();
        levelLambdaQueryWrapper.eq(name != null, Level::getName, name);
        Level level = levelService.getOne(levelLambdaQueryWrapper);
        return Result.success(level, "查询成功");
    }
}
