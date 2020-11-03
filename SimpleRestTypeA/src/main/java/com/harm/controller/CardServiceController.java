package com.harm.controller;

import com.harm.service.CardServiceService;
import com.harm.vo.CardServiceRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardServiceController {
    Logger logger = LoggerFactory.getLogger(CardServiceController.class);

    @Autowired
    CardServiceService cardServiceService;

    @PostMapping("/card/service")
    public ResponseEntity postCardService(@RequestBody CardServiceRequest cardServiceVo) {
        logger.debug("post card service -> {}", cardServiceVo);
        if(cardServiceService.update(cardServiceVo)) {
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
