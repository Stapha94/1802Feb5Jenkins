package com.revature.tree.controllers;

import com.google.gson.Gson;
import com.revature.tree.beans.Employee;
import com.revature.tree.services.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/login-info"})
public class LoginServlet extends HttpServlet {

    private static EmployeeService myEmployeeService = new EmployeeService();
    private static Gson gson = new Gson();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servicing the request");
        super.service(req, resp);
//        PrintWriter out = resp.getWriter();
//        out.write("Hello, from my first servlet");
//        resp.setStatus(200);
//        resp.setHeader("Content-Type", "text/plain");
    }

    @Override
    public void destroy() {
        System.out.println("Servlet being destroyed");
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Initializing the servlet");
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if(myEmployeeService.employeeExists(email)){

            if(myEmployeeService.compareHash(password, myEmployeeService.getByEmail(email))){

                String employeeInJson = gson.toJson(myEmployeeService.getByEmail(email));
                out.write(employeeInJson);
                out.flush();

            }


        }


    }
}
