package com.revature.dao.tests;

import com.revature.beans.User;
import com.revature.dao.UserDao;
import com.revature.util.ConnectionUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestUserDao {

    @Mock
    ConnectionUtil cu;

    @Mock
    Connection conn;

    @Mock
    PreparedStatement ps;

    @Mock
    ResultSet results;

    @Before
    public void setup() throws Exception {
        when(cu.getConnection()).thenReturn(conn);
        when(conn.prepareStatement(anyString())).thenReturn(ps);
        when(ps.executeQuery()).thenReturn(results);
        when(results.next()).thenReturn(true).thenReturn(false);
        when(results.getInt(anyString())).thenReturn(1);
    }

    @Test
    public void testSaveUser() throws Exception {
        UserDao dao = new UserDao(cu);
        User newUser = new User();
        newUser.setUsername("username");
        newUser.setPassword("password");
        dao.saveUser(newUser);
        assertTrue(1 == newUser.getId());
    }
}
