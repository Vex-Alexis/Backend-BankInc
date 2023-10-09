package com.alexis.nexos.credibanco.bankinc.controller;

import com.alexis.nexos.credibanco.bankinc.entity.Card;
import com.alexis.nexos.credibanco.bankinc.entity.Transaction;
import com.alexis.nexos.credibanco.bankinc.exception.TransactionNotVoidedException;
import com.alexis.nexos.credibanco.bankinc.service.ICardService;
import com.alexis.nexos.credibanco.bankinc.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RestController
@RequestMapping("/v1/bankinc/transaction")
public class TransactionController {
    @Autowired
    private ITransactionService transactionService;
    @Autowired
    private ICardService cardService;

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions(){
        List<Transaction> transactions = transactionService.getAllTransactions();
        return ResponseEntity.status(HttpStatus.OK).body(transactions);
    }

    @PostMapping("/annular/{id}")
    public ResponseEntity<?> annularTransaction(@PathVariable Long id){
        Transaction transaction = transactionService.getTransactionById(id);
        Card card = transaction.getCard();
        BigDecimal amount = transaction.getAmount();

        long hoursDifference = ChronoUnit.HOURS.between(transaction.getTransactionDate(), LocalDateTime.now());

        // Anular transaccion si se realizo antes de 24 horas y su estado es igual a EXITOSA
        if (hoursDifference < 24 && transaction.getStatus() == Transaction.TransactionStatus.EXITOSA){
            transaction.setStatus(Transaction.TransactionStatus.ANULADA);
            transactionService.saveTransaction(transaction);

            // Restaura el saldo de la tarjeta
            card.setBalance(card.getBalance().add(amount));
            cardService.createCard(card);

            return ResponseEntity.status(HttpStatus.OK).body("Transacción anulada Exitosamente!");
        }else {
            throw new TransactionNotVoidedException();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTransaction(@PathVariable Long id){
        transactionService.deleteTransaction(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Transaccion eliminada!");
    }



}
