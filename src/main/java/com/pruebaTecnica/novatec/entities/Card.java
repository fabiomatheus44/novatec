package com.pruebaTecnica.novatec.entities;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

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
import java.util.concurrent.ThreadLocalRandom;
@Data
@AllArgsConstructor
@Entity
@Table(name = "card")
public class Card {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;

    @Column(nullable=false, length=16)
    private String cardNumber;

    @Column(name="product_id", nullable=false, length=6)
    private String productId;

    @Column(nullable=false, length=120)
    private String holderName;

    @Column(nullable=false) 
    private OffsetDateTime issuedAt;

    @Column(nullable=false) 
    private LocalDate   expiresAt;

    @Enumerated(EnumType.STRING) @Column(nullable=false, length=10)
    private CardStatus status;

    @Column(name="blocked_at") 
    private OffsetDateTime   blockedAt;

    @Column(name="blocked_reason", length=250) 
    private String blockedReason;

    @Column(nullable=false, precision=19, scale=2) 
    private BigDecimal  balance;
    
    @Column(nullable=false, length=3)
    private String currency;


    protected Card() {}
    public Card(String cardNumber, String productId, String holderName, OffsetDateTime issuedAt)
     {
        this.cardId=ThreadLocalRandom.current().nextLong(1_000_000_000L, 10_000_000_000L);
        this.cardNumber=cardNumber; 
        this.productId=productId;
        this.holderName=holderName;
        this.issuedAt=issuedAt;
        this.expiresAt=issuedAt.toLocalDate().plusYears(3); 
        this.status=CardStatus.ISSUED;
        this.balance=new BigDecimal("0.00");
        this.currency="USD";
    }
    public void activate()
    { 
        if(status==CardStatus.ISSUED) status=CardStatus.ACTIVE;
    }
    public void block(String reason, OffsetDateTime now)
    { 
        if(status!=CardStatus.BLOCKED)
            {
                status=CardStatus.BLOCKED;
                blockedAt=now;
                blockedReason=reason;
            }
    }
    public Long  getCardId()
    {
        return cardId;
    }
    public String getCardNumber()
    {
        return cardNumber;
    } 
    public String getProductId()
    {
        return productId;
    }
    public String getHolderName()
    {
        return holderName;
    }
    public OffsetDateTime getIssuedAt()
    {
        return issuedAt;
    }
    public LocalDate getExpiresAt()
    {
        return expiresAt;
    }
    public CardStatus getStatus()
    {
        return status;
    }
    public OffsetDateTime getBlockedAt()
    {
        return blockedAt;
    }
    public String getBlockedReason(){return blockedReason;}
    public BigDecimal getBalance()
    {
        return balance;
    }
    public String getCurrency()
    {
        return currency;
    }

}
