package br.infnet.edu.controlepresenca;

import br.infnet.edu.controlepresenca.model.domain.Evento;
import br.infnet.edu.controlepresenca.model.domain.Usuario;
import br.infnet.edu.controlepresenca.model.service.EventoService;
import br.infnet.edu.controlepresenca.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Order(2)
@Component
public class EventoLoader implements ApplicationRunner {

    @Autowired
    private EventoService eventoService;
    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        String nome = "Assessmento Java Web";
        LocalDateTime dataInicio = LocalDateTime.now();

        Evento evento = null;

//
        if(evento == null) {

            evento = new Evento();
            evento.setNome(nome);
            evento.setDataInicio(dataInicio);
            evento.setUsuario(usuarioService.obterPorId(1));
            eventoService.incluir(evento);
        }

    }
}
