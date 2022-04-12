package br.infnet.edu.controlepresenca.controller;

import br.infnet.edu.controlepresenca.model.domain.Empresa;
import br.infnet.edu.controlepresenca.model.domain.Usuario;
import br.infnet.edu.controlepresenca.model.service.EmpresaService;
import br.infnet.edu.controlepresenca.model.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;
    @Autowired
    private EventoService eventoService;

    @GetMapping(value = "/empresas")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

        model.addAttribute("empresaLista", empresaService.obterLista(usuario));

        return "empresa/lista";
    }

    @GetMapping(value = "/empresa")
    public String telaCadastro() {
        return "empresa/cadastro";
    }

    @PostMapping(value = "/empresa/incluir")
    public String incluir(Model model, Empresa empresa, @SessionAttribute("user") Usuario usuario) {

        empresa.setUsuario(usuario);

        empresaService.incluir(empresa);

        model.addAttribute("mensagem", "A empresa " + empresa.getNome() + " foi incluída com sucesso!!!");

        return telaLista(model, usuario);
    }

    @GetMapping(value = "/empresa/{id}/excluir")
    public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

        Empresa empresa = (Empresa) empresaService.obterPorId(id);

        if(empresa != null) {
            try {
                empresaService.excluir(id);
                model.addAttribute("mensagem", "A empresa "+empresa.getNome()+" foi excluída com sucesso!!!");
            } catch (Exception e) {
                model.addAttribute("mensagem", "Impossível realizar a exclusão! A empresa "+empresa.getNome()+" está associada a um pedido!!!");
            }
        } else {
            model.addAttribute("mensagem", "Empresa inexistente.. impossível realizar a exclusão!!!");
        }

        return telaLista(model, usuario);
    }
}
