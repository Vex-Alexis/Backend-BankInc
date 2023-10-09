package com.alexis.nexos.credibanco.bankinc.controller;

import com.alexis.nexos.credibanco.bankinc.entity.Card;
import com.alexis.nexos.credibanco.bankinc.entity.User;
import com.alexis.nexos.credibanco.bankinc.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/bankinc/card")
public class CardController {

    @Autowired
    private ICardService cardService;

    @GetMapping
    public ResponseEntity<List<Card>> getAllCards(){
        List<Card> cards = cardService.getAllCards();
        return ResponseEntity.status(HttpStatus.OK).body(cards);
    }

    @PostMapping
    public ResponseEntity<?> createCard(@RequestBody Card card){
        Card newCard = cardService.createCard(card);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCard);
    }





}
