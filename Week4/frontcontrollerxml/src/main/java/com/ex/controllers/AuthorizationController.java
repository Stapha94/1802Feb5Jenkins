package com.ex.controllers;

import com.ex.model.chinook.Employee;
import com.ex.services.AuthService;
import com.ex.services.JsonSerializer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by August on 6/18/2017.
 */
public class AuthorizationController {
    public void authorize(HttpServletRequest request, HttpServletResponse response) throws IOException{
        Employee e = (Employee) new JsonSerializer().deserialize(request.getReader(), Employee.class);

        if(AuthService.authorize(e)){
            response.setStatus(200);
            response.setHeader("Authorization", AuthService.getToken(e));
        }else{
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException{

    }
}
