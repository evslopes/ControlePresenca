package br.infnet.edu.controlepresenca.model.domain;

import java.time.LocalDateTime;

public class Palestra {
    private String nome;
    private String assunto;
    private LocalDateTime inicioPalestra;
    private LocalDateTime fimPalestra;

    public Palestra(String nome, String assunto, LocalDateTime inicioPalestra, LocalDateTime fimPalestra) {
        this.nome = nome;
        this.assunto = assunto;
        this.inicioPalestra = inicioPalestra;
        this.fimPalestra = fimPalestra;
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
