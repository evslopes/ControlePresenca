package br.infnet.edu.controlepresenca.model.service;

import br.infnet.edu.controlepresenca.model.domain.Palestrante;
import br.infnet.edu.controlepresenca.model.domain.Usuario;
import br.infnet.edu.controlepresenca.model.repository.PalestranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PalestranteService {
    @Autowired
    private PalestranteRepository palestranteRepository;

    public Collection<Palestrante> obterLista(Usuario usuario) {
        return (Collection<Palestrante>) palestranteRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "nome"));
    }
    public Collection<Palestrante> obterLista() {
        return (Collection<Palestrante>) palestranteRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
    }
}
