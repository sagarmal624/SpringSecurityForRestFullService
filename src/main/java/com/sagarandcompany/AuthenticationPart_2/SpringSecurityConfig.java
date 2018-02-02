package com.sagarandcompany.AuthenticationPart_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        BasicAuthenticationEntryPoint bauth = new BasicAuthenticationEntryPoint();
        bauth.setRealmName("sagarandcompany");
        http
                .authorizeRequests()
                .antMatchers("/emp").hasRole("ADMIN")
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic().authenticationEntryPoint(bauth);
    }

//    In Memory Authentication with Role
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("sagar").password("pas").roles("USER");
//    }


    //Multiple user with role
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("sagar").password("tsys").roles("USER");
        auth.inMemoryAuthentication().withUser("UMA").password("12345").roles("ADMIN");
    }


//Basic Authencation

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        BasicAuthenticationEntryPoint bauth = new BasicAuthenticationEntryPoint();
//        bauth.setRealmName("sagarandcompany");
//        http.authorizeRequests()
//                .anyRequest().authenticated()
//                .and().httpBasic()
//                .authenticationEntryPoint(bauth);
//    }

//Multiplese mathers

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        BasicAuthenticationEntryPoint bauth = new BasicAuthenticationEntryPoint();
//        bauth.setRealmName("sagarandcompany");
//        http.requestMatchers()
//                .antMatchers("/hello/**", "/emp/**")
//                .and()
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and().httpBasic()
//                .authenticationEntryPoint(bauth);
//    }


// Role Based Authentication
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        BasicAuthenticationEntryPoint bauth = new BasicAuthenticationEntryPoint();
//        bauth.setRealmName("sagarandcompany");
//        http.requestMatchers()
//                .antMatchers("/hello/**", "/emp/**")
//                .and()
//                .authorizeRequests()
//                .anyRequest().hasRole("ADMIN")
//                .and().httpBasic()
//                .authenticationEntryPoint(bauth);
//    }
//


//Multilple roles with multiple user

//    @Override
//protected void configure(HttpSecurity http) throws Exception {
//    BasicAuthenticationEntryPoint bauth = new BasicAuthenticationEntryPoint();
//    bauth.setRealmName("sagarandcompany");
//    http
//            .authorizeRequests()
//            .antMatchers("/hello/**", "/emp/**")
//            .hasRole("ADMIN")
//            .and()
//
//            .authorizeRequests().antMatchers("/user/**")
//            .hasRole("USER")
//            .and()
//            .httpBasic()
//            .authenticationEntryPoint(bauth);
//}
//
//


}