package com.ex.container.filter;

import com.ex.container.AuthorizationResponseWrapper;
import com.ex.data.inmem.InMemDB;
import com.ex.data.inmem.UserTokensDB;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by August on 6/17/2017.
 */
public class AuthorizationFilter implements Filter {

    private InMemDB<String, Object> tokens;
    private FilterConfig config;
    private String contextPath;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        tokens = new UserTokensDB(1300);
        tokens.open();
        this.config = filterConfig;
        contextPath = filterConfig.getServletContext().getContextPath();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        String header = req.getHeader("Authorization");

        String inPath = req.getRequestURI().substring(contextPath.length());
        if(inPath.equals("/srv/authorize/token")){
            AuthorizationResponseWrapper wrapper = new AuthorizationResponseWrapper(res);
            filterChain.doFilter(req, wrapper);

            if(wrapper.getStatus() == HttpServletResponse.SC_OK){
                String auth = wrapper.getAuthHeader();
                String[] parts = auth.split(",");
                String token = parts[0];
                String secret = parts[1];
                tokens.set(secret, token);
            }
            return;
        }

        if(inPath.equals("/srv/authorize/refresh")){
            System.out.println("Refresh Token");
            String parts[] = header.split(",");
            String secret = parts[1];

            if(((UserTokensDB)tokens).refresh(secret)){
                res.setStatus(HttpServletResponse.SC_OK);
                return;
            }else{
                res.sendError(HttpServletResponse.SC_FORBIDDEN);
                return;
            }
        }

        if(header == null){
            res.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }else{
            //tokens are token, secret
            String[] parts = header.split(",");
            String token = parts[0];
            String secret = parts[1];
            String data = (String)tokens.get(secret);

            if(!token.equals(data)){
                res.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }

        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        tokens.clear();
        tokens.close();
    }
}
