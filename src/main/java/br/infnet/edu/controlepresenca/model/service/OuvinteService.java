package br.infnet.edu.controlepresenca.model.service;

import br.infnet.edu.controlepresenca.model.domain.Organizador;
import br.infnet.edu.controlepresenca.model.domain.Ouvinte;
import br.infnet.edu.controlepresenca.model.domain.Usuario;
import br.infnet.edu.controlepresenca.model.repository.OuvinteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class OuvinteService {

    @Autowired
    private OuvinteRepository ouvinteRepository;

    public void incluir(Ouvinte ouvinte) {
        ouvinteRepository.save(ouvinte);
    }

    public Ouvinte obterPorId(Integer id) {
        return ouvinteRepository.findById(id).orElse(null);
    }


    public Collection<Ouvinte> obterLista(Usuario usuario) {
        return (Collection<Ouvinte>) ouvinteRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "nome"));
    }
    public Collection<Ouvinte> obterLista() {
        return (Collection<Ouvinte>) ouvinteRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
    }

}
