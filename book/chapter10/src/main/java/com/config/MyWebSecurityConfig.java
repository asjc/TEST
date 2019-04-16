//package com.config;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.authentication.AccountExpiredException;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.LockedException;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.CredentialsContainer;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.logout.LogoutHandler;
//import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//public class MyWebSecurityConfig {
//    @Bean
//    PasswordEncoder passwordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
//    }
//    @Autowired
//    protected void config(AuthenticationManagerBuilder auth)throws Exception{
//        auth.inMemoryAuthentication()
//        .withUser("admin").password("123").roles("ADMIN","USER")
//        .and()
//        .withUser("sang").password("123").roles("USER");
//    }
//
//    @Configuration
//    @Order(1)
//    public static class AdminSecurityConfig extends  WebSecurityConfigurerAdapter{
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http.antMatcher("/admin/**").authorizeRequests()
//                    .anyRequest().hasRole("ADMIN");
//        }
//    }
//    @Configuration
//    public static class OtherSecurityConfig extends WebSecurityConfigurerAdapter{
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http.authorizeRequests()
//                    .anyRequest()
//                    .authenticated()
//                    .and()
//                    .formLogin()
//                    .loginProcessingUrl("login")
//                    .permitAll()
//                    .and()
//                    .csrf()
//                    .disable();
//        }
//    }
//
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////       auth.inMemoryAuthentication()
////               .withUser("root").password("123").roles("ADMIN","DBA")
////               .and()
////               .withUser("admin").password("123").roles("ADMIN","USER")
////               .and()
////               .withUser("sang").password("123").roles("USER");
////    }
////
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.authorizeRequests()
////                .antMatchers("/amdin/**")
////                .hasRole("ADMIN")
////                .antMatchers("/user/**")
////                .access("hasAnyRole('ADMIN','USER')")
////                .antMatchers("/db/**")
////                .access("hasRole('ADMIN') AND hasRole('DBA')")
////                .anyRequest()
////                .authenticated()
////                .and()
////                .formLogin()
////                .loginPage("/login_page")
////                .loginProcessingUrl("/login")
////                .usernameParameter("name")
////                .passwordParameter("passwd")
////                .successHandler(new AuthenticationSuccessHandler() {
////                    @Override
////                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
////                        Object principal=authentication.getPrincipal();
////                        PrintWriter out=httpServletResponse.getWriter();
////                        httpServletResponse.setStatus(200);
////                        Map<String,Object> map=new HashMap<>();
////                        map.put("status",200);
////                        map.put("msg",principal);
////                        ObjectMapper om=new ObjectMapper();
////                        out.write(om.writeValueAsString(map));
////                        out.flush();
////                        out.close();
////                    }
////                })
////                .failureHandler(new AuthenticationFailureHandler() {
////                    @Override
////                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
////                        httpServletResponse.setContentType("application/json;charset=utf-8");
////                        PrintWriter out=httpServletResponse.getWriter();
////                        Map<String,Object> map=new HashMap<>();
////                        map.put("status",401);
////                        if(e instanceof LockedException){
////                            map.put("msg","账号被锁定，登入失败！");
////                        }else if(e instanceof BadCredentialsException){
////                            map.put("msg","账号或密码错误，登入失败！");
////                        }else if(e instanceof DisabledException){
////                            map.put("msg","账号被禁用，登入失败！");
////                        }else if(e instanceof AccountExpiredException){
////                            map.put("msg","账号已过期，登入失败！");
////                        }else if (e instanceof CredentialsContainer){
////                            map.put("msg","密码已过期，登入失败！");
////                        }else{
////                            map.put("msg","登入失败！");
////                        }
////                        ObjectMapper om=new ObjectMapper();
////                        out.write(om.writeValueAsString(map));
////                        out.flush();
////                        out.close();
////                    }
////                })
////                .permitAll()
////                .and()
////                .csrf()
////                .disable();
////    }
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.authorizeRequests()
////                .antMatchers("/amdin/**")
////                .hasRole("ADMIN")
////                .antMatchers("/user/**")
////                .access("hasAnyRole('ADMIN','USER')")
////                .antMatchers("/db/**")
////                .access("hasRole('ADMIN') AND hasRole('DBA')")
////                .anyRequest()
////                .authenticated()
////                .and()
////                .logout()
////                .logoutUrl("/logout")
////                .clearAuthentication(true)
////                .invalidateHttpSession(true)
////                .addLogoutHandler(new LogoutHandler() {
////                    @Override
////                    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
////                    }
////                }).logoutSuccessHandler(new LogoutSuccessHandler() {
////            @Override
////            public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
////                httpServletResponse.sendRedirect("/login_page");
////            }
////        }) .and()
////                .csrf()
////                .disable();
////    }
//
//
//
//
//}
