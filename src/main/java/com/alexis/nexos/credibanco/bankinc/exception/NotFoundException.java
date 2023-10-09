package com.alexis.nexos.credibanco.bankinc.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Long id) {
        super("El registro con ID " + id + " no ha sido encontrado." );
    }
}
