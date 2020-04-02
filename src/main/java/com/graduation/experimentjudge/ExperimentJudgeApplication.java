package com.graduation.experimentjudge;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.graduation.experimentjudge.mapper")
public class ExperimentJudgeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExperimentJudgeApplication.class, args);
    }

}
