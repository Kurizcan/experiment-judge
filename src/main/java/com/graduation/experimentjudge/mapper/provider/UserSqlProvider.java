package com.graduation.experimentjudge.mapper.provider;

import com.graduation.experimentjudge.bean.User;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author kurizcan
 * @create 2020/04/01 22:59
 */
public class UserSqlProvider {

    public static final String table = "tb_user_info";

    public String insertUser(User user) {
        return new SQL(){{
            UPDATE(table);
            SET("password = #{password}");
            SET("name = #{name}");
            SET("type = #{type}");
            SET("classId = #{classId}");
            SET("gradeId = #{gradeId}");
            SET("major = #{major}");
        }}.toString();
    }

    public String getUserByName(String name) {
        return new SQL()
                .SELECT("*")
                .FROM(table)
                .WHERE("name = #{name}")
                .toString();
    }
}
