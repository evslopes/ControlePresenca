package br.infnet.edu.controlepresenca.model.domain;

import br.infnet.edu.controlepresenca.exceptions.NomeInvalidoException;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
public class Palestra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String nome;
    private String assunto;
    private String inicioPalestra;
    private String fimPalestra;
    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;


    public Palestra() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Palestra(String nome, String assunto, String inicioPalestra, String fimPalestra) throws NomeInvalidoException {

        if(nome == null) {
            throw new NomeInvalidoException("O nome da palestra está nulo!");
        }
        this.nome = nome;
        this.assunto = assunto;
        this.inicioPalestra = inicioPalestra;
        this.fimPalestra = fimPalestra;
    }

    @Override
    public String toString() {

//        DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        return String.format("Palestra: %s,assunto: %s,iníco: %s,fim: %s",
                getAssunto(),
                getNome(),
                getInicioPalestra(),
                getFimPalestra());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getInicioPalestra() {
        return inicioPalestra;
    }

    public void setInicioPalestra(String inicioPalestra) {
        this.inicioPalestra = inicioPalestra;
    }

    public String getFimPalestra() {
        return fimPalestra;
    }

    public void setFimPalestra(String fimPalestra) {
        this.fimPalestra = fimPalestra;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
