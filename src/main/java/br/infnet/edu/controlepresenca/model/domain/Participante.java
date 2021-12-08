package br.infnet.edu.controlepresenca.model.domain;

public abstract class Participante {
    private String nome;
    private String email;
    private String telefone;

    public Participante(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public abstract String toString();
}
