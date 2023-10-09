package com.alexis.nexos.credibanco.bankinc.service.impl;

import com.alexis.nexos.credibanco.bankinc.entity.Transaction;
import com.alexis.nexos.credibanco.bankinc.exception.NotFoundException;
import com.alexis.nexos.credibanco.bankinc.repository.TransactionRepository;
import com.alexis.nexos.credibanco.bankinc.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService implements ITransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id)
                .orElseThrow(()-> new NotFoundException(id));
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
