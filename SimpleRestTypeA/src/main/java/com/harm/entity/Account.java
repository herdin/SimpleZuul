package com.harm.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
public class Account {
    @Id @GeneratedValue
    Long id;
    String name;
    String email;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    Set<CardService> registeredCardServices = new HashSet<>();
    LocalDateTime registered;

    public void addService(CardService cardService) {
        registeredCardServices.add(cardService);
    }
    public void removeService(CardService cardService) {
        Optional<CardService> findAny = registeredCardServices.stream().filter(registeredCardService -> registeredCardService.getType().equals(cardService.getType())).findAny();
        if(findAny.isPresent()) {
            registeredCardServices.remove(findAny.get());
        }
    }

    public Account() {
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", registeredServices=" + registeredCardServices +
                ", registered=" + registered +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<CardService> getRegisteredCardServices() {
        return registeredCardServices;
    }

    public void setRegisteredCardServices(Set<CardService> registeredCardServices) {
        this.registeredCardServices = registeredCardServices;
    }

    public LocalDateTime getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDateTime registered) {
        this.registered = registered;
    }
}
