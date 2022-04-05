package br.infnet.edu.controlepresenca.model.domain;

import br.infnet.edu.controlepresenca.exceptions.EmailInvalidoException;
import br.infnet.edu.controlepresenca.exceptions.NomeInvalidoException;
import br.infnet.edu.controlepresenca.exceptions.TelefoneInvalidoException;

import javax.persistence.*;
import java.util.List;

@Entity
public class Organizador extends Participante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    public Organizador() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

