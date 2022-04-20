package com.neon.academy.openapi;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.authorizeRequests(authz -> authz
      .antMatchers("/swagger-ui.html", "/swagger-ui/**","/api-docs/**").permitAll()
//      .antMatchers(HttpMethod.GET, "/api/zoo/v1/animals/").hasAuthority("SCOPE_list:animal")
      .anyRequest().authenticated()).oauth2ResourceServer(oauth2 -> oauth2.jwt());
  }

}