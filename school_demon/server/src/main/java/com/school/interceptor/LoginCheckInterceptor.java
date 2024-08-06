package com.school.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.school.result.Result;
import com.school.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取地址
        String url=request.getRequestURI().toString();
        //判断是否包含login
        if (url.contains("login") ) {
            log.info("登录操作");
            return true;
        }
        if (url.contains("register") ) {
            log.info("注册操作");
            return true;
        }
        //获取token
        String jwt=request.getHeader("token");
        //判断令牌是否存在
        if(!StringUtils.hasLength(jwt)){
            log.info("请求头为空");
            Result error= Result.error("未登录");
            //手动转换对象
            String notLogin= JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        }
        //解析token
        try{
            JwtUtil.parseJWT(jwt);
        }catch (Exception e){
            //解析失败
            e.printStackTrace();
            log.info("令牌解析失败");
            Result error=Result.error("未登录");
            //手动转换json对象
            String notLogin=JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        }
        //放行
        log.info("令牌合法");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
