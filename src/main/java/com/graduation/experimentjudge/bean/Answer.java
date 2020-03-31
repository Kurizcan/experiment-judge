package com.graduation.experimentjudge.bean;

import lombok.Data;

/**
 * @author asus
 */
@Data
public class Answer {
    /**
     * 编号
     */
    int id;
    /**
     * 学生 id
     */
    int studentId;

    /**
     * 试题组
     */
    int groupId;

    /**
     * 试题编号
     */
    int problemId;

    /**
     * 学生答案
     */
    String answer;

    /**
     * 试题得分
     */
    int score;
}
