package br.infnet.edu.controlepresenca.model.domain;

import br.infnet.edu.controlepresenca.exceptions.EmailInvalidoException;
import br.infnet.edu.controlepresenca.exceptions.NomeInvalidoException;
import br.infnet.edu.controlepresenca.exceptions.TelefoneInvalidoException;

import java.util.List;

public class Palestrante extends Participante {

    private String assuntoApalestrar;

    public Palestrante(String nome, String email, String telefone, String assuntoApalestrar) throws NomeInvalidoException, EmailInvalidoException, TelefoneInvalidoException {

        super(nome, email, telefone);
        this.assuntoApalestrar = assuntoApalestrar;
    }

    @Override
    public String toString() {
        return String.format("Palestrante: %s - Assunto a palestrar: %s. Contatos: %s - %s",
                this.getNome(),
                this.assuntoApalestrar,
                this.getEmail(),
                this.getTelefone());
    }
}
