package br.infnet.edu.controlepresenca;

import br.infnet.edu.controlepresenca.model.domain.Organizador;
import br.infnet.edu.controlepresenca.model.domain.Ouvinte;
import br.infnet.edu.controlepresenca.model.service.OuvinteService;
import br.infnet.edu.controlepresenca.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(5)
@Component
public class OuvinteLoader implements ApplicationRunner {

    @Autowired
    private OuvinteService ouvinteService;
    @Autowired
    private UsuarioService usuarioService;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        String nome = "Benjamin";
        String email = "Benjamin@benjamin.com";
        String telefone = "(21) 98765-4321";

        Ouvinte ouvinte = null;

//
        if(ouvinte == null) {

            ouvinte = new Ouvinte();
            ouvinte.setNome(nome);
            ouvinte.setEmail(email);
            ouvinte.setTelefone(telefone);
            ouvinte.setInteresses("Aprender Java Web");
            ouvinte.setUsuario(usuarioService.obterPorId(1));
            ouvinteService.incluir(ouvinte);
        }

    }
}
