package com.nchu.software.dto;

import com.nchu.software.domain.Record;
import com.nchu.software.domain.User;
import lombok.Data;

/**
 * @Author JayHrn
 * @Date 2023-05-15 13:42
 * @Description
 */
@Data
public class RecordDto extends Record {
    private User user;
}
