package br.infnet.edu.controlepresenca.model.domain;

import br.infnet.edu.controlepresenca.exceptions.EmailInvalidoException;
import br.infnet.edu.controlepresenca.exceptions.NomeInvalidoException;
import br.infnet.edu.controlepresenca.exceptions.TelefoneInvalidoException;

import java.util.List;

public class Ouvinte extends Participante{

    private String interesses;
    private List<Palestra> palestrasAparticipar;

    public Ouvinte(String nome, String email, String telefone, String interesses, List<Palestra> palestrasAparticipar) throws NomeInvalidoException, EmailInvalidoException, TelefoneInvalidoException {
        super(nome, email, telefone);
        this.interesses = interesses;
        this.palestrasAparticipar = palestrasAparticipar;
    }

    @Override
    public String toString() {
        return null;
    }

    public List<Palestra> getPalestrasAparticipar() {
        return palestrasAparticipar;
    }

    public void setPalestrasAparticipar(List<Palestra> palestrasAparticipar) {
        this.palestrasAparticipar = palestrasAparticipar;
    }
}
