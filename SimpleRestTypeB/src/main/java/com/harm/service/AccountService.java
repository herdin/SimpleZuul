package com.harm.service;

import com.harm.entity.Account;
import com.harm.entity.CardService;
import com.harm.repository.AccountRepository;
import com.harm.vo.AccountResponse;
import com.harm.vo.CardServiceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class AccountService {
    Logger logger = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    AccountRepository accountRepository;

    public AccountResponse getAccountInfo(String email) {
        Account account = accountRepository.findByEmail(email);
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setName(account.getName());
        accountResponse.setEmail(account.getEmail());
        List<CardServiceResponse> registeredCardServiceList = account.getRegisteredCardServices().stream().map(cardService -> {
            CardServiceResponse cardServiceResponse = new CardServiceResponse();
            cardServiceResponse.setCardServiceType(cardService.getType());
            cardServiceResponse.setRegistered(cardService.getRegistered());
            return cardServiceResponse;
        }).collect(Collectors.toList());
        accountResponse.setRegisteredCardService(registeredCardServiceList);
        return accountResponse;
    }
}
