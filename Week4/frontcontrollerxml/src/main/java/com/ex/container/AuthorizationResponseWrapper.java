package com.ex.container;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

/**
 * Created by August on 6/18/2017.
 */
public class AuthorizationResponseWrapper extends HttpServletResponseWrapper {

    int status;
    String authHeader;
    public AuthorizationResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    @Override
    public void sendError(int sc, String msg) throws IOException {
        super.sendError(sc, msg);
    }

    @Override
    public void sendError(int sc) throws IOException {
        status = sc;
        super.sendError(sc);
    }

    @Override
    public void setStatus(int sc) {
        status = sc;
        super.setStatus(sc);
    }

    @Override
    public void setStatus(int sc, String sm) {
        status = sc;
        super.setStatus(sc, sm);
    }

    @Override
    public void setHeader(String name, String value) {
        if(name.equals("Authorization")){
            authHeader = value;
        }
        super.setHeader(name, value);
    }

    public int getStatus(){
        return this.status;
    }

    public String getAuthHeader(){
        return this.authHeader;
    }
}
