package br.infnet.edu.controlepresenca.model.test;

import br.infnet.edu.controlepresenca.exceptions.*;
import br.infnet.edu.controlepresenca.model.domain.*;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ArquivoEventoTeste {
    public static void main(String[] args) {
        try {
            String arquivo = "participantes.txt";

            FileReader fileR = new FileReader(arquivo);
            BufferedReader leitura = new BufferedReader(fileR);

            FileWriter fileW = new FileWriter("out"+arquivo);
            BufferedWriter escrita = new BufferedWriter(fileW);

            String linha = leitura.readLine();

            String[] campos = null;

            List<Participante> participantes = new ArrayList<Participante>();
//            List<Palestra> palestras = new ArrayList<Palestra>();

            Evento evento = new Evento();
            evento.setNome("Assessment Fundamentos de desenvolvimento JAVA");
            evento.setDataInicio(LocalDateTime.now());

            while (linha != null){
                campos = linha.split(";");

                String tipo = campos[0];

                switch (tipo.toUpperCase()) {
                    case "I":
                        Organizador organizador = null;
                        try {
                            organizador = new Organizador(campos[1], campos[2],campos[3]);
                            participantes.add(organizador);
                        } catch (NomeInvalidoException | EmailInvalidoException | TelefoneInvalidoException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "II":
                        Palestrante palestrante = null;
                        try {
                            palestrante = new Palestrante(campos[1], campos[2],campos[3],campos[4]);
                            participantes.add(palestrante);
                        } catch (NomeInvalidoException | EmailInvalidoException | TelefoneInvalidoException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "III":
                        Ouvinte ouvinte = null;
                        try {
                            ouvinte = new Ouvinte(campos[1], campos[2],campos[3],campos[4]);
                            participantes.add(ouvinte);
                        } catch (NomeInvalidoException | EmailInvalidoException | TelefoneInvalidoException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
//                    case "IV":
//                        Palestra palestra = null;
//                        try {
//                            palestra = new Palestra(campos[1], campos[2],LocalDateTime.parse(campos[3]),LocalDateTime.parse(campos[4]));
//                            palestras.add(palestra);
//                        } catch (NomeInvalidoException e) {
//                            System.out.println(e.getMessage());
//                        }
//                        break;
                    default:
                        System.out.println("Tipo inváliado: " + tipo);
                        break;
                    }
                    linha = leitura.readLine();
                }
            try {
                evento.setParticipantes(participantes);
                evento.impressaoParticipantes();
//                evento.setPalestras(palestras);
//                evento.impressaoPalestras();

                escrita.write(evento.obterLinhaGravacaoArquivo());
            } catch (EventoSemParticipantesException  e) {
                System.out.println(e.getMessage());
            }

            leitura.close();
            escrita.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}