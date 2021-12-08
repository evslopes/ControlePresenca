package br.infnet.edu.controlepresenca.model.domain;

import java.util.List;

public class Palestrante extends Participante{

    private String assuntoApalestrar;
    private List<Palestra> palestrasAministrar;

    public Palestrante(String nome, String email, String telefone, String assuntoApalestrar, List<Palestra> palestrasAministrar) {
        super(nome, email, telefone);
        this.assuntoApalestrar = assuntoApalestrar;
        this.palestrasAministrar = palestrasAministrar;
    }

    @Override
    public String toString() {
        return null;
    }

    public List<Palestra> getPalestrasAministrar() {
        return palestrasAministrar;
    }

    public void setPalestrasAministrar(List<Palestra> palestrasAministrar) {
        this.palestrasAministrar = palestrasAministrar;
    }
}
