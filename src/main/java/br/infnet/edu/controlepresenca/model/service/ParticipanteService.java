package br.infnet.edu.controlepresenca.model.service;

import br.infnet.edu.controlepresenca.model.domain.Participante;
import br.infnet.edu.controlepresenca.model.domain.Usuario;
import br.infnet.edu.controlepresenca.model.repository.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ParticipanteService {
    @Autowired
    private ParticipanteRepository participanteRepository;

    public void incluir(Participante participante) {
        participanteRepository.save(participante);
    }

    public void excluir(Integer id) {
        participanteRepository.deleteById(id);
    }

    public Participante obterPorId(Integer id) {
        return participanteRepository.findById(id).orElse(null);
    }

    public Collection<Participante> obterLista(Usuario usuario) {
        return (Collection<Participante>) participanteRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "nome"));
    }

    public Collection<Participante> obterLista() {
        return (Collection<Participante>) participanteRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
    }

    public Integer obterQtde(){
        return (int) participanteRepository.count();
    }
}
