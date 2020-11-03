package com.harm.entity;

import com.harm.constant.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

public class CardServiceTest {
    Logger logger = LoggerFactory.getLogger(CardServiceTest.class);

    @Test
    public void CarService_TYPE() {
        assertTrue(Constants.CARD_SERVICE.TYPE.checkType("M"));
        assertTrue(Constants.CARD_SERVICE.TYPE.checkType("I"));
        assertFalse(Constants.CARD_SERVICE.TYPE.checkType("THERE_IS_NO_TYPE"));

        assertTrue(Constants.CARD_SERVICE.TYPE.checkTypes("I", "M"));
        assertFalse(Constants.CARD_SERVICE.TYPE.checkTypes("M", "THERE_IS_NO_TYPE"));
    }
}