package com.pruebaTecnica.novatec.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "card")
public class Card {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;

    @Column(nullable=false, length=16)
    private String cardNumber;

    @Column(nullable=false, length=120)
    private String holderName;

    @Column(nullable=false) 
    private String issuedAt;

    @Column(nullable=false) 
    private String expiresAt;

    @Enumerated(EnumType.STRING) @Column(nullable=false, length=10)
    private CardStatus status;

    @Column(name="blocked_at") 
    private String blockedAt;

    @Column(name="blocked_reason", length=250) 
    private String blockedReason;

    @Column(nullable=false, precision=19, scale=2) 
    private String balance;
    
    @Column(nullable=false, length=3)
    private String currency;

}
