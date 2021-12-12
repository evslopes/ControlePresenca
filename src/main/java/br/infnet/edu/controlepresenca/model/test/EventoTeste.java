package br.infnet.edu.controlepresenca.model.test;

import br.infnet.edu.controlepresenca.exceptions.*;
import br.infnet.edu.controlepresenca.model.domain.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventoTeste {

    public static void main(String[] args) throws NomeInvalidoException, EmailInvalidoException, TelefoneInvalidoException, EventoSemParticipantesException, EventoSemPalestrasException {

        //listas para armazenas os testes criados
        List<Participante> listaParticipantes = new ArrayList<Participante>();
        List<Palestra> listaPalestras = new ArrayList<Palestra>();

        //criando cada tipo
        Organizador testeOrganizador = new Organizador("Elvis", "teste@test.com", "(21)91234-1231");
        Palestrante testePalestrante = new Palestrante("Elvis", "teste@test.com", "(21)91234-1231", "Java Básico");
        Palestra testePalestra = new Palestra("Java básico",
                "JAVA",
                LocalDateTime.now(), LocalDateTime.now());
        Ouvinte testeOuvinte = new Ouvinte("Elvis", "teste@test.com", "(21)91234-1231", "Java Básico");

        //preenchendo as listas
        listaParticipantes.add(testeOrganizador);
        listaParticipantes.add(testePalestrante);
        listaParticipantes.add(testeOuvinte);
        listaPalestras.add(testePalestra);

        //criando evento e populando
        Evento eventoTeste = new Evento();
        eventoTeste.setNome("AT JAVA");
        eventoTeste.setDataInicio(LocalDateTime.now());
        eventoTeste.setParticipantes(listaParticipantes);
        eventoTeste.setPalestras(listaPalestras);

        //imprimindo casos de teste
        eventoTeste.impressaoParticipantes();
        eventoTeste.impressaoPalestras();


    }
}
