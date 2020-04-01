package com.graduation.experimentjudge.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author  kurizcan
 * @create 2020/04/01 22:42
 */
public class BcryptUtil {


    public static String encode(String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(password);
    }

    public static boolean match(String password, String encodedPassword) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.matches(password, encodedPassword);
    }
}
