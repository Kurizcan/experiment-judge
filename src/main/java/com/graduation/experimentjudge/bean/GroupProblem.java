package com.graduation.experimentjudge.bean;

import lombok.Data;

import java.util.ArrayList;

/**
 * @author kurizcan
 */
@Data
public class GroupProblem {

    int groupId;
    ArrayList<Problem> problemIdList = new ArrayList<>();
}
