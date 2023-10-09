package com.alexis.nexos.credibanco.bankinc.controller;

import com.alexis.nexos.credibanco.bankinc.entity.Card;
import com.alexis.nexos.credibanco.bankinc.entity.User;
import com.alexis.nexos.credibanco.bankinc.exception.InsufficientBalanceException;
import com.alexis.nexos.credibanco.bankinc.exception.NotFoundException;
import com.alexis.nexos.credibanco.bankinc.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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

    @PutMapping("/recharge/{id}/{amount}")
    public ResponseEntity<String> rechargeCard(@PathVariable Long id, @PathVariable BigDecimal amount) {

        Card card = cardService.getCardById(id);

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InsufficientBalanceException();
        }
        BigDecimal currentBalance = card.getBalance();
        BigDecimal newBalance = currentBalance.add(amount);
        card.setBalance(newBalance);

        cardService.createCard(card);

        return ResponseEntity.ok("Tarjeta recargada con éxito, su nuevo saldo es: " + card.getBalance() + " " + card.getCurrency());
    }

}
