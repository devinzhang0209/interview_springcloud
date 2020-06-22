package com.devin.eurekaclient1.controller;

import com.devin.eurekaclient1.Service.UserService;
import com.devin.eurekaclient1.model.User;
import com.devin.eurekaclient1.vo.UserVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Devin Zhang
 * @className UserController
 * @description TODO
 * @date 2020/6/20 10:38
 */

@RestController
@RequestMapping("/cloud/user")
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
    public String userAdd(@RequestBody  UserVo userVo) {
        return userService.userAdd(userVo);
    }

    /**
     * 获取用户
     *
     * @param userId
     * @return
     */
    @GetMapping("/get")
    public User getUserById(String userId) {
        return userService.getUserById(userId);
    }
}
