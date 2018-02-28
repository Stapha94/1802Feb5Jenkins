package com.revature.dao.tests;

import com.revature.MockitoExtension;
import com.revature.beans.User;
import com.revature.dao.UserDao;
import com.revature.services.UserService;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class TestUserService {

    @Mock
    UserDao mockDao;
    User userCorrect = new User();
    User userIncorrect = new User();

    @BeforeEach
    public void setup() throws Exception{
        userCorrect.setUsername("username");
        userIncorrect.setUsername("username");
        userCorrect.setPassword("correct");
        userIncorrect.setPassword("incorrect");

        when(mockDao.getUserByUsername(anyString()))
                .thenReturn(userCorrect)
                .thenReturn(userIncorrect);

    }

    @Test
    public void authentication() throws Exception {

        UserService myService = new UserService(mockDao);
        System.out.println(myService.authenticate("username", "correct"));
        System.out.println(myService.authenticate("username", "incorrect"));


    }

}
