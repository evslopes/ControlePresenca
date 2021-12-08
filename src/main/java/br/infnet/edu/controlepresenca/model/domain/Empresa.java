package br.infnet.edu.controlepresenca.model.domain;

import br.infnet.edu.controlepresenca.exceptions.CpnjInvalidoException;
import br.infnet.edu.controlepresenca.exceptions.EventoInvalidoException;
import br.infnet.edu.controlepresenca.exceptions.NomeInvalidoException;

public class Empresa {

    private String nome;
    private String cpnj;
    private Evento evento;

    public Empresa(String nome, String cpnj, Evento evento) throws NomeInvalidoException, CpnjInvalidoException, EventoInvalidoException {

        if(nome == null) {
            throw new NomeInvalidoException("O nome da empresa está nulo!");
        }

        if(cpnj == null) {
            throw new CpnjInvalidoException("O cpnj da empresa " + nome + " está nulo!");
        }

        if(evento == null) {
            throw new EventoInvalidoException("A empresa " + nome + " não possui evento associado!");
        }

        this.nome = nome;
        this.cpnj = cpnj;
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nome='" + nome + '\'' +
                ", cpnj='" + cpnj + '\'' +
                ", evento=" + evento +
                '}';
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
