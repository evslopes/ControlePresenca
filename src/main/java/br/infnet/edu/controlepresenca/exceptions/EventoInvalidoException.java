package br.infnet.edu.controlepresenca.exceptions;

public class EventoInvalidoException extends Exception{

    private static final long serialVersionUID = 1L;

    public EventoInvalidoException(String message) {
        super(message);
    }
}
