package com.mathseiw.quizz.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

public class MyBasicAuthenticationEntryPoint
        extends LoginUrlAuthenticationEntryPoint {

    public MyBasicAuthenticationEntryPoint( final String loginFormUrl ) {
        super( loginFormUrl );
    }

    @Override
    public void commence( HttpServletRequest request, HttpServletResponse response,
            org.springframework.security.core.AuthenticationException authException ) throws IOException, ServletException {
        System.out.println( "commence" );
        if ( "XMLHttpRequest".equals( request.getHeader( "X-Requested-With" ) ) ) {
            response.sendError( 403, "Forbidden" );
        } else {
            super.commence( request, response, authException );
        }
    }
}