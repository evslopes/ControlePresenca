package br.infnet.edu.controlepresenca;

import br.infnet.edu.controlepresenca.model.domain.Empresa;
import br.infnet.edu.controlepresenca.model.domain.Organizador;
import br.infnet.edu.controlepresenca.model.domain.Palestrante;
import br.infnet.edu.controlepresenca.model.service.EmpresaService;
import br.infnet.edu.controlepresenca.model.service.EventoService;
import br.infnet.edu.controlepresenca.model.service.PalestranteService;
import br.infnet.edu.controlepresenca.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(6)
@Component
public class PalestranteLoader implements ApplicationRunner {

    @Autowired
    private PalestranteService palestranteService;

    @Autowired
    private UsuarioService usuarioService;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        String nome = "Elbeth";
        String email = "Elbeth@Elbeth.com";
        String telefone = "(21) 99999-9999";
        String assunto = "Java";

        Palestrante palestrante = null;

        if (palestrante == null) {

            palestrante = new Palestrante();
            palestrante.setNome(nome);
            palestrante.setEmail(email);
            palestrante.setTelefone(telefone);
            palestrante.setAssunto(assunto);
            palestrante.setUsuario(usuarioService.obterPorId(1));
            palestranteService.incluir(palestrante);
        }

    }
}
