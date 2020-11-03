package com.harm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.harm.vo.AccountRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {
    Logger logger = LoggerFactory.getLogger(AccountControllerTest.class);
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void createAccount() throws Exception {
        AccountRequest accountVo = new AccountRequest();
        accountVo.setName("test-case-name-01");
        accountVo.setEmail("test-case-email-01");
        String accountJsonStr = objectMapper.writeValueAsString(accountVo);
        logger.debug("object to json string -> {}", accountJsonStr);

        mockMvc.perform(post("/account").contentType(MediaType.APPLICATION_JSON_UTF8).content(accountJsonStr))
                .andDo(print())
                .andExpect(status().isOk())
                ;
    }

    @Test
    public void deleteAccount() throws Exception {
        AccountRequest accountVo = new AccountRequest();
        accountVo.setName("test-case-name-02");
        accountVo.setEmail("test-case-email-02");
        String accountJsonStr = objectMapper.writeValueAsString(accountVo);
        logger.debug("object to json string -> {}", accountJsonStr);

        mockMvc.perform(post("/account").contentType(MediaType.APPLICATION_JSON_UTF8).content(accountJsonStr))
                .andDo(print())
                .andExpect(status().isOk())
        ;

        mockMvc.perform(delete("/account").contentType(MediaType.APPLICATION_JSON_UTF8).content(accountJsonStr))
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }
}