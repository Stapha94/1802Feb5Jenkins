package com.revature.services.tests;

import com.revature.beans.User;
import com.revature.dao.UserDao;
import com.revature.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestUserService {

    @Mock
    UserDao mockDao;

    User userCorrect = new User();
    User userIncorrect = new User();

    @Before
    public void setup() throws Exception {
        userCorrect.setUsername("username");
        userIncorrect.setUsername("username");
        userCorrect.setPassword("correct");
        userIncorrect.setPassword("incorrect");

        when(mockDao.getUserByUsername(anyString())) //When calling getUserByUsername(String)
                .thenReturn(userCorrect)  // <-- return that guy
                .thenReturn(userIncorrect); // <-- then that guy
    }

    @Test
    public void testAuthentication() throws Exception {
        UserService service = new UserService(mockDao);
        System.out.println(service.authenticate("username", "correct"));
        System.out.println(service.authenticate("username", "incorerct"));
        System.out.println(service.authenticate("username", "incorrect"));
    }
}
