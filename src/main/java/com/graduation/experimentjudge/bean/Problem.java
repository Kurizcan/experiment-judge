package com.graduation.experimentjudge.bean;

import lombok.Data;

/**
 * @author kurizcan
 */
@Data
public class Problem {

    /**
     * 题目编号
     */
    int pid;
    /**
     * 题目标题
     */
    String title;
    /**
     * 题目描述
     */
    String description;
    /**
     * 题目难度
     */
    int difficult;

    /**
     * 数据来源
     */
    String dataSource;

    /**
     * 正确答案
     */
    String answer;

    /**
     *  题解
     */
    String solution;

    /**
     *  是否发布题解
     */
    int open;


}
