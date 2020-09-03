package com.deligkarisk.sfgthymeleafdemo.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by jt on 2/2/16.
 */
@Configuration
public class SpringSecConfig extends WebSecurityConfigurerAdapter {


    //Prior to Spring Security 5.0 the default PasswordEncoder was NoOpPasswordEncoder requiring a plain text
    // password. From Spring Security 5, the default has been changed to DelegatingPasswordEncoder, which
    // requires Password Storage Format.
    // See e.g.
    //https://spring.io/blog/2017/11/01/spring-security-5-0-0-rc1-released#password-storage-formatguru
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin").password("{noop}admin").roles("ADMIN", "USER")
                .and().withUser("user").password("{noop}user").roles( "USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/", "/index/**", "/product/**", "/checkout", "/docheckout").permitAll()
                .and().authorizeRequests().antMatchers("/login","logout").permitAll()
                .and().authorizeRequests().antMatchers("/static/css/**","/js/**", "/images/**", "/**/favicon.ico").permitAll()
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/").permitAll()
                .and().logout()
                .deleteCookies("remove")
                .invalidateHttpSession(true)
                .logoutUrl("/logout")
                .logoutSuccessUrl("/logout-success")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        ;
    }
}