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

            Evento evento = null;

            while (linha != null){
                campos = linha.split(";");

                String tipo = campos[0];

                switch (tipo.toUpperCase()) {
                    case "I":
                        Organizador organizador = null;
                        try {
                            organizador = new Organizador("Elvis", "elvis.at@teste.com", "(21)91234-1234");
                        } catch (NomeInvalidoException | EmailInvalidoException | TelefoneInvalidoException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "II":
                        Palestrante palestrante = null;
                        try {
                            palestrante = new Palestrante("Elbert", "elbeth.prof@teste.com", "(21)945678-4567", "Fundamentos de Java");
                        } catch (NomeInvalidoException | EmailInvalidoException | TelefoneInvalidoException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "III":
                        Ouvinte ouvinte = null;
                        try {
                            ouvinte = new Ouvinte("Luana", "Luana.al@teste.com", "(21)99111-1111", "Aprender Java");
                        } catch (NomeInvalidoException | EmailInvalidoException | TelefoneInvalidoException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "IV":
                        Palestra palestra = null;
                        try {
                            palestra = new Palestra("FDJ", "Desenvolvimento JAVA", LocalDateTime.now(), LocalDateTime.now().plusHours(2));
                        } catch (NomeInvalidoException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    default:
                        System.out.println("Tipo inváliado: " + tipo);
                        break;
                    }
                    linha = leitura.readLine();
                }
            try {
                evento.impressaoParticipantes();
                evento.impressaoPalestras();

                escrita.write(evento.obterLinhaGravacaoArquivo());
            } catch (EventoSemParticipantesException | EventoSemPalestrasException e) {
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