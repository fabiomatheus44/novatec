package com.pruebaTecnica.novatec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebaTecnica.novatec.entities.Card;

public interface CardRepository extends JpaRepository<Card, Long> {
 boolean existsByCardNumber(String cardNumber);
}
