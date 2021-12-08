package br.infnet.edu.controlepresenca.model.domain;

import java.util.List;

public class Organizador extends Participante {

    private List<Evento> eventos;

    public Organizador(String nome, String email, String telefone, List<Evento> eventos) {
        super(nome, email, telefone);
        this.eventos = eventos;
    }

    @Override
    public String toString() {
        return null;
    }
}

