package com.graduation.experimentjudge.bean;

import lombok.Data;

/**
 * @author kurizcan
 */
@Data
public class User {
    /**
     * 用户 id
     */
    int id;
    /**
     * 姓名
     */
    String name;
    /**
     * 密码
     */
    String password;
    /**
     * 用户类型
     */
    int type;
    /**
     * 班级 id
     */
    String classId;
    /**
     * 专业
     */
    String major;
}
