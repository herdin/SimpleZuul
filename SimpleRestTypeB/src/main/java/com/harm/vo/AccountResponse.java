package com.harm.vo;

import com.harm.entity.Account;
import com.harm.entity.CardService;

import java.time.LocalDateTime;
import java.util.List;

public class AccountResponse{
    String name;
    String email;
    List<CardServiceResponse> registeredCardService;

    public AccountResponse() {
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

    public List<CardServiceResponse> getRegisteredCardService() {
        return registeredCardService;
    }

    public void setRegisteredCardService(List<CardServiceResponse> registeredCardService) {
        this.registeredCardService = registeredCardService;
    }

    @Override
    public String toString() {
        return "AccountResponse{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", registeredCardService=" + registeredCardService +
                '}';
    }
}
