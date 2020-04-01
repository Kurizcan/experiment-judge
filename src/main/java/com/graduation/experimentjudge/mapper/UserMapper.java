package com.graduation.experimentjudge.mapper;

import com.graduation.experimentjudge.bean.User;
import com.graduation.experimentjudge.mapper.provider.UserSqlProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;

/**
 * @author kurizcan
 * @date   2020/04/01 22:59
 */
@Component
public interface UserMapper {

    @InsertProvider(type = UserSqlProvider.class, method = "insertUser")
    @Options(useGeneratedKeys = true, keyProperty = "user.id", keyColumn = "id")
    public boolean addUser(@Param("user") User user);

    @SelectProvider(type = UserSqlProvider.class, method = "getUserByName")
    public User getUserByName(@Param("name") String name);



}
