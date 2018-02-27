package com.revature.dao;

import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    ConnectionUtil connectionUtil = ConnectionUtil.getConnectionUtil();

    public UserDao() {

    }

    /**
     * This method should only be used in testing.
     * @param util - Connection Util
     */
    public UserDao(ConnectionUtil util) {
        this.connectionUtil = util;
    }

    /**
     * Gets a user given a username
     * @param username - username to search for
     * @return retrieved username object
     */
    public User getUserByUsername(String username) {
        return null;
    }

    public void saveUser(User user) {
        try(Connection conn = connectionUtil.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?) RETURNING id");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ResultSet results = ps.executeQuery();
            if(results.next()) {
                user.setId(results.getInt("id"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
