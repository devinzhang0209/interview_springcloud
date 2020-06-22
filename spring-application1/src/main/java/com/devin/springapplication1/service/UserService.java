package com.devin.springapplication1.service;

import com.devin.springapplication1.feign.UserServiceFeign;
import com.devin.springapplication1.model.User;
import com.devin.springapplication1.vo.UserVo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * @author Devin Zhang
 * @className UserService
 * @description TODO
 * @date 2020/6/20 11:09
 */

@Service
public class UserService {
    @Resource
    private UserServiceFeign userServiceFeign;

    public User get(String userId) {
        return userServiceFeign.getUser(userId);
    }

    public String add( UserVo userVo) {
        return userServiceFeign.addUser(userVo);
    }
}
