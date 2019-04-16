package com.chapter13;

import com.entity.User;
import com.service.MailService;

//import freemarker.template.Configuration;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.swing.text.AbstractDocument;
import java.io.File;
import java.io.StringWriter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter13ApplicationTests {
    @Autowired
    MailService mailService;

    @Autowired
    TemplateEngine templateEngine;

    @Test
    public void contextLoads() {
        mailService.sendSimpleMail("2973749839@qq.com","2973749839@qq.com","2973749839@qq.com","测试邮箱主题","测试邮箱内容");
    }

    @Test
    public void senMailMessage(){
        mailService.sendAttachFileMail("2973749839@qq.com","2973749839@qq.com","测试邮箱主题","测试邮箱内容",new File("E:\\邮箱附件.txt"));
    }

    @Test
    public void sendMailWithImg(){
        mailService.sendMailWithImg("2973749839@qq.com","2973749839@qq.com","测试邮箱主题(图片)",
                "<div>hello,这是一封带图片资源的邮件:"+
                        "这是图片1:<div><img src='cid:p01'/></div>" +
                        "这是图片2:<div><img src='cid:p02'/></div>" +
                        "</div>",
                new String[]{"D:\\360Downloads\\p1.jpg","D:\\360Downloads\\p2.jpg"},new String[]{"p01","p02"});
    }

//    freeMarket
    @Test
    public void sendHtmlMail(){
        try {
            Configuration configuration=new Configuration(Configuration.VERSION_2_3_0);
            ClassLoader loader=Chapter13ApplicationTests.class.getClassLoader();
            configuration.setClassLoaderForTemplateLoading(loader,"flt");
            Template template=configuration.getTemplate("mailtemplate.flt.html");
            StringWriter mail=new StringWriter();
            User user=new User();
            user.setGender("男");
            user.setUsername("江南一点雨");
            template.process(user,mail);
            mailService.senddHtmlMail("2973749839@qq.com","2973749839@qq.com","测试邮箱主题",mail.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void sendHtmlMailThymeleaf(){
        Context context=new Context();
        context.setVariable("username","sang");
        context.setVariable("gender","男");
        String mail=templateEngine.process("mailtemplate.html",context);
        mailService.senddHtmlMail("2973749839@qq.com","2973749839@qq.com","测试邮箱主题",mail);
    }






}
