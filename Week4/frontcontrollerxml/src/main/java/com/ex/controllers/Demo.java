package com.ex.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by August Duet on 6/6/2017.
 */
public class Demo {

    public void handleGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        String out = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                "    <title>Document</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>Your front controller works for a GET</h1>\n" +
                "</body>\n" +
                "</html>";
        resp.setStatus(200);
        resp.setContentType("text/html");
        resp.getWriter().write(out);
    }

    public void handlePost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        String out = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                "    <title>Document</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>Your front controller works for a POST</h1>\n" +
                "</body>\n" +
                "</html>";
        resp.setStatus(200);
        resp.setContentType("text/html");
        resp.getWriter().write(out);
    }
}
