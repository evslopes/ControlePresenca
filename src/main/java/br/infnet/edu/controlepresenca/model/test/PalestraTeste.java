package br.infnet.edu.controlepresenca.model.test;

import br.infnet.edu.controlepresenca.exceptions.NomeInvalidoException;
import br.infnet.edu.controlepresenca.model.domain.Palestra;

import java.time.LocalDateTime;

public class PalestraTeste {
    public static void main(String[] args) {
        try {
            Palestra testePalestra = new Palestra("Java básico",
                    "JAVA",
                    LocalDateTime.now(), LocalDateTime.now());
            System.out.println(testePalestra);
        } catch (NomeInvalidoException e) {
            e.printStackTrace();
        }

        try {
            Palestra testePalestra2 = new Palestra(null,
                    "JAVA",
                    LocalDateTime.now(), LocalDateTime.now());
            System.out.println(testePalestra2);
        } catch (NomeInvalidoException e) {
            e.printStackTrace();
        }

    }
}
