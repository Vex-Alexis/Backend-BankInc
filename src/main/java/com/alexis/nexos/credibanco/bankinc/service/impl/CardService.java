package com.alexis.nexos.credibanco.bankinc.service.impl;

import com.alexis.nexos.credibanco.bankinc.entity.Card;
import com.alexis.nexos.credibanco.bankinc.exception.NotFoundException;
import com.alexis.nexos.credibanco.bankinc.repository.CardRepository;
import com.alexis.nexos.credibanco.bankinc.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService implements ICardService {

    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository){
        this.cardRepository = cardRepository;
    }

    @Override
    public Card getCardById(Long id) {
        Card card = cardRepository.findById(id)
                .orElseThrow(()-> new NotFoundException(id));

        return card;
    }

    @Override
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public Card createCard(Card card) {
        return cardRepository.save(card);
    }
}
