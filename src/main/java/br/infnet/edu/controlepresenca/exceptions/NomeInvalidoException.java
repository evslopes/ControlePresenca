package br.infnet.edu.controlepresenca.exceptions;

public class NomeInvalidoException extends Exception{

    private static final long serialVersionUID = 1L;

    public NomeInvalidoException(String message) {
        super(message);
    }
}
