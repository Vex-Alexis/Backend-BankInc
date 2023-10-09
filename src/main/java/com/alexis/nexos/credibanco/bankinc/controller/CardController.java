package com.alexis.nexos.credibanco.bankinc.controller;

import com.alexis.nexos.credibanco.bankinc.entity.Card;
import com.alexis.nexos.credibanco.bankinc.entity.Transaction;
import com.alexis.nexos.credibanco.bankinc.entity.User;
import com.alexis.nexos.credibanco.bankinc.exception.InsufficientBalanceException;
import com.alexis.nexos.credibanco.bankinc.exception.NotFoundException;
import com.alexis.nexos.credibanco.bankinc.service.ICardService;
import com.alexis.nexos.credibanco.bankinc.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/v1/bankinc/card")
public class CardController {

    @Autowired
    private ICardService cardService;
    @Autowired
    private ITransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<Card>> getAllCards(){
        List<Card> cards = cardService.getAllCards();
        return ResponseEntity.status(HttpStatus.OK).body(cards);
    }

    @PostMapping
    public ResponseEntity<?> createCard(@RequestBody Card card){

        String cardNumber;
        do {
            // Genera un nuevo número aleatorio de 10 dígitos
            Random random = new Random();
            long cardNumberSuffix = random.nextLong() % 1_000_000_000;
            if (cardNumberSuffix < 0) {
                cardNumberSuffix *= -1;
            }
            cardNumber = card.getProductId() + String.format("%010d", cardNumberSuffix);
            card.setCardNumber(cardNumber);

            // Verifica si el cardNumber ya existe en la base de datos
            Card existingCard = cardService.getCardByCardNumber(card.getCardNumber());
            if (existingCard != null) {
                // Si existe, regenera el número aleatorio y verifica nuevamente
                cardNumber = null;
            }
        } while (cardNumber == null);
        // Ahora cardNumber contiene un número único de tarjeta

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

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setStatus(Transaction.TransactionStatus.EXITOSA);
        transaction.setUser(card.getUser());
        transaction.setCard(card);
        transactionService.saveTransaction(transaction);

        return ResponseEntity.ok("Tarjeta recargada con éxito, su nuevo saldo es: " + card.getBalance() + " " + card.getCurrency());
    }



}
