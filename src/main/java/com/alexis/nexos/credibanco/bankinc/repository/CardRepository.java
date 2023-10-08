package com.alexis.nexos.credibanco.bankinc.repository;

import com.alexis.nexos.credibanco.bankinc.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
}
