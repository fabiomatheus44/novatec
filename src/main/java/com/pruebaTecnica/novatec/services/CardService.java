package com.pruebaTecnica.novatec.services;

import java.time.OffsetDateTime;

import org.springframework.web.client.ResourceAccessException;

import com.pruebaTecnica.novatec.dto.CardResponse;
import com.pruebaTecnica.novatec.dto.CardStatusResponse;
import com.pruebaTecnica.novatec.entities.Card;
import com.pruebaTecnica.novatec.repository.CardRepository;
import com.pruebaTecnica.novatec.repository.ProductRepository;

import jakarta.transaction.Transactional;

public class CardService {
//implemento los servicios
private final CardRepository cardRepository;
private final ProductRepository productRepository;
Public CardService(CardRepository cardRepository,ProductRepository productRepository) {
    this.cardRepository = cardRepository;
    this.productRepository = productRepository;
}
@Transactional 
public void createCard(Card card) {
    // Lógica para crear una tarjeta
    cardRepository.save(card);
}
public CardStatusResponse  block(long id,String  reason)
{
Card card=find(id);
card.block(reason.trim(),OffsetDateTime.now());
return  new CardStatusResponse(card.getCardId(),card.getStatus().name());
}
/**
 * @param id
 * @return
 */
@Transactional 
public CardResponse get(long id)
{
return CardResponse.from(find(id));
}

private Card find(long id) {
    return cardRepository.findById(id);
    //.orElseThrow(()->new ResourceNot   ("No existe la tarjeta de numero:"+id));
    //ya miro porque no toma el mensaje de error, sino existe tarjeta
    

}





}
