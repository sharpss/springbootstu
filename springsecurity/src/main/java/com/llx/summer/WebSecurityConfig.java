package com.llx.summer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Auther: sharps
 * @Date: 19-4-2 15:07
 * @Description:
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/home").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .and()
                .logout()
                    .permitAll();
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //可以设置内存指定的登录的账号密码,指定角色
        //不加.passwordEncoder(new MyPasswordEncoder())
        //就不是以明文的方式进行匹配，会报错
        //        auth
//                .inMemoryAuthentication()
//                .withUser("admin").password("admin").roles("ADMIN");
        //.passwordEncoder(new MyPasswordEncoder())。这样，页面提交时候，密码以明文的方式进行匹配。
       MyPasswordEncoder myPasswordEncoder = new MyPasswordEncoder();
        auth.inMemoryAuthentication()
                .passwordEncoder(myPasswordEncoder)
                .withUser("admin")
                .password("admin")
                .roles("ADMIN");

    }
}
