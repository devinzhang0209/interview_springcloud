package com.devin.springapplication1.model;

import java.util.Date;

/**
 * @author Devin Zhang
 * @className User
 * @description TODO
 * @date 2020/6/20 10:31
 */

public class User {
    private String userId;
    private String userName;
    private String userPass;
    private String userToken;
    private Date createTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userToken='" + userToken + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
