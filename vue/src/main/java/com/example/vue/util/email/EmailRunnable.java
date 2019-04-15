package com.example.vue.util.email;


import com.example.vue.pojo.Employee;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;

public class EmailRunnable implements Runnable{
    private Employee employee;
    private JavaMailSender javaMailSender;
    private TemplateEngine templateEngine;
    public EmailRunnable(Employee employee,JavaMailSender javaMailSender,TemplateEngine templateEngine){
        this.employee=employee;
        this.javaMailSender=javaMailSender;
        this.templateEngine=templateEngine;
    }
    @Override
    public void run() {
        MimeMessage message=javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setTo(employee.getEmail());
            helper.setFrom("2429164843@qq.com");
            helper.setSubject("XXX集团:通知");
            Context ctx=new Context();
            ctx.setVariable("name",employee.getName());
            ctx.setVariable("workId",employee.getWorkID());
            ctx.setVariable("form",employee.getEngageForm());
            ctx.setVariable("beginContract",employee.getBeginContract());
            ctx.setVariable("endContract",employee.getEndContract());
            ctx.setVariable("departmentName",employee.getDepartmentName());
            ctx.setVariable("posName",employee.getPosName());
            String mail=templateEngine.process("email.html",ctx);
            helper.setText(mail,true);
            javaMailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
