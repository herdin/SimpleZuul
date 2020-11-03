package com.harm.vo;

import com.harm.entity.Account;
import com.harm.entity.CardService;

import java.time.LocalDateTime;
import java.util.Arrays;

public class AccountRequest implements EntityConvertable<Account>{
    String name;
    String email;

    public AccountRequest() {
    }

    @Override
    public Account convertToEntity() {
        Account accountEntity = new Account();
        accountEntity.setName(name);
        accountEntity.setEmail(email);
        accountEntity.setRegistered(LocalDateTime.now());
        return accountEntity;
    }

    @Override
    public String toString() {
        return "AccountVo{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
