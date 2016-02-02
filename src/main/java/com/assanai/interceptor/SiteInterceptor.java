package com.assanai.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
public class SiteInterceptor implements HandlerInterceptor {

    @Autowired
    private MessageSource messageSource;

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        System.out.println("SiteInterceptor preHandle");
        return true;
    }

    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("SiteInterceptor postHandle");


    }

    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception exception)
            throws Exception {
        System.out.println("SiteInterceptor afterCompletion");
        System.out.println("site.maintenance: " + messageSource.getMessage("site.maintenance", null, Locale.ENGLISH));


        System.out.println("site.maintenance: " + messageSource.getMessage("test.param", null, Locale.ENGLISH));
    }


}
