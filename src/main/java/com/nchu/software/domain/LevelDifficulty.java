package com.nchu.software.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 关卡难度
 *
 * @TableName level_difficulty
 */
@TableName(value = "level_difficulty")
@Data
public class LevelDifficulty implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 难度等级
     */
    @TableField(value = "grade")
    private Integer grade;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}
