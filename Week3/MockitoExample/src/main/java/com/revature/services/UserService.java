package com.revature.services;

import com.revature.beans.User;
import com.revature.dao.UserDao;

public class UserService {

    UserDao dao = new UserDao();

    public UserService() {

    }

    public UserService(UserDao dao) {
        this.dao = dao;
    }

    public boolean authenticate(String username, String password) {
        User user = dao.getUserByUsername(username);

        return user.getPassword().equals(password);
    }
}
