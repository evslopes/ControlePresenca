package br.infnet.edu.controlepresenca.controller;

import br.infnet.edu.controlepresenca.model.domain.Evento;
import br.infnet.edu.controlepresenca.model.domain.Usuario;
import br.infnet.edu.controlepresenca.model.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping(value = "/evento")
    public String telaCadastro() {
        return "evento/cadastro";
    }

    @GetMapping(value = "/eventos")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

        model.addAttribute("eventoLista", eventoService.obterLista(usuario));

        return "evento/lista";
    }

    @PostMapping(value = "/evento/incluir")
    public String incluir(Evento evento, Model model, @SessionAttribute("user") Usuario usuario){

        evento.setUsuario(usuario);

        eventoService.incluir(evento);

        model.addAttribute("mensagem", "O evento " + evento.getNome() + " foi incluído com sucesso!!!");

        return telaLista(model, usuario);
    }

    @GetMapping(value = "/evento/{id}/excluir")
    public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

        Evento evento = eventoService.obterPorId(id);

        if(evento != null) {
            try {
                eventoService.excluir(id);
                model.addAttribute("mensagem", "O evento "+evento.getNome()+" foi excluído com sucesso!!!");
            } catch (Exception e) {
                model.addAttribute("mensagem", "Impossível realizar a exclusão! O evento "+evento.getNome()+" está associado a um pedido!!!");
            }
        } else {
            model.addAttribute("mensagem", "Solicitante inexistente.. impossível realizar a exclusão!!!");
        }

        return telaLista(model, usuario);
    }
}
