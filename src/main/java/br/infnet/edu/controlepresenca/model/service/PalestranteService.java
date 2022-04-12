package br.infnet.edu.controlepresenca.model.service;

import br.infnet.edu.controlepresenca.model.domain.Ouvinte;
import br.infnet.edu.controlepresenca.model.domain.Palestrante;
import br.infnet.edu.controlepresenca.model.domain.Usuario;
import br.infnet.edu.controlepresenca.model.repository.PalestranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class PalestranteService {
    @Autowired
    private PalestranteRepository palestranteRepository;

    public void incluir(Palestrante palestrante) {
        palestranteRepository.save(palestrante);
    }

    public Palestrante obterPorId(Integer id) {
        return palestranteRepository.findById(id).orElse(null);
    }

    public List<Palestrante> obterLista(Usuario usuario) {
        return (List<Palestrante>)  palestranteRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "nome"));
    }
    public List<Palestrante> obterLista() {
        return (List<Palestrante>) palestranteRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
    }
}
