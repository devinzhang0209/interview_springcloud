package com.devin.springapplication1.controller;

import com.devin.springapplication1.model.User;
import com.devin.springapplication1.service.UserService;
import com.devin.springapplication1.vo.UserVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Devin Zhang
 * @className UserController
 * @description TODO
 * @date 2020/6/20 10:38
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户新增
     *
     * @param userVo
     * @return
     */
    @PostMapping("/add")
    public String userAdd(UserVo userVo) {
        return userService.add(userVo);
    }

    /**
     * 获取用户
     *
     * @param userId
     * @return
     */
    @GetMapping("/get")
    public User getUserById(String userId) {
        return userService.get(userId);
    }
}
