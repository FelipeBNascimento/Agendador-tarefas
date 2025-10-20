package com.javanauta.agendadortarefa.infraesctruture;

public class EmailNaoEncontrado extends RuntimeException{

    public EmailNaoEncontrado(String message) {
        super(message);
    }

    public EmailNaoEncontrado(String message, Throwable cause) {
        super(message, cause);
    }
}
