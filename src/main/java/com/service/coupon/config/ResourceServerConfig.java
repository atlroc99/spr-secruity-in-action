package com.service.coupon.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
//@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    private static final String RESOURCE_ID = "couponid";
    private static final String COUPON_URL = "/couponApi/coupons";

    // FIRST CONFIG- to configure the resources you want to protect
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(RESOURCE_ID);
    }

    // configure security -> authorization with mvcmatcher
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers(HttpMethod.GET, "/", COUPON_URL + "/" + "{code:^[A-Z]*$}")
                .hasAnyRole("ADMIN", "USER")
                .mvcMatchers(HttpMethod.POST, COUPON_URL + "/")
                .hasRole("ADMIN")
                .anyRequest().denyAll()//if user dose without role - user or admin
                .and()
                .csrf()
                .disable();


    }
}
