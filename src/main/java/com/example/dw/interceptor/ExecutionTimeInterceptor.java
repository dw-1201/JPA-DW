package com.example.dw.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class ExecutionTimeInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);



        return true;
    }

    @Override
    public void postHandle(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long endTime = System.currentTimeMillis();
        long startTime = (Long)request.getAttribute("startTime");
        long processingTime = endTime-startTime;


        System.out.println("처리시간 : " + processingTime/1000.0 +"s"); //컨트롤러의 처리결과가 나오는데 걸리는 시간

    }

    @Override
    public void afterCompletion(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, Object handler, Exception ex) throws Exception {

        long endTime = System.currentTimeMillis();
        long startTime = (Long)request.getAttribute("startTime");
        long totalTime = endTime-startTime;

        System.out.println("최종시간 : "+ totalTime/1000.0+"s"); //컨트롤러의 처리와 view 렌더링까지 최종적인 결과를 만들어내는 데 걸리는 시간

    }


}
