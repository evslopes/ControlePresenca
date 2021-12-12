package br.infnet.edu.controlepresenca.model.test;

import br.infnet.edu.controlepresenca.exceptions.EmailInvalidoException;
import br.infnet.edu.controlepresenca.exceptions.NomeInvalidoException;
import br.infnet.edu.controlepresenca.exceptions.TelefoneInvalidoException;
import br.infnet.edu.controlepresenca.model.domain.Organizador;

public class OrganizadorTeste {
    public static void main(String[] args) {
        try {
            Organizador testeOrganizador = new Organizador("Elvis", "teste@test.com", "(21)91234-1231");
            System.out.println(testeOrganizador);
        } catch (NomeInvalidoException | EmailInvalidoException | TelefoneInvalidoException e) {
            e.printStackTrace();
        }
    }
}
