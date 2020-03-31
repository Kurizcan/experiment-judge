package com.graduation.experimentjudge.bean;

import lombok.Data;

/**
 * @author kurizcan
 */
@Data
public class ClassInfo {
    /**
     * 年级
     */
    String grade;
    /**
     * 班级 id
     */
    String classId;
    /**
     * 班级名称
     */
    String className;
    /**
     * 专业
     */
    String major;
    /**
     * 人数
     */
    String nums;
}
