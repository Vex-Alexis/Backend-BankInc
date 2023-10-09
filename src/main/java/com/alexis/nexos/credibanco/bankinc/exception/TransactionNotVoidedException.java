package com.alexis.nexos.credibanco.bankinc.exception;

public class TransactionNotVoidedException extends RuntimeException {
    public TransactionNotVoidedException() {
        super("Ya han pasado mas de 24 horas, la transacción no puede ser ANULADA");
    }
}
