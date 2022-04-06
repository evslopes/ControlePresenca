package br.infnet.edu.controlepresenca.model.domain;

import br.infnet.edu.controlepresenca.exceptions.CpnjInvalidoException;
import br.infnet.edu.controlepresenca.exceptions.EventoInvalidoException;
import br.infnet.edu.controlepresenca.exceptions.NomeInvalidoException;

import javax.persistence.*;
import java.util.List;

@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String nome;
    private String cpnj;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

    @OneToMany
    private List<Evento> eventos;

    public Empresa() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
        this.eventos = getEventos();
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nome='" + nome + '\'' +
                ", cpnj='" + cpnj + '\'' +
                ", evento=" + getEventos() +
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

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
