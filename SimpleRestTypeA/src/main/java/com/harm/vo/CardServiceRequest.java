package com.harm.vo;

import com.harm.entity.Account;
import com.harm.entity.CardService;

import java.util.Arrays;
import java.util.Optional;

public class CardServiceRequest implements EntityConvertable<CardService> {

    String email;
    String cardServiceType;
    String cardServiceAction;

    @Override
    public CardService convertToEntity() {
        return null;
    }

    public CardServiceRequest() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCardServiceType() {
        return cardServiceType;
    }

    public void setCardServiceType(String cardServiceType) {
        this.cardServiceType = cardServiceType;
    }

    public String getCardServiceAction() {
        return cardServiceAction;
    }

    public void setCardServiceAction(String cardServiceAction) {
        this.cardServiceAction = cardServiceAction;
    }

    @Override
    public String toString() {
        return "CardServiceVo{" +
                "email='" + email + '\'' +
                ", cardServiceType='" + cardServiceType + '\'' +
                ", cardServiceAction='" + cardServiceAction + '\'' +
                '}';
    }
}
