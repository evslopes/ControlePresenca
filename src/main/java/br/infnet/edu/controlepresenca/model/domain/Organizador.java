package br.infnet.edu.controlepresenca.model.domain;

import br.infnet.edu.controlepresenca.exceptions.EmailInvalidoException;
import br.infnet.edu.controlepresenca.exceptions.NomeInvalidoException;
import br.infnet.edu.controlepresenca.exceptions.TelefoneInvalidoException;

import java.util.List;

public class Organizador extends Participante {

    public Organizador(String nome, String email, String telefone) throws NomeInvalidoException, EmailInvalidoException, TelefoneInvalidoException {
        super(nome, email, telefone);
     }
    @Override
    public String toString() {
        return String.format("Organizador: %s. Contatos: %s - %s",
                this.getNome(),
                this.getEmail(),
                this.getTelefone());
    }
}

