package com.nchu.software.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nchu.software.domain.Record;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 15696
 * @description 针对表【record(闯关记录)】的数据库操作Mapper
 * @createDate 2023-05-09 19:44:44
 * @Entity com.nchu.software.domain.Record
 */
@Mapper
public interface RecordMapper extends BaseMapper<Record> {

}




