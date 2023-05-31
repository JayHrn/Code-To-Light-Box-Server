package com.nchu.software.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nchu.software.domain.Record;
import com.nchu.software.mapper.RecordMapper;
import com.nchu.software.service.RecordService;
import org.springframework.stereotype.Service;

/**
 * @author 15696
 * @description 针对表【record(闯关记录)】的数据库操作Service实现
 * @createDate 2023-05-09 19:44:44
 */
@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record>
        implements RecordService {

}




