package br.infnet.edu.controlepresenca;

import br.infnet.edu.controlepresenca.model.domain.Palestra;
import br.infnet.edu.controlepresenca.model.domain.Palestrante;
import br.infnet.edu.controlepresenca.model.service.PalestraService;
import br.infnet.edu.controlepresenca.model.service.PalestranteService;
import br.infnet.edu.controlepresenca.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Order(7)
@Component
public class PalestraLoader implements ApplicationRunner {

    @Autowired
    private PalestraService palestraService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PalestranteService palestranteService;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        String nome = "Como implementar um sistema web em java";

        Palestra palestra = null;

        if (palestra == null) {

            palestra = new Palestra();
            palestra.setNome(nome);
            palestra.setInicioPalestra(LocalDateTime.now().toString());
            palestra.setFimPalestra(LocalDateTime.now().plusHours(2).toString());
            palestra.setAssunto("Desenvolvimento de Java para Web");
            palestra.setUsuario(usuarioService.obterPorId(1));

            palestraService.incluir(palestra);
        }

    }
}
