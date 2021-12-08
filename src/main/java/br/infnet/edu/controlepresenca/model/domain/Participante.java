package br.infnet.edu.controlepresenca.model.domain;

import br.infnet.edu.controlepresenca.exceptions.EmailInvalidoException;
import br.infnet.edu.controlepresenca.exceptions.NomeInvalidoException;
import br.infnet.edu.controlepresenca.exceptions.TelefoneInvalidoException;

public abstract class Participante {
    private String nome;
    private String email;
    private String telefone;

    public Participante(String nome, String email, String telefone) throws NomeInvalidoException, EmailInvalidoException, TelefoneInvalidoException {

        if(nome == null) {
            throw new NomeInvalidoException("O nome do solicitante está nulo!!!");
        }

        if(email == null) {
            throw new EmailInvalidoException("O e-mail do solicitante " + nome + " está nulo!!!");
        }

        if(telefone == null) {
            throw new TelefoneInvalidoException("O telefone do solicitante " + nome + " está nulo!!!");
        }

        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public abstract String toString();
}
