package br.infnet.edu.controlepresenca.model.domain;

import br.infnet.edu.controlepresenca.exceptions.NomeInvalidoException;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Palestra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String nome;
    private String assunto;
    private LocalDateTime inicioPalestra;
    private LocalDateTime fimPalestra;

    public Palestra() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Palestra(String nome, String assunto, LocalDateTime inicioPalestra, LocalDateTime fimPalestra) throws NomeInvalidoException {

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

        DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        return String.format("Palestra: %s,assunto: %s,iníco: %s,fim: %s",
                getAssunto(),
                getNome(),
                getInicioPalestra().format(formatacao),
                getFimPalestra().format(formatacao));
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

    public LocalDateTime getInicioPalestra() {
        return inicioPalestra;
    }

    public void setInicioPalestra(LocalDateTime inicioPalestra) {
        this.inicioPalestra = inicioPalestra;
    }

    public LocalDateTime getFimPalestra() {
        return fimPalestra;
    }

    public void setFimPalestra(LocalDateTime fimPalestra) {
        this.fimPalestra = fimPalestra;
    }
}
