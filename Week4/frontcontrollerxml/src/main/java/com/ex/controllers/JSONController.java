package com.ex.controllers;

import com.ex.model.Book;
import com.ex.services.JsonSerializer;
import com.google.gson.Gson;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by August Duet on 6/16/2017.
 */
public class JSONController {
    private static AtomicInteger counter = new AtomicInteger();

    public void getBook(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Book b = new Book("How To Win At Life", "Charlie Sheen", 2012);
        String s = new Gson().toJson(b);
        resp.setStatus(200);
        Cookie c = new Cookie("lastBook", s);
        resp.addCookie(c);
        resp.getWriter().write(s);
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.setHeader("Access-Control-Allow-Origin", "http://app.local.com:3001");
    }

    public void addBook(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader reader = req.getReader();

        Book b = (Book) new JsonSerializer().deserialize(reader, Book.class);
        String d = new Gson().toJson(b);

        resp.setStatus(200);
        resp.setHeader("Location", "http://localhost:8085/fc/srv/json/"+counter.getAndIncrement());
        resp.addCookie(new Cookie("lastBook", String.valueOf(counter.get())));
        resp.getWriter().write(d);
    }
}
