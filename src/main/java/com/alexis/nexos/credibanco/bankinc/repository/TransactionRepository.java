package com.alexis.nexos.credibanco.bankinc.repository;

import com.alexis.nexos.credibanco.bankinc.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
