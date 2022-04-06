package br.infnet.edu.controlepresenca.controller;

import br.infnet.edu.controlepresenca.model.domain.Organizador;
import br.infnet.edu.controlepresenca.model.domain.Ouvinte;
import br.infnet.edu.controlepresenca.model.domain.Usuario;
import br.infnet.edu.controlepresenca.model.service.OuvinteService;
import br.infnet.edu.controlepresenca.model.service.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class OuvinteController {
    @Autowired
    private OuvinteService ouvinteService;
    @Autowired
    private ParticipanteService participanteService;

    @GetMapping(value = "/ouvinte")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

        model.addAttribute("ouvinteLista", ouvinteService.obterLista(usuario));

        return "ouvinte/lista";
    }

    @GetMapping(value = "/ouvintes")
    public String telaCadastro() {
        return "ouvinte/cadastro";
    }

    @PostMapping(value = "/ouvinte/incluir")
    public String incluir(Model model, Ouvinte ouvinte, @SessionAttribute("user") Usuario usuario) {

        ouvinte.setUsuario(usuario);

        participanteService.incluir(ouvinte);

        model.addAttribute("mensagem", "O ouvinte " + ouvinte.getNome() + " foi incluído com sucesso!!!");

        return telaLista(model, usuario);
    }

    @GetMapping(value = "/ouvinte/{id}/excluir")
    public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

        Ouvinte ouvinte = (Ouvinte) participanteService.obterPorId(id);

        if(ouvinte != null) {
            try {
                participanteService.excluir(id);
                model.addAttribute("mensagem", "O ouvinte "+ouvinte.getNome()+" foi excluído com sucesso!!!");
            } catch (Exception e) {
                model.addAttribute("mensagem", "Impossível realizar a exclusão! O ouvinte "+ouvinte.getNome()+" está associado a um evento!!!");
            }
        } else {
            model.addAttribute("mensagem", "Organizador inexistente.. impossível realizar a exclusão!!!");
        }

        return telaLista(model, usuario);
    }
}
