package br.infnet.edu.controlepresenca.model.domain;

public class Empresa {

    private String nome;
    private String cpnj;
    private Evento evento;

    public Empresa(String nome, String cpnj, Evento evento) {
        this.nome = nome;
        this.cpnj = cpnj;
        this.evento = evento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpnj() {
        return cpnj;
    }

    public void setCpnj(String cpnj) {
        this.cpnj = cpnj;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
