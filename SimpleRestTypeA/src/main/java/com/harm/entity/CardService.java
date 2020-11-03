package com.harm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

@Entity
public class CardService {
    @Id @GeneratedValue
    Long id;
    String type;
    LocalDateTime registered;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDateTime registered) {
        this.registered = registered;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", registered=" + registered +
                '}';
    }
}
