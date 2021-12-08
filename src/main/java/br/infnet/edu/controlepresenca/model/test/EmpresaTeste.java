package br.infnet.edu.controlepresenca.model.test;

import br.infnet.edu.controlepresenca.model.domain.Empresa;
import br.infnet.edu.controlepresenca.model.domain.Evento;

import java.util.ArrayList;
import java.util.List;

public class EmpresaTeste {
    public static void main(String[] args) {
        List<Empresa> listaDeEmpresas = new ArrayList<Empresa>();

        Empresa teste1 = new Empresa("JavaDay", "1234567890909", null);

        listaDeEmpresas.add(teste1);

        System.out.println(listaDeEmpresas);

    }
}
