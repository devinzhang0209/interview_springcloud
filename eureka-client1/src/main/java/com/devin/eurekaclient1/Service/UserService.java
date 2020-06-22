package com.devin.eurekaclient1.Service;

import com.devin.eurekaclient1.model.User;
import com.devin.eurekaclient1.vo.UserVo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * @author Devin Zhang
 * @className UserService
 * @description TODO
 * @date 2020/6/20 10:33
 */

@Service
public class UserService {

    /**
     * 用户新增
     *
     * @param userVo
     * @return
     */
    public String userAdd(UserVo userVo) {
        User user = new User();
        user.setCreateTime(new Date());
        user.setUserId(UUID.randomUUID().toString());
        user.setUserName(userVo.getUserName());
        user.setUserPass(userVo.getUserPass());
        user.setUserToken(UUID.randomUUID().toString());
        System.out.println("新增成功:");
        System.out.println(user);
        return user.getUserId();
    }

    /**
     * 获取用户
     *
     * @param userId
     * @return
     */
    public User getUserById(String userId) {
        User user = new User();
        user.setCreateTime(new Date());
        user.setUserId(userId);
        user.setUserName("devin");
        user.setUserPass(UUID.randomUUID().toString());
        user.setUserToken(UUID.randomUUID().toString());
        System.out.println("获取到用户:"+user);
        return user;
    }
}
