package br.infnet.edu.controlepresenca.model.domain;

import br.infnet.edu.controlepresenca.exceptions.EventoSemPalestrasException;
import br.infnet.edu.controlepresenca.exceptions.EventoSemParticipantesException;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String nome;
    private LocalDateTime dataInicio;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;


    @OneToMany
    @JoinColumn(name = "idParticipante")
    private List<Participante> participantes;
    @OneToMany
    @JoinColumn(name = "idPalestra")
    private List<Palestra> palestras;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Evento() {

        this.nome = nome;
        this.dataInicio = dataInicio;
        this.palestras = palestras;
    }

    @Override
    public String toString() {

        DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        return String.format("%s;%s",
                this.nome,
                this.dataInicio.format(formatacao));
    }

    public void impressaoParticipantes()  throws EventoSemParticipantesException {

        if(participantes == null) {
            throw new EventoSemParticipantesException("Evento sem participantes!!!");
        }

        if(participantes.size() == 0) {
            throw new EventoSemParticipantesException("Evento sem participantes!!!");
        }

        System.out.println("Relatório do Evento:");
        System.out.println(this);
        System.out.println("#Participantes");
        for(Participante p : participantes) {
            System.out.println("- " + p);
        }
    }

    public void impressaoPalestras()  throws EventoSemPalestrasException {

        if(palestras == null) {
            throw new EventoSemPalestrasException("Evento sem palestras!!!");
        }

        if(palestras.size() == 0) {
            throw new EventoSemPalestrasException("Evento sem palestras!!!");
        }

        System.out.println("#Palestras");
        for(Palestra p : palestras) {
            System.out.println("- " + p);
        }
    }

    public String obterLinhaGravacaoArquivo() {

        StringBuilder sb = new StringBuilder();
        sb.append(nome);
        sb.append(";");
        sb.append(participantes.size());
        sb.append(";");
//        sb.append(palestras.size());
        sb.append("\r\n");

        return sb.toString();
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

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public List<Palestra> getPalestras() {
        return palestras;
    }

    public void setPalestras(List<Palestra> palestras) {
        this.palestras = palestras;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
