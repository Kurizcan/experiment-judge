package com.graduation.experimentjudge.conversion;

import lombok.Data;

import java.util.Map;

/**
 * @author kurizcan
 */
@Data
public class Result {

    private int code;
    private String message;
    private Map data;

    public Result(int code, String message, Map data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

}
