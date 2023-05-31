package com.nchu.software.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nchu.software.domain.User;
import com.nchu.software.mapper.UserMapper;
import com.nchu.software.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author 15696
 * @description 针对表【user(用户表)】的数据库操作Service实现
 * @createDate 2023-05-09 19:44:44
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

}




