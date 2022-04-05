package br.infnet.edu.controlepresenca.model.domain;

import br.infnet.edu.controlepresenca.exceptions.EmailInvalidoException;
import br.infnet.edu.controlepresenca.exceptions.NomeInvalidoException;
import br.infnet.edu.controlepresenca.exceptions.TelefoneInvalidoException;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ouvinte extends Participante{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String interesses;

    public Ouvinte() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ouvinte(String nome, String email, String telefone, String interesses) throws NomeInvalidoException, EmailInvalidoException, TelefoneInvalidoException {
        super(nome, email, telefone);
        this.interesses = interesses;
    }

    @Override
    public String toString() {
        return String.format("Ouvinte: %s - Interesses: %s. Contatos: %s - %s",
                this.getNome(),
                this.getInteresses(),
                this.getEmail(),
                this.getTelefone());
    }

    public String getInteresses() {
        return interesses;
    }

    public void setInteresses(String interesses) {
        this.interesses = interesses;
    }
}
