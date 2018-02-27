package com.ex.services;

import com.ex.model.chinook.Employee;

import java.util.Date;
import java.util.Random;

/**
 * Created by August on 6/18/2017.
 */
public class AuthService {

    public static boolean authorize(Employee e){
        return true;
    }

    public static String getToken(Employee e){
        long ms = new Date().getTime();
        String s= "aABbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz0123456789";
        Random r = new Random(ms);
        String token = new String();
        for(int i = 0; i < 16; i++){
            token += s.charAt(0 + r.nextInt(s.length() - 1));
        }

        return token.concat(","+e.getPin());
    }
}
