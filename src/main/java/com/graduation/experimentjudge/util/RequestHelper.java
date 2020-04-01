package com.graduation.experimentjudge.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author kurizcan
 */
public class RequestHelper {

    /**
     * 获取 cookie 值
     * @param request
     * @param cookieName
     * @return
     */
    public static String getCookie(HttpServletRequest request, String cookieName){

        Cookie[] cookies =  request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals(cookieName)){
                    return cookie.getValue();
                }
            }
        }

        return null;
    }

    public static void setCookie(HttpServletResponse response, String val) {
        Cookie cookie = new Cookie("sessionId", val);
        response.addCookie(cookie);
    }
}
