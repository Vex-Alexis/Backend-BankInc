package com.alexis.nexos.credibanco.bankinc.service;

import com.alexis.nexos.credibanco.bankinc.entity.Card;
import com.alexis.nexos.credibanco.bankinc.entity.Transaction;

import java.util.List;

public interface ITransactionService {

    List<Transaction> getAllTransactions();
    Transaction saveTransaction(Transaction transaction);

    void deleteTransaction(Long id);


}
