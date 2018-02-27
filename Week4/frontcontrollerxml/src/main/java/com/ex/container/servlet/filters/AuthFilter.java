package com.ex.container.servlet.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by August Duet on 6/6/2017.
 */
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse res = (HttpServletResponse)servletResponse;
        System.out.println("Authorizing request from ip " + req.getRemoteAddr());
        String authHeader = req.getHeader("Authorization");

        //continue for request to login
        if(req.getRequestURI().equals("/fc/login")){
            System.out.println("Passing to login");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        if(authHeader == null){
           res.setStatus(401);
           res.setHeader("WWW-Authenticate", "Basic realm=\"MyRealm\"");
           res.sendRedirect("login");
           return;
        }
        //else check token in database
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
