package com.devin.springapplication1.feign;

import com.devin.interview.config.FeignRequestConfig;
import com.devin.springapplication1.model.User;
import com.devin.springapplication1.vo.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Devin Zhang
 * @className UserServiceFeign
 * @description TODO
 * @date 2020/6/20 11:02
 */
@FeignClient(value = "EUREKA-CLIENT1",configuration = FeignRequestConfig.class)
public interface UserServiceFeign {

    @GetMapping("/cloud/user/get")
    User getUser(@RequestParam String userId);

    @PostMapping(value = "/cloud/user/add")
    String addUser(@RequestBody UserVo userVO);
}
