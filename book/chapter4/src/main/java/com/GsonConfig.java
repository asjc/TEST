package com;

//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GsonConfig {

    @InitBinder("b")
    public void init(WebDataBinder binder){
        binder.setFieldDefaultPrefix("b.");

    }
    @InitBinder("a")
    public void init2(WebDataBinder binder){
        binder.setFieldDefaultPrefix("a.");

    }



//    @ModelAttribute(value = "info")
//    public Map<String,String> userinfo(){
//        HashMap<String,String> map=new HashMap<String,String>();
//        map.put("username","罗贯中");
//        map.put("gender","男");
//        return map;
//    }


//    @Bean
//    GsonHttpMessageConverter gsonHttpMessageConverter(){
//        GsonHttpMessageConverter converter=new GsonHttpMessageConverter();
//        GsonBuilder builder=new GsonBuilder();
//        builder.setDateFormat("yyyy-MM-dd");
//        builder.excludeFieldsWithModifiers(Modifier.PROTECTED);
//        Gson gson=builder.create();
//        converter.setGson(gson);
//        return converter;
//    }



}
