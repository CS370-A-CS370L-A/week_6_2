package edu.whitman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;

public class BankTest{
    private Bank bank;
    private Account userAccount;
    private User user;

    @BeforeEach
    public void setUp(){
        user = new User("Robert", "Brown", 10);
        userAccount = new Account(user, 1, 300.0);
        bank = new Bank("Washington Bank");
    }

    @Test
    public void testGetBankName(){
        assertEquals(bank.getName(), "Washington Bank");
    }

    @Test
    public void testGetAccounts(){
        assertNotNull(bank.getAccounts());
    }

    @Test
    public void testAddAccount(){
        bank.addAccount(userAccount);
        assertEquals(bank.getAccounts().size(), 1);
    }

    @Test
    public void testGetAccount(){
        bank.addAccount(userAccount);
        assertEquals(bank.getAccount(1), userAccount);
    }

    @Test
    public void testDeposit(){
        bank.addAccount(userAccount);
        bank.deposit(1, 300.0);
        assertEquals(600.0, userAccount.getBalance());
    }

    @Test
    public void testDepositNoUser(){
        assertThrows(IllegalArgumentException.class, () -> {
            bank.deposit(1, 300.0);
        });
    }

    @Test
    public void testWithdraw(){
        bank.addAccount(userAccount);
        bank.withdraw(1, 200.0);
        assertEquals(100.0, userAccount.getBalance());
    }
}