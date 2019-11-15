package com.sf.blogserver.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import java.io.PrintWriter;

/**
 * @author 92802
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailService userDetailService;

    @Autowired
    AuthenticationAccessDeniedHandler authenticationAccessDeniedHandler;

    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService);
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/index.html", "/static/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //超级管理员可授权
                .antMatchers("/admin/grantPermit").hasRole("ADMIN")
                //普通管理员权限
                .antMatchers("/admin/**").hasRole("ADMIN")
                //评论、发表、点赞、个人空间需登录后可用
                .antMatchers("/comment/post","/article/postArticle","/article/like","/answer/postAnswer","/user/selfSpace").authenticated()
                //其他请求都直接允许
                .anyRequest().permitAll()
                .and().logout().permitAll()
                .and().formLogin().loginPage("/tologin").loginProcessingUrl("/login")
                .usernameParameter("username").passwordParameter("password").permitAll()
                .failureHandler((httpServletRequest, httpServletResponse, e) -> {
                    httpServletResponse.setContentType("application/json;charset=utf-8");
                    PrintWriter out = httpServletResponse.getWriter();
                    StringBuffer sb = new StringBuffer();
                    sb.append("{\"status\":\"error\",\"msg\":\"");
                    if (e instanceof UsernameNotFoundException || e instanceof BadCredentialsException) {
                        sb.append("用户名或密码输入错误，登录失败!");
                    } else if (e instanceof DisabledException) {
                        sb.append("账户被禁用，登录失败，请联系管理员!");
                    } else {
                        sb.append("登录失败!");
                    }
                    sb.append("\"}");
                    out.write(sb.toString());
                    out.flush();
                    out.close();
                }).successHandler((httpServletRequest, httpServletResponse, authentication) -> {
            httpServletResponse.setContentType("application/json;charset=utf-8");
            PrintWriter out = httpServletResponse.getWriter();
            ObjectMapper objectMapper = new ObjectMapper();
            String s = "{\"status\":\"success\",\"data\":" + objectMapper.writeValueAsString((UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal()) + "}";
            out.write(s);
            out.flush();
            out.close();
        }).and().csrf().disable().exceptionHandling().accessDeniedHandler(authenticationAccessDeniedHandler);
    }
}
