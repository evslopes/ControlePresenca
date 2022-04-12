package br.infnet.edu.controlepresenca;

import br.infnet.edu.controlepresenca.model.domain.Empresa;
import br.infnet.edu.controlepresenca.model.domain.Organizador;
import br.infnet.edu.controlepresenca.model.service.EmpresaService;
import br.infnet.edu.controlepresenca.model.service.EventoService;
import br.infnet.edu.controlepresenca.model.service.OrganizadorService;
import br.infnet.edu.controlepresenca.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(4)
@Component
public class OrganizadorLoader implements ApplicationRunner {

    @Autowired
    private OrganizadorService organizadorService;
    @Autowired
    private UsuarioService usuarioService;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        String nome = "Luana";
        String email = "luana@luana.com";
        String telefone = "(21) 91234-5678";

        Organizador organizador = null;

//
        if(organizador == null) {

            organizador = new Organizador();
            organizador.setNome(nome);
            organizador.setEmail(email);
            organizador.setTelefone(telefone);
            organizador.setUsuario(usuarioService.obterPorId(1));
            organizadorService.incluir(organizador);
        }

    }
}
