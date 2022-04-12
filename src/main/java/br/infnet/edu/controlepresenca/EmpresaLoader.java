package br.infnet.edu.controlepresenca;

import br.infnet.edu.controlepresenca.model.domain.Empresa;
import br.infnet.edu.controlepresenca.model.domain.Evento;
import br.infnet.edu.controlepresenca.model.service.EmpresaService;
import br.infnet.edu.controlepresenca.model.service.EventoService;
import br.infnet.edu.controlepresenca.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Order(3)
@Component
public class EmpresaLoader implements ApplicationRunner {

    @Autowired
    private EmpresaService empresaService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private EventoService eventoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        String nome = "INFNET";
        String cnpj = "1234567890/0";

        Empresa empresa = null;

//
        if(empresa == null) {

            empresa = new Empresa();
            empresa.setNome(nome);
            empresa.setCpnj(cnpj);
            empresa.setUsuario(usuarioService.obterPorId(1));
            empresa.setEventos(eventoService.obterLista(empresa.getUsuario()));
            empresaService.incluir(empresa);
        }

    }
}
