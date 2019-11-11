package com.gl.authentication.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.gl.authentication.server.security.JwtAuthenticationEntryPoint;
import com.gl.authentication.server.security.JwtAuthenticationFilter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
  
  @Autowired
  UserDetailsService userDetailsService;
  
  @Autowired
  private JwtAuthenticationEntryPoint unauthorizedHandler;
  
  @Bean
  public JwtAuthenticationFilter jwtAuthenticationFilter() {
      return new JwtAuthenticationFilter();
  }
  
  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
      return super.authenticationManagerBean();
  }
  
  @Bean
  public PasswordEncoder passwordEncorder(){
    return new BCryptPasswordEncoder();
  }
  
  @Override
  protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
    authenticationManagerBuilder.userDetailsService(userDetailsService)
    .passwordEncoder(passwordEncorder());
  }
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.cors().and().csrf().disable().exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
    .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    .and().authorizeRequests().antMatchers(
    "/",
    "/favicon.ico",
    "/**/*.png",
    "/**/*.gif",
    "/**/*.svg",
    "/**/*.jpg",
    "/**/*.html",
    "/**/*.css",
    "/**/*.js")
    .permitAll()
.antMatchers("/api/auth/**")
    .permitAll()
.antMatchers("/api/user/checkUsernameAvailability", "/api/user/checkEmailAvailability")
    .permitAll()
.antMatchers(HttpMethod.GET, "/api/polls/**", "/api/users/**")
    .permitAll()
.anyRequest()
    .authenticated();

// Add our custom JWT security filter
http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    
  }
  

}
