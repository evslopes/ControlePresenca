package br.infnet.edu.controlepresenca.model.service;

import br.infnet.edu.controlepresenca.model.domain.Empresa;
import br.infnet.edu.controlepresenca.model.domain.Evento;
import br.infnet.edu.controlepresenca.model.domain.Organizador;
import br.infnet.edu.controlepresenca.model.domain.Usuario;
import br.infnet.edu.controlepresenca.model.repository.OrganizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class OrganizadorService {

    @Autowired
    private OrganizadorRepository organizadorRepository;

    public void incluir(Organizador organizador) {
        organizadorRepository.save(organizador);
    }

    public Organizador obterPorId(Integer id) {
        return organizadorRepository.findById(id).orElse(null);
    }

    public Collection<Organizador> obterLista(Usuario usuario) {
        return (Collection<Organizador>) organizadorRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "nome"));
    }
    public Collection<Organizador> obterLista() {
        return (Collection<Organizador>) organizadorRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
    }

    public Integer obterQtde(){
        return (int) organizadorRepository.count();
    }
}
