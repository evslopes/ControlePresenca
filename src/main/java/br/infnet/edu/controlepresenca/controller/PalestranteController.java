package br.infnet.edu.controlepresenca.controller;

import br.infnet.edu.controlepresenca.model.domain.Palestrante;
import br.infnet.edu.controlepresenca.model.domain.Usuario;
import br.infnet.edu.controlepresenca.model.service.PalestranteService;
import br.infnet.edu.controlepresenca.model.service.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class PalestranteController {
    @Autowired
    private PalestranteService palestranteService;
    @Autowired
    private ParticipanteService participanteService;

    @GetMapping(value = "/palestrantes")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

        model.addAttribute("palestranteLista", palestranteService.obterLista(usuario));

        return "palestrante/lista";
    }

    @GetMapping(value = "/palestrante")
    public String telaCadastro() {
        return "palestrante/cadastro";
    }

    @PostMapping(value = "/palestrante/incluir")
    public String incluir(Model model, Palestrante palestrante, @SessionAttribute("user") Usuario usuario) {

        palestrante.setUsuario(usuario);

        palestranteService.incluir(palestrante);

        model.addAttribute("mensagem", "O palestrante " + palestrante.getNome() + " foi incluído com sucesso!!!");

        return telaLista(model, usuario);
    }

    @GetMapping(value = "/palestrante/{id}/excluir")
    public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

        Palestrante palestrante = palestranteService.obterPorId(id);

        if(palestrante != null) {
            try {
                participanteService.excluir(id);
                model.addAttribute("mensagem", "O palestrante "+palestrante.getNome()+" foi excluído com sucesso!!!");
            } catch (Exception e) {
                model.addAttribute("mensagem", "Impossível realizar a exclusão! O palestrante "+palestrante.getNome()+" está associada a uma palestra!!!");
            }
        } else {
            model.addAttribute("mensagem", "Palestrante inexistente.. impossível realizar a exclusão!!!");
        }

        return telaLista(model, usuario);
    }
}
