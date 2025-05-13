package com.api.skinpro.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String name) {
        super(String.format("Não encontrado para %s.", name));
    }
}
