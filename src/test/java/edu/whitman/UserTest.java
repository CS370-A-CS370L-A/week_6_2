package edu.whitman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;

public class UserTest {
    private User user;

    @BeforeEach
    public void setUp(){
        user = new User("Robert", "Brown", 10);
    }

    @Test
    public void testUserInformation(){
        assertEquals(user.getFirstName(), "Robert");
        assertEquals(user.getLastName(), "Brown");
        assertEquals(user.getId(), 10);
    }
}