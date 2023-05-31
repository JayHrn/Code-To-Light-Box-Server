package com.nchu.software.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nchu.software.domain.Level;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 15696
 * @description 针对表【level(关卡)】的数据库操作Mapper
 * @createDate 2023-05-09 19:44:44
 * @Entity com.nchu.software.domain.Level
 */
@Mapper
public interface LevelMapper extends BaseMapper<Level> {

}




