package com.harm.service;

import com.harm.constant.Constants;
import com.harm.entity.Account;
import com.harm.entity.CardService;
import com.harm.repository.AccountRepository;
import com.harm.vo.AccountRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Transactional
@Service
public class AccountService {
    Logger logger = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    AccountRepository accountRepository;

    public boolean createAccount(AccountRequest accountRequest) {
        logger.debug("create account -> {}", accountRequest);

        try {
            accountRepository.save(accountRequest.convertToEntity());
        } catch (Exception e) {
            logger.error("error -> {}", e.getMessage());
            return false;
        }

        return true;
    }

    public boolean deleteAccount(AccountRequest accountRequest) {
        logger.debug("delete account -> {}", accountRequest);

        try {
            Account accountFindByEmail = accountRepository.findByEmail(accountRequest.getEmail());
            accountRepository.delete(accountFindByEmail);
        } catch (Exception e) {
            logger.error("error -> {}", e.getMessage());
            return false;
        }

        return true;
    }
}
