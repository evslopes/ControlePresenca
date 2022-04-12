package br.infnet.edu.controlepresenca.model.domain;

import br.infnet.edu.controlepresenca.exceptions.EmailInvalidoException;
import br.infnet.edu.controlepresenca.exceptions.NomeInvalidoException;
import br.infnet.edu.controlepresenca.exceptions.TelefoneInvalidoException;

import javax.persistence.*;

@Entity
public class Palestrante extends Participante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String assunto;

    public Palestrante() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public Palestrante(String nome, String email, String telefone, String assunto) throws NomeInvalidoException, EmailInvalidoException, TelefoneInvalidoException {

        super(nome, email, telefone);
        this.assunto = assunto;
    }

    @Override
    public String toString() {
        return String.format("Palestrante: %s - Assunto a palestrar: %s. Contatos: %s - %s",
                this.getNome(),
                this.assunto,
                this.getEmail(),
                this.getTelefone());
    }
}
