package com.pruebaTecnica.novatec.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebaTecnica.novatec.dto.BlockCardRequest;
import com.pruebaTecnica.novatec.dto.CardResponse;
import com.pruebaTecnica.novatec.dto.CardStatusResponse;
import com.pruebaTecnica.novatec.dto.IssueCardRequest;
//import com.pruebaTecnica.novatec.entities.Card;
//import com.pruebaTecnica.novatec.entities.CardStatus;
import com.pruebaTecnica.novatec.services.CardService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/cards")
public class CardController {
    private final CardService  cardsevicio;
    public CardController(CardService cardService)
    {
        this.cardsevicio=cardService;

    }
   
    @PostMapping
    public ResponseEntity<CardResponse> issue(@Valid @RequestBody IssueCardRequest request)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(cardsevicio.issue(request));
    }

    @PostMapping("/{cardId}/activate")
    public ResponseEntity<CardStatusResponse> activate(@PathVariable Long cardId)
    {
        return ResponseEntity.ok(cardsevicio.activate(cardId));
    }
    
    @PostMapping("/{cardId}/block")
    public ResponseEntity<CardStatusResponse> block(@PathVariable Long cardId,@Valid @RequestBody BlockCardRequest request)
    {
        return ResponseEntity.ok(cardsevicio.block(cardId,request.reason()));
    }
    @GetMapping("/{cardId}")
    public ResponseEntity<CardResponse> get(@PathVariable Long cardId)
    {
        return ResponseEntity.ok(cardsevicio.get(cardId));
    }




}
