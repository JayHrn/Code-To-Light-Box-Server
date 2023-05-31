package com.nchu.software.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nchu.software.domain.LevelDifficulty;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 15696
 * @description 针对表【level_difficulty(关卡难度)】的数据库操作Mapper
 * @createDate 2023-05-09 19:44:44
 * @Entity com.nchu.software.domain.LevelDifficulty
 */
@Mapper
public interface LevelDifficultyMapper extends BaseMapper<LevelDifficulty> {

}




