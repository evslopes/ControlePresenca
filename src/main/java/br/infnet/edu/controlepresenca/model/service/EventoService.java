package br.infnet.edu.controlepresenca.model.service;

import br.infnet.edu.controlepresenca.model.domain.Evento;
import br.infnet.edu.controlepresenca.model.domain.Usuario;
import br.infnet.edu.controlepresenca.model.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    public void incluir(Evento evento) {
        eventoRepository.save(evento);
    }

    public void excluir(Integer id) {
        eventoRepository.deleteById(id);
    }

    public Evento obterPorId(Integer id) {
        return eventoRepository.findById(id).orElse(null);
    }

    public List<Evento> obterLista(Usuario usuario) {
        return (List<Evento>) eventoRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "nome"));
    }

    public Collection<Evento> obterLista() {
        return (Collection<Evento>) eventoRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
    }

    public Integer obterQtde(){
        return (int) eventoRepository.count();
    }
}
