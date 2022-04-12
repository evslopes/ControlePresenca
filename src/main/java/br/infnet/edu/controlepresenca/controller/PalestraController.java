package br.infnet.edu.controlepresenca.controller;

import br.infnet.edu.controlepresenca.model.domain.Evento;
import br.infnet.edu.controlepresenca.model.domain.Palestra;
import br.infnet.edu.controlepresenca.model.domain.Usuario;
import br.infnet.edu.controlepresenca.model.service.PalestraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class PalestraController {

    @Autowired
    private PalestraService palestraService;

    @GetMapping(value = "/palestras")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

        model.addAttribute("palestraLista", palestraService.obterLista(usuario));

        return "palestra/lista";
    }

    @GetMapping(value = "/palestra")
    public String telaCadastro() {
        return "palestra/cadastro";
    }

    @PostMapping(value = "/palestra/incluir")
    public String incluir(Palestra palestra, Model model, @SessionAttribute("user") Usuario usuario){

        palestra.setUsuario(usuario);

        palestraService.incluir(palestra);

        model.addAttribute("mensagem", "A palestra " + palestra.getNome() + " foi incluída com sucesso!!!");

        return telaLista(model, usuario);
    }

    @GetMapping(value = "/palestra/{id}/excluir")
    public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

        Palestra palestra = palestraService.obterPorId(id);

        if(palestra != null) {
            try {
                palestraService.excluir(id);
                model.addAttribute("mensagem", "A " +palestra.getNome()+" foi excluída com sucesso!!!");
            } catch (Exception e) {
                model.addAttribute("mensagem", "Impossível realizar a exclusão! A "+palestra.getNome()+" está associada a um palestrante!!!");
            }
        } else {
            model.addAttribute("mensagem", "Palestra inexistente.. impossível realizar a exclusão!!!");
        }

        return telaLista(model, usuario);
    }

}
