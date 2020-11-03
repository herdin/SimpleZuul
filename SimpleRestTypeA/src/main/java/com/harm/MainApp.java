package com.harm;

import com.harm.entity.Account;
import com.harm.entity.CardService;
import com.harm.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@SpringBootApplication
public class MainApp {
    @Autowired
    AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MainApp.class);
        app.setWebApplicationType(WebApplicationType.SERVLET);
        app.run(args);

//        Logger logger = LoggerFactory.getLogger(MainApp.class);
//        Set<CardService> cardServiceSet = new HashSet<>();
//        CardService cardService = null;
//
//        cardService = new CardService();
//        cardService.setType("M");
//        cardServiceSet.add(cardService);
//
//        cardService = new CardService();
//        cardService.setType("I");
//        cardServiceSet.add(cardService);
//
//        cardService = new CardService();
//        cardService.setType("E");
//        cardServiceSet.add(cardService);
//
//        logger.debug("init data -> {}", cardServiceSet);
//
//        CardService findAny = cardServiceSet.stream().filter(cs -> cs.getType().equals("M")).findAny().get();
//        cardServiceSet.remove(findAny);
//        logger.debug("after remove data -> {}", cardServiceSet);
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "{ type: 'hello', name: " + name + "}";
    }

    @GetMapping("/testdata")
    public String testData() {
        Account account = accountRepository.findById(1L).get();
        return account.getName() + "/" + account.getEmail();
    }
}
