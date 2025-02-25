package edu.whitman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;

public class AccountTest{
    private Account accountOne;
    private User userOne;
    @BeforeEach
    public void setUp(){
        userOne = new User("Emily", "Johson", 2);
        accountOne = new Account(userOne, 1, 200.0);
    }

    @Test
    public void testGetUser(){
        assertEquals(accountOne.getUser(), userOne);
    }

    @Test
    public void testGetAccountNumber(){
        assertEquals(accountOne.getAccountNumber(), 0001);
    }

    @Test
    public void testGetBalance(){
        assertEquals(accountOne.getBalance(), 200.0);
    }

    @Test
    public void testDeposit(){
        accountOne.deposit(400.0);
        assertEquals(accountOne.getBalance(), 600.0);
    }

    @Test
    public void testGetDepositNegativeAmount(){
        assertThrows(IllegalArgumentException.class, () -> {
           accountOne.deposit(-100.0);
        });
    }

    @Test
    public void testWhitdraw(){
        accountOne.withdraw(50.0);
        assertEquals(accountOne.getBalance(), 150.0);
    }

    @Test
    public void testWithdrawNoFunds() {
        assertThrows(IllegalArgumentException.class, () -> {
            accountOne.withdraw(201.0);
        });
    }
}