package com.api.skinpro.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class ResponseBuilder  {
    public static ResponseEntity<Object> ResponseBuild(HttpStatus status, String message) {
        //classe para lançar json formatado com erros
        return ResponseEntity.status(status).body(message);
    }
}
