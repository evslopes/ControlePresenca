package br.infnet.edu.controlepresenca.model.domain;

import br.infnet.edu.controlepresenca.exceptions.EmailInvalidoException;
import br.infnet.edu.controlepresenca.exceptions.NomeInvalidoException;
import br.infnet.edu.controlepresenca.exceptions.TelefoneInvalidoException;

import javax.persistence.*;

@Entity
public abstract class Participante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String nome;
    private String email;
    private String telefone;
    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

    public Participante() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
