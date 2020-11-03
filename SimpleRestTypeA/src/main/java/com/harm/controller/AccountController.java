package com.harm.controller;

import com.harm.service.AccountService;
import com.harm.vo.AccountRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {
    Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    AccountService accountService;

    @PostMapping("/account")
    public ResponseEntity postAccount(@RequestBody AccountRequest accountRequest) {
        logger.debug("post account -> {}", accountRequest);
        if(accountService.createAccount(accountRequest)) {
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.badRequest().body(null);
        }

    }

    @DeleteMapping("/account")
    public ResponseEntity deleteAccount(@RequestBody AccountRequest accountRequest) {
        logger.debug("deletet account -> {}", accountRequest);
        if(accountService.deleteAccount(accountRequest)) {
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
