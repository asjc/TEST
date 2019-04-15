package com.example.vue.util.security;

import com.example.vue.util.RespBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class AccessHandler implements AccessDeniedHandler {

    /**
     * 提供实例返回授权失败信息
     * @param request
     * @param response
     * @param e
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        response.setStatus(response.SC_FORBIDDEN);
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out=response.getWriter();
        RespBean error=RespBean.error("权限不足！");
        //将对象转为String输出授权信息
        out.write(new ObjectMapper().writeValueAsString(error));
        out.flush();
        out.close();
    }
}
