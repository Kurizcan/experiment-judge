package com.graduation.experimentjudge.service;

import com.graduation.experimentjudge.bean.User;
import com.graduation.experimentjudge.config.auth.Authentication;
import com.graduation.experimentjudge.mapper.UserMapper;
import com.graduation.experimentjudge.util.BcryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kurizcan
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;


    @Autowired
    Authentication authentication;


    public User register(User user) {
        String password = BcryptUtil.encode(user.getPassword());
        user.setPassword(password);
        boolean flag = userMapper.addUser(user);
        if (!flag) {
            return null;
        }
        return user;
    }

    public String login(String name, String password) {
        User user = userMapper.getUserByName(name);
        if (user == null || !BcryptUtil.match(password, user.getPassword())) {
            return null;
        }
        // 获取 token 并设置 cookie
        System.out.println("id:" + user.getId());
        System.out.println("type:" + user.getType());
        String token = authentication.createToken(user);
        return token;
    }
}
