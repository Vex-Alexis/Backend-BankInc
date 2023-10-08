package com.alexis.nexos.credibanco.bankinc;

import com.alexis.nexos.credibanco.bankinc.entity.Card;
import com.alexis.nexos.credibanco.bankinc.entity.Transaction;
import com.alexis.nexos.credibanco.bankinc.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BankIncApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankIncApplication.class, args);


		/*	Datos de prueba

		List<Card> cards = new ArrayList<>();
		List<Transaction> transactions = new ArrayList<>();


        User usuario = new User(1L, "VexAlexis", "123456", "Alexis", "Chavarria", "A@gmail.com", "3222614015", cards);
        Card card = new Card(1L,
				"505060",
				"1020304050",
				"Alexis Chavarria",
				LocalDateTime.now().plusYears(3),
				"USD",
				BigDecimal.ZERO,
				Card.CardType.CREDITO,
				LocalDateTime.now(),
				usuario,
				transactions);
		Transaction transaction = new Transaction(1L, new BigDecimal("100.00"), LocalDateTime.now(), Transaction.TransactionStatus.EXITOSA, usuario, card);


		System.out.println(usuario);
		System.out.println(card);
		System.out.println(transaction);

		*/
    }

}
