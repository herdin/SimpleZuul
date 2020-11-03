package com.harm.vo;

import com.harm.entity.CardService;

import java.time.LocalDateTime;

public class CardServiceResponse {

    String cardServiceType;
    LocalDateTime registered;

    public CardServiceResponse() {
    }

    public String getCardServiceType() {
        return cardServiceType;
    }

    public void setCardServiceType(String cardServiceType) {
        this.cardServiceType = cardServiceType;
    }

    public LocalDateTime getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDateTime registered) {
        this.registered = registered;
    }

    @Override
    public String toString() {
        return "CardServiceResponse{" +
                "cardServiceType='" + cardServiceType + '\'' +
                ", registered=" + registered +
                '}';
    }
}
