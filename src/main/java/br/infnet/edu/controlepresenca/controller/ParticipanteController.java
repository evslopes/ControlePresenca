package br.infnet.edu.controlepresenca.controller;

import br.infnet.edu.controlepresenca.model.domain.Organizador;
import br.infnet.edu.controlepresenca.model.domain.Palestrante;
import br.infnet.edu.controlepresenca.model.domain.Participante;
import br.infnet.edu.controlepresenca.model.domain.Usuario;
import br.infnet.edu.controlepresenca.model.service.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ParticipanteController {

    @Autowired
    private ParticipanteService participanteService;

    @GetMapping(value = "/participantes")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

        model.addAttribute("participanteLista", participanteService.obterLista(usuario));

        return "participante/lista";
    }

    @GetMapping(value = "/participante/{id}/excluir")
    public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

        Participante participante = participanteService.obterPorId(id);

        String tipoParticipante = obterTipoParticipante(participante);

        if(participante != null) {
            try {
                participanteService.excluir(id);
                model.addAttribute("mensagem", "A "+tipoParticipante+" "+participante.getNome()+" foi excluída com sucesso!!!");
            } catch (Exception e) {
                model.addAttribute("mensagem", "Impossível realizar a exclusão! A "+tipoParticipante+" "+participante.getNome()+" está associada ao evento!!!");
            }
        } else {
            model.addAttribute("mensagem", "Participante inexistente.. impossível realizar a exclusão!!!");
        }

        return telaLista(model, usuario);
    }

    private String obterTipoParticipante(Participante participante) {
        String tipoParticipante = null;

        if(participante instanceof Organizador) {
            tipoParticipante = "organizador";
        }else if (participante instanceof Palestrante) {
            tipoParticipante = "palestrante";
        }else {
            tipoParticipante = "Ouvinte";
        }

        return tipoParticipante;
    }
}
