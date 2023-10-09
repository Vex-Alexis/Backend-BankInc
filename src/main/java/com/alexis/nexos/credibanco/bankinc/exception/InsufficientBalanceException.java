package com.alexis.nexos.credibanco.bankinc.exception;

public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException() {
        super("El saldo que recargue debe ser superior a cero (0)");
    }
}
