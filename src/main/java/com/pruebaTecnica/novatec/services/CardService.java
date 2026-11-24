package com.pruebaTecnica.novatec.services;

import java.time.OffsetDateTime;

import org.springframework.web.client.ResourceAccessException;

import com.pruebaTecnica.novatec.dto.CardResponse;
import com.pruebaTecnica.novatec.dto.CardStatusResponse;
import com.pruebaTecnica.novatec.dto.IssueCardRequest;
import com.pruebaTecnica.novatec.entities.Card;
import com.pruebaTecnica.novatec.entities.CardStatus;
import com.pruebaTecnica.novatec.repository.CardRepository;
import com.pruebaTecnica.novatec.repository.ProductRepository;

import jakarta.transaction.Transactional;
import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;


public class CardService {
//implemento los servicios
private final CardRepository cardRepository;
private final ProductRepository productRepository;
public CardService(CardRepository cardRepository, ProductRepository productRepository)
{
    this.cardRepository=cardRepository;
    this.productRepository=productRepository;
}
@Transactional
public CardResponse issue(IssueCardRequest request){
  if(!productRepository.existsById(request.productId()));
  String number=generateUniqueNumber(request.productId());
  Card card=cardRepository.save(new Card(number,request.productId(),request.holderName().trim(),OffsetDateTime.now()));
  return CardResponse.from(card);
 }
 private String generateUniqueNumber(String productId){
  for(int attempt=0;attempt<20;attempt++)
    {
        long numero = ThreadLocalRandom.current().nextLong(1L, 1001L);
        StringBuilder suffix=new StringBuilder(10);
        for(int i=0;i<10;i++)suffix.append(numero);
        String candidate=productId+suffix;
        if(!cardRepository.existsByCardNumber(candidate))
            return candidate;
        }
       return  "0";
 }

@Transactional
public CardStatusResponse block(long id,String reason)
{
    Card card=find(id);
    card.block(reason.trim(),OffsetDateTime.now());
    return new CardStatusResponse(card.getCardId(),card.getStatus().name());
}

@Transactional
public CardStatusResponse activate(long id)
{
    Card card=find(id);
    if(card.getStatus()==CardStatus.BLOCKED)
       card.activate();
    return new CardStatusResponse(card.getCardId(),card.getStatus().name());
}


@Transactional
public CardResponse get(long id)
{
    return CardResponse.from(find(id));

}

//private Card find(long id) {
  //  return cardRepository.findById(id);
    //.orElseThrow(()->new ResourceNot   ("No existe la tarjeta de numero:"+id));
    //ya miro porque no toma el mensaje de error, sino existe tarjeta
    

//}
 private Card find(long id)
 {
    return cardRepository.findById(id).orElse(null);
}





}
