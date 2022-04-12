package br.infnet.edu.controlepresenca.model.service;

import br.infnet.edu.controlepresenca.model.domain.Palestra;
import br.infnet.edu.controlepresenca.model.domain.Usuario;
import br.infnet.edu.controlepresenca.model.repository.PalestraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PalestraService {
    @Autowired
    private PalestraRepository palestraRepository;

    public void incluir(Palestra palestra) {
        palestraRepository.save(palestra);
    }

    public void excluir(Integer id) {
        palestraRepository.deleteById(id);
    }

    public Palestra obterPorId(Integer id) {
        return palestraRepository.findById(id).orElse(null);
    }

    public Collection<Palestra> obterLista(Usuario usuario) {
        return (Collection<Palestra>) palestraRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "inicioPalestra"));
    }

    public Collection<Palestra> obterLista() {
        return (Collection<Palestra>) palestraRepository.findAll(Sort.by(Sort.Direction.ASC, "inicioPalestra"));
    }

    public Integer obterQtde(){
        return (int) palestraRepository.count();
    }
}
