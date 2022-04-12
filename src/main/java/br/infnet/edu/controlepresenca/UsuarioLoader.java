package br.infnet.edu.controlepresenca;

import br.infnet.edu.controlepresenca.model.domain.Usuario;
import br.infnet.edu.controlepresenca.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class UsuarioLoader implements ApplicationRunner {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        String email = "elvis@elvis.com";
        String senha = "1234";

        Usuario usuario = null;

        usuario = usuarioService.autenticacao(email, senha);

        if(usuario == null) {

            usuario = new Usuario();
            usuario.setNome("Elvis Lopes");
            usuario.setEmail("elvis@elvis.com");
            usuario.setSenha("1234");
            usuario.setAdmin(true);
            usuarioService.incluir(usuario);

        }

    }
}
