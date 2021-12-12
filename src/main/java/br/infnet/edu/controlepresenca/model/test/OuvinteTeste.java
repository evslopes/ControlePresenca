package br.infnet.edu.controlepresenca.model.test;

import br.infnet.edu.controlepresenca.exceptions.EmailInvalidoException;
import br.infnet.edu.controlepresenca.exceptions.NomeInvalidoException;
import br.infnet.edu.controlepresenca.exceptions.TelefoneInvalidoException;
import br.infnet.edu.controlepresenca.model.domain.Ouvinte;

public class OuvinteTeste {
    public static void main(String[] args) {
        try {
            Ouvinte testeOuvinte = new Ouvinte("Elvis", "teste@test.com", "(21)91234-1231", "Java Básico");
            System.out.println(testeOuvinte);
        } catch (NomeInvalidoException | EmailInvalidoException | TelefoneInvalidoException e) {
            e.printStackTrace();
        }
    }
}

