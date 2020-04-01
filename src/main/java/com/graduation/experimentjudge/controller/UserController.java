package com.graduation.experimentjudge.controller;

import com.graduation.experimentjudge.bean.User;
import com.graduation.experimentjudge.config.auth.Authentication;
import com.graduation.experimentjudge.conversion.Result;
import com.graduation.experimentjudge.service.UserService;
import com.graduation.experimentjudge.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(value="/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @PostMapping(value = {"/register"})
    public Result register(User user) {
        HashMap<String, Integer> data = new HashMap<>();
        int uid = userService.register(user);
        if (uid == ResultCode.UPDATE_OR_INSERT_DATA_FAIL.getCode()) {
            return new Result(uid, "", null);
        }
        data.put("uid", uid);
        return new Result(ResultCode.SUCCESS.getCode(), "", data);
    }

    @ResponseBody
    @PostMapping(value = {"/login"})
    public Result login(String name, String password) {
        return null;
    }
}
