package br.infnet.edu.controlepresenca.controller;

import br.infnet.edu.controlepresenca.model.domain.Organizador;
import br.infnet.edu.controlepresenca.model.domain.Participante;
import br.infnet.edu.controlepresenca.model.domain.Usuario;
import br.infnet.edu.controlepresenca.model.service.EventoService;
import br.infnet.edu.controlepresenca.model.service.OrganizadorService;
import br.infnet.edu.controlepresenca.model.service.ParticipanteService;
import br.infnet.edu.controlepresenca.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@SessionAttributes("user")
@Controller
public class AcessoController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private OrganizadorService organizadorService;
    @Autowired
    private EventoService eventoService;
    @Autowired
    private ParticipanteService participanteService;

    @GetMapping(value = "/")
    public String telaHome(Model model) {

        Map<String, Integer> appMapa = new HashMap<String, Integer>();
        appMapa.put("Usuário", usuarioService.obterQtde());
        appMapa.put("Evento", eventoService.obterQtde());
        appMapa.put("Organizador", organizadorService.obterQtde());
        appMapa.put("Participantes", participanteService.obterQtde());

        model.addAttribute("mapa", appMapa);

        return "index";
    }

    @GetMapping(value = "/login")
    public String telaLogin() {
        return "login";
    }

    @GetMapping(value = "/logout")
    public String logout(SessionStatus status, HttpSession session) {

        status.setComplete();
        session.removeAttribute("user");

        return "redirect:/";
    }

    @PostMapping(value = "/login")
    public String validar(Model model, @RequestParam String email, @RequestParam String senha){

        Usuario usuario = usuarioService.autenticacao(email, senha);

        if(usuario != null) {
            model.addAttribute("user", usuario);

            return "redirect:/";
        } else {
            model.addAttribute(
                    "mensagem",
                    "As credenciais do usuário "+ email +" estão incorretas!!!"
            );

            return telaLogin();
        }

    }
}