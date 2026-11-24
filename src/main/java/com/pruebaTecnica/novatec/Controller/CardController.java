package com.pruebaTecnica.novatec.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebaTecnica.novatec.dto.BlockCardRequest;
import com.pruebaTecnica.novatec.dto.CardResponse;
import com.pruebaTecnica.novatec.dto.CardStatusResponse;
import com.pruebaTecnica.novatec.entities.Card;
import com.pruebaTecnica.novatec.entities.CardStatus;
import com.pruebaTecnica.novatec.services.CardService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/cards")
public class CardController {
    private final CardService  cardsevicio;
    public CardController(CardService cardService)
    {
        this.cardsevicio=cardService;

    }
    @PostMapping
    public ResponseEntity<CardResponse> issue()
    {


    }

    @PostMapping("/{cardId}/activate")
    public  CardStatusResponse activate(@PathVariable cardId)
      {
       return ResponseEntity.ok(cardsevicio.activate(cardId));
       } 
    @PostMapping("/{cardId}/block")
    public ResponseEntity<CardStatusResponse> block(@RequestParam Long cardId,@Validated @RequestBody  BlockCardRequest request)
    {
        return ResponseEntity.ok(cardsevicio.block(cardId,request.reason()));

    }

    @GetMapping("/{cardId}")
    public ResponseEntity<CardResponse> get(@RequestParam Long cardId) {
        return ResponseEntity.ok(cardsevicio.get(cardId));
    }
    

    

}
