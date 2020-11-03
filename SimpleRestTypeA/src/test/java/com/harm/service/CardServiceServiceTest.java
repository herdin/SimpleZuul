package com.harm.service;

import com.harm.constant.Constants;
import com.harm.vo.CardServiceRequest;
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
public class CardServiceServiceTest {
    Logger logger = LoggerFactory.getLogger(CardServiceServiceTest.class);

    @Autowired
    CardServiceService cardServiceService;

    @Test
    public void update() {
        CardServiceRequest cardServiceVo = new CardServiceRequest();
        cardServiceVo.setEmail("test email");
        cardServiceVo.setCardServiceType(Constants.CARD_SERVICE.TYPE.MILEAGE.value());
        cardServiceVo.setCardServiceAction(Constants.CARD_SERVICE.ACTION.REGISTER.value());
        assertTrue(cardServiceService.update(cardServiceVo));
        cardServiceVo.setCardServiceType(Constants.CARD_SERVICE.TYPE.INCOME_TAX_DEDUCTION.value());
        assertTrue(cardServiceService.update(cardServiceVo));
        cardServiceVo.setCardServiceType(Constants.CARD_SERVICE.TYPE.ETC.value());
        assertTrue(cardServiceService.update(cardServiceVo));

        cardServiceVo.setCardServiceType(Constants.CARD_SERVICE.TYPE.INCOME_TAX_DEDUCTION.value());
        cardServiceVo.setCardServiceAction(Constants.CARD_SERVICE.ACTION.DELETE.value());
        assertTrue(cardServiceService.update(cardServiceVo));

    }

}