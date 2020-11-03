package com.harm.controller;

import com.harm.service.AccountService;
import com.harm.vo.AccountResponse;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
    Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    AccountService accountService;

    @GetMapping("/account/{email}")
    public ResponseEntity<AccountResponse> getAccount(@PathVariable String email) {
        logger.debug("get account -> {}", email);
        AccountResponse accountResponse = accountService.getAccountInfo(email);
        return ResponseEntity.ok(accountResponse);
    }
}
