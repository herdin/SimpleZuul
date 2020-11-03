package com.harm.runner;

import com.harm.constant.Constants;
import com.harm.entity.Account;
import com.harm.entity.CardService;
import com.harm.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Transactional
@Component
public class PostgresRunner implements ApplicationRunner {
    Logger logger = LoggerFactory.getLogger(PostgresRunner.class);
    @Autowired
    AccountRepository accountRepository;
//    @Autowired
//    EntityManager entityManager;
    @Override
    public void run(ApplicationArguments args) throws Exception {
//        Session session = entityManager.unwrap(Session.class);

        Account account = new Account();
        account.setName("test name");
        account.setEmail("test email");
        account.setRegistered(LocalDateTime.now());

        CardService cardService = new CardService();
        cardService.setType(Constants.CARD_SERVICE.TYPE.MILEAGE.value());
        cardService.setRegistered(LocalDateTime.now());
        account.addService(cardService);
        accountRepository.save(account);

        List<Account> all = accountRepository.findAll();
        for(Account item : all) {
            logger.debug("-> {}", item);
        }

        account = accountRepository.findByEmail("test email");
        logger.debug("find by email -> {}", account);
        cardService = new CardService();
        cardService.setType(Constants.CARD_SERVICE.TYPE.INCOME_TAX_DEDUCTION.value());
        cardService.setRegistered(LocalDateTime.now());
        account.addService(cardService);

        Optional<CardService> any = account.getRegisteredCardServices().stream().filter(registeredCardService -> registeredCardService.getType().equals("M")).findAny();
        account.getRegisteredCardServices().remove(any.get());
        logger.debug("{} registered services -> {}", account.getEmail(), account.getRegisteredCardServices());

    }
}
