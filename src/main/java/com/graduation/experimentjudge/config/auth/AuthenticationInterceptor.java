package com.graduation.experimentjudge.config.auth;

import com.graduation.experimentjudge.config.auth.annotation.Admin;
import com.graduation.experimentjudge.config.auth.annotation.Student;
import com.graduation.experimentjudge.config.auth.annotation.Teacher;
import com.graduation.experimentjudge.util.Constant;
import com.graduation.experimentjudge.util.RequestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author kurizcan
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    Authentication authentication;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        // 从 http 请求头中取出 token
        String token = RequestHelper.getCookie(request, "sessionId");
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        // 验证是否有效或者过期
        if (token != null && !authentication.validToken(token)) {
            return false;
        }
        //检查权限
        if (method.isAnnotationPresent(Teacher.class) && Constant.TYPE_TEACHER != authentication.getTypeFormToken(token)) {
            // 权限不足，401
            System.out.println("no teacher");
            return false;
        }
        if (method.isAnnotationPresent(Student.class) && Constant.TYPE_STUDENT != authentication.getTypeFormToken(token)) {
            return false;
        }
        if (method.isAnnotationPresent(Admin.class) && Constant.TYPE_ADMIN != authentication.getTypeFormToken(token)) {
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
