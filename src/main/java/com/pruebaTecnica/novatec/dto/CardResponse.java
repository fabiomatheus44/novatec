package com.pruebaTecnica.novatec.dto;

import com.pruebaTecnica.novatec.entities.Card;

public record CardResponse(Card card) 
{
 public static CardResponse from (Card c)
 {
  return new CardResponse(c);

 }
}
