package com.harm.service;

import com.harm.vo.AccountRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {
    Logger logger = LoggerFactory.getLogger(AccountServiceTest.class);
    @Autowired
    AccountService accountService;

    String testName = this.getClass().getSimpleName() + "-name";
    String testEmail = this.getClass().getSimpleName() + "-email";
    String[] testServiceTypes = new String[]{"M", "I"};
    @Test
    public void createAccount() {
        AccountRequest accountRequest = new AccountRequest();
        accountRequest.setName(testName);
        accountRequest.setEmail(testEmail);
        assertTrue(accountService.createAccount(accountRequest));
    }

    @Test
    public void modifyAccount() {
        createAccount();

        AccountRequest accountRequest = new AccountRequest();
        accountRequest.setName(testName);
        accountRequest.setEmail(testEmail);
        assertTrue(accountService.deleteAccount(accountRequest));
    }
}