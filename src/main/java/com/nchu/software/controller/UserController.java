package com.nchu.software.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.nchu.software.common.Result;
import com.nchu.software.domain.User;
import com.nchu.software.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author JayHrn
 * @Date 2023-05-09 19:46
 * @Description
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 登录
     *
     * @param user
     * @return
     */
    @PostMapping("/login")
    public Result<User> login(@RequestBody User user) {
        String password = user.getPassword();
        // 1. 根据页面提交的用户名username查询数据库
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, user.getUsername());
        User user1 = userService.getOne(queryWrapper); // 用户名唯一
        // 2. 如果没有查询到则返回登录失败结果
        if (user1 == null) {
            return Result.error("该账户不存在");
        }
        // 3. 密码比对，如果不一致则返回登录失败结果
        if (!user1.getPassword().equals(password)) {
            return Result.error("密码错误");
        }
        return Result.success(user1, "登录成功");
    }

    /**
     * 注册账号
     *
     * @param user
     * @return
     */
    @PostMapping
    public Result<String> register(@RequestBody User user) {
        log.info("注册账号，账户信息{}", user.toString());
        // 保存
        userService.save(user);
        return Result.success("新增成功");
    }

    /**
     * 根据id查询用户信息
     *
     * @param id 主键
     * @return
     */
    @GetMapping("/id/{id}")
    public Result<User> getById(@PathVariable Long id) {
        log.info("根据id查询用户信息...");
        User user = userService.getById(id);
        return Result.success(user, "查询成功");
    }

    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return
     */
    @GetMapping("/username/{username}")
    public Result<User> getByUsername(@PathVariable String username) {
        log.info("根据username查询用户信息...{}",username);
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(username != null, User::getUsername, username);
        User user = userService.getOne(userLambdaQueryWrapper);
        return Result.success(user, "查询成功");
    }

    /**
     * 获取所有用户，同时拿来作为总排行榜使用（解锁关卡数目）
     *
     * @return
     */
    @GetMapping("/list")
    public Result<List<User>> list() {
        // 获取所有教师
        List<User> list = userService.list();
        return Result.success(list, "查询成功");
    }

    /**
     * 1. 更新账户
     * 1.1 修改密码
     * 1.2 解锁关卡
     *
     * @param user 用户
     * @return Result<String>
     */
    @PutMapping
    public Result<String> update(@RequestBody User user) {
        log.info(user.toString());
        userService.updateById(user);
        return Result.success("修改成功");
    }
}
