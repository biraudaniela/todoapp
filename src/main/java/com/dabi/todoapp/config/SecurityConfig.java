package com.dabi.todoapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Configuration
//    @Order(1)
//    @EnableGlobalMethodSecurity(prePostEnabled = true)
//    public static class RestSecurityConfiguration extends WebSecurityConfigurerAdapter {
//        @Autowired
//        private DatabaseUserDetailsService databaseUserDetailsService;
//
//        @Autowired
//        protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//            auth.userDetailsService(databaseUserDetailsService).passwordEncoder(restPasswordEncoder());
//        }
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http
//                    .antMatcher("/api/**")
//                    .cors() //cross origin request site
//                    .and()
//                    .csrf()
//                    .disable()
//                    .authorizeRequests()
//                    //do not allow anything else
//                    .antMatchers("/api/login").permitAll()
//                    .anyRequest().authenticated();
//
//            http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        }
//
//        @Bean
//        public PasswordEncoder restPasswordEncoder() {
//            return new BCryptPasswordEncoder();
//        }
//
//    }

    @Configuration
  // @Order(2)
    public static class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
        @Autowired
        private DatabaseUserDetailsService databaseUserDetailsService;

        @Override
        protected void configure(HttpSecurity http) throws Exception {

            // Disable CSRF (cross site request forgery) - phising
            http.csrf().disable();

            http
                    .authorizeRequests()
                    .antMatchers("/login").permitAll()
                    .antMatchers("/register").permitAll()
                    .antMatchers("/userValidation").permitAll()
                    .antMatchers("/").permitAll()
                    .antMatchers("/images/**").permitAll()
                    .antMatchers("/css/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/login").permitAll()
                    .and()
                    .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/")
                    .permitAll();

        }

        @Override
        public void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(databaseUserDetailsService).passwordEncoder(passwordEncoder());
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Bean
        @Override
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManager();
        }
    }
}
