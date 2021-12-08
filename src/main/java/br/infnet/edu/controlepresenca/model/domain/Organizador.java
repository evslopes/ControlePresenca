package br.infnet.edu.controlepresenca.model.domain;

import br.infnet.edu.controlepresenca.exceptions.EmailInvalidoException;
import br.infnet.edu.controlepresenca.exceptions.NomeInvalidoException;
import br.infnet.edu.controlepresenca.exceptions.TelefoneInvalidoException;

import java.util.List;

public class Organizador extends Participante {

    private List<Evento> eventos;

    public Organizador(String nome, String email, String telefone, List<Evento> eventos) throws NomeInvalidoException, EmailInvalidoException, TelefoneInvalidoException {
        super(nome, email, telefone);
        this.eventos = eventos;
    }

    @Override
    public String toString() {
        return null;
    }
}

