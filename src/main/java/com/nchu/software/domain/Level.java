package com.nchu.software.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 关卡
 *
 * @TableName level
 */
@TableName(value = "level")
@Data
public class Level implements Serializable {
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
     * 描述
     */
    @TableField(value = "description")
    private String description;

    /**
     * 关卡难度
     */
    @TableField(value = "difficulty")
    private Long difficulty;

    /**
     * 上一关卡
     */
    @TableField(value = "pre_level")
    private Long preLevel;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}
