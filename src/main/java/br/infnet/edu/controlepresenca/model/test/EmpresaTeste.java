package br.infnet.edu.controlepresenca.model.test;

import br.infnet.edu.controlepresenca.exceptions.CpnjInvalidoException;
import br.infnet.edu.controlepresenca.exceptions.EventoInvalidoException;
import br.infnet.edu.controlepresenca.exceptions.NomeInvalidoException;
import br.infnet.edu.controlepresenca.model.domain.Empresa;

public class EmpresaTeste {
    public static void main(String[] args) {

        // Testando exceção de nome inválido
        try {
            Empresa teste1 = new Empresa(null, "1234567890909", null);
        } catch (NomeInvalidoException | CpnjInvalidoException | EventoInvalidoException e) {
            e.printStackTrace();
        }

        // Testando exceção de CPNJ inválido
        try {
            Empresa teste1 = new Empresa("JavaDay", null, null);
        } catch (NomeInvalidoException | CpnjInvalidoException | EventoInvalidoException e) {
            e.printStackTrace();
        }

        // Testando exceção de evento inválido
        try {
            Empresa teste1 = new Empresa("JavaDay", "1234567890909", null);
        } catch (NomeInvalidoException | CpnjInvalidoException | EventoInvalidoException e) {
            e.printStackTrace();
        }

    }
}
