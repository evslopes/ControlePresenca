package br.infnet.edu.controlepresenca.controller;

import br.infnet.edu.controlepresenca.model.domain.Organizador;
import br.infnet.edu.controlepresenca.model.domain.Usuario;
import br.infnet.edu.controlepresenca.model.service.OrganizadorService;
import br.infnet.edu.controlepresenca.model.service.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class OrganizadorController {
    @Autowired
    private OrganizadorService organizadorService;
    @Autowired
    private ParticipanteService participanteService;

    @GetMapping(value = "/organizador")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

        model.addAttribute("organizadorLista", organizadorService.obterLista(usuario));

        return "organizador/lista";
    }

    @GetMapping(value = "/organizadores")
    public String telaCadastro() {
        return "organizador/cadastro";
    }

    @PostMapping(value = "/organizador/incluir")
    public String incluir(Model model, Organizador organizador, @SessionAttribute("user") Usuario usuario) {

        organizador.setUsuario(usuario);

        participanteService.incluir(organizador);

        model.addAttribute("mensagem", "O organizador " + organizador.getNome() + " foi incluído com sucesso!!!");

        return telaLista(model, usuario);
    }

    @GetMapping(value = "/organizador/{id}/excluir")
    public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

        Organizador organizador = (Organizador) participanteService.obterPorId(id);

        if(organizador != null) {
            try {
                participanteService.excluir(id);
                model.addAttribute("mensagem", "O organizador "+organizador.getNome()+" foi excluído com sucesso!!!");
            } catch (Exception e) {
                model.addAttribute("mensagem", "Impossível realizar a exclusão! O organizador "+organizador.getNome()+" está associado a um evento!!!");
            }
        } else {
            model.addAttribute("mensagem", "Organizador inexistente.. impossível realizar a exclusão!!!");
        }

        return telaLista(model, usuario);
    }
}
