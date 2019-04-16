package com;

import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.ldap.BasicControl;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
public class MyErrorAttribute implements ErrorViewResolver {
    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
        ModelAndView mv=new ModelAndView("errorPage");
        mv.addObject("custommsg","出错了!");
        mv.addAllObjects(model);
        return mv;
    }



//    @Override
//    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
//        Map<String,Object> errorAttibute=super.getErrorAttributes(webRequest,includeStackTrace);
//        errorAttibute.put("custommsg","出错了！");
//        errorAttibute.remove("error");
//        return errorAttibute;
//    }


}
