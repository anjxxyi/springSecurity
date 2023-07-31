package com.springboot.anjaeyi.exam.config;

import com.springboot.anjaeyi.exam.service.UserDetailService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@Component
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    private final UserDetailService userDetailService;

    @Bean
    public WebSecurityCustomizer configure() {
        return (web) -> web
                .ignoring()
                .requestMatchers(toH2Console()
                );
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
        MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);
        return http
                .csrf((csrf) -> csrf.disable())
                .formLogin((formlogin) -> formlogin
                        .loginPage("/login")
                        .defaultSuccessUrl("/", true)
                )
                .authorizeHttpRequests((authorize) -> authorize
                    .requestMatchers(mvcMatcherBuilder.pattern("/login")).permitAll()
                    .requestMatchers(mvcMatcherBuilder.pattern("/signup")).permitAll()
                    .requestMatchers(mvcMatcherBuilder.pattern("/user")).permitAll()
                    .anyRequest().authenticated()
                ).build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public WebSecurityConfig(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }
}