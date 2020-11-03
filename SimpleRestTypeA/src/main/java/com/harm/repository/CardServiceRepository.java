package com.harm.repository;

import com.harm.entity.CardService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardServiceRepository extends JpaRepository<CardService, Long> {
}
