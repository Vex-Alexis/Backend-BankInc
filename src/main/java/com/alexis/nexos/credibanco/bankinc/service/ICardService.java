package com.alexis.nexos.credibanco.bankinc.service;

import com.alexis.nexos.credibanco.bankinc.entity.Card;

import java.util.List;

public interface ICardService {

    Card getCardById(Long id);
    Card getCardByCardNumber(String cardNumber);

    List<Card> getAllCards();

    Card createCard(Card card);

}
