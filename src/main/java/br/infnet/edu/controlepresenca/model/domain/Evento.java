package br.infnet.edu.controlepresenca.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Evento {

    private String nome;
    private LocalDateTime dataInicio;
    private List<Organizador> organizadores;
    private List<Palestrante> palestrantes;
    private List<Ouvinte> ouvintes;
    private List<Palestra> palestras;

    public Evento(String nome,
                  LocalDateTime dataInicio,
                  List<Organizador> organizadores,
                  List<Palestrante> palestrantes,
                  List<Ouvinte> ouvintes, List<Palestra> palestras) {
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.organizadores = organizadores;
        this.palestrantes = palestrantes;
        this.ouvintes = ouvintes;
        this.palestras = palestras;
    }

    @Override
    public String toString() {

        DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        return String.format("%s;%s;%s;%d",
                this.nome,
                this.dataInicio.format(formatacao),
                this.organizadores);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public List<Organizador> getOrganizadores() {
        return organizadores;
    }

    public void setOrganizadores(List<Organizador> organizadores) {
        this.organizadores = organizadores;
    }

    public List<Palestrante> getPalestrantes() {
        return palestrantes;
    }

    public void setPalestrantes(List<Palestrante> palestrantes) {
        this.palestrantes = palestrantes;
    }

    public List<Ouvinte> getOuvintes() {
        return ouvintes;
    }

    public void setOuvintes(List<Ouvinte> ouvintes) {
        this.ouvintes = ouvintes;
    }

    public List<Palestra> getPalestras() {
        return palestras;
    }

    public void setPalestras(List<Palestra> palestras) {
        this.palestras = palestras;
    }
}
