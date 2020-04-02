package com.graduation.experimentjudge.controller;

import com.graduation.experimentjudge.bean.User;
import com.graduation.experimentjudge.config.auth.annotation.Teacher;
import com.graduation.experimentjudge.conversion.Result;
import com.graduation.experimentjudge.service.UserService;
import com.graduation.experimentjudge.util.RequestHelper;
import com.graduation.experimentjudge.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * @author kurizcan
 */
@RestController
@RequestMapping(value="/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @PostMapping(value = {"/register"})
    public Result register(@RequestBody User user) {
        HashMap<String, Object> data = new HashMap<>();
        System.out.println("register" + user.getName() + ":" + user.getPassword());
        User newUser = userService.register(user);
        if (newUser == null) {
            return new Result(ResultCode.UPDATE_OR_INSERT_DATA_FAIL.getCode(), "", null);
        }
        data.put("user", user);
        return new Result(ResultCode.SUCCESS.getCode(), "注册成功", data);
    }

    @ResponseBody
    @PostMapping(value = {"/login"})
    public Result login(String name, String password, HttpServletResponse response) {
        if (name == null || password == null) {
            return new Result(ResultCode.LOGIN_FAIL.getCode(), "login fail", null);
        }
        String token = userService.login(name, password);
        if (token == null) {
            return new Result(ResultCode.LOGIN_FAIL.getCode(), "login fail", null);
        }
        RequestHelper.setCookie(response, token);
        return new Result(ResultCode.SUCCESS.getCode(), "login success", null);
    }

    @ResponseBody
    @GetMapping(value = {"/test"})
    @Teacher
    public void test() {
        System.out.println("test");
    }

    @ResponseBody
    @GetMapping(value = {"/hello"})
    public Result hello() {
        System.out.println("你好");
        return new Result(ResultCode.SUCCESS.getCode(), "你好", null);
    }
}
