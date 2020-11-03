package com.harm.vo;

import com.harm.constant.Constants;
import com.harm.entity.CardServiceTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

public class CardServiceVoTest {
    Logger logger = LoggerFactory.getLogger(CardServiceVoTest.class);
    @Test
    public void CardServiceVo_ACTION() {
        assertTrue(Constants.CARD_SERVICE.ACTION.checkType("R"));
        assertTrue(Constants.CARD_SERVICE.ACTION.checkType("D"));
        assertFalse(Constants.CARD_SERVICE.ACTION.checkType("THERE_IS_NO_ACTION"));

        assertTrue(Constants.CARD_SERVICE.ACTION.checkTypes("R", "D"));
        assertTrue(Constants.CARD_SERVICE.ACTION.checkTypes("D", "R"));
        assertFalse(Constants.CARD_SERVICE.ACTION.checkTypes("D", "THERE_IS_NO_ACTION"));
    }
}