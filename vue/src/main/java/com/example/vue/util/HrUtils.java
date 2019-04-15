package com.example.vue.util;

import com.example.vue.pojo.Hr;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HrUtils {

    /**
     * 获取登录信息
     * @return
     */
    public static Hr getCurrentHr(){
        return (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    /**
     * 返回结果信息
     * @param response
     * @param respBean
     * @throws IOException
     */
    public static void retrunRespBean(HttpServletResponse response, RespBean respBean)throws IOException {
        ObjectMapper om=new ObjectMapper();
        PrintWriter out=response.getWriter();
        out.write(om.writeValueAsString(respBean));
        out.flush();
        out.close();
    }
}
