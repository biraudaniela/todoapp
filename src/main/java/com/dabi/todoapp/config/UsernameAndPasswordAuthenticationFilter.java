package com.dabi.todoapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class UsernameAndPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private static final String BEARER = "Bearer";

    @Autowired
    private DatabaseUserDetailsService databaseUserDetailsService;

    public UsernameAndPasswordAuthenticationFilter(DatabaseUserDetailsService databaseUserDetailsService) {
        this.databaseUserDetailsService = databaseUserDetailsService;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        String headerValue = ((HttpServletRequest)req).getHeader("Authorization");
        getTokenFromHeader(headerValue).ifPresent(
                token -> {
                    databaseUserDetailsService.loadUserByJwtToken(token).ifPresent(
                            userDetails -> {
                                SecurityContextHolder.getContext().setAuthentication(
                                        new PreAuthenticatedAuthenticationToken(userDetails, "", new ArrayList<>())
                                );
                            }
                    );
                }
        );

        chain.doFilter(req, res);

    }

    // Bearer tokenstring
    private Optional<String> getTokenFromHeader(String headerValue) {
        if(headerValue != null && headerValue.startsWith(BEARER)) {
            return Optional.of(headerValue.substring(7));
            //return Optional.of(headerValue.replace(BEARER, "").trim())
        }

        return Optional.empty();

    }



}
