package br.infnet.edu.controlepresenca.exceptions;

public class EmailInvalidoException extends Exception{

    private static final long serialVersionUID = 1L;

    public EmailInvalidoException(String message) {
        super(message);
    }
}
