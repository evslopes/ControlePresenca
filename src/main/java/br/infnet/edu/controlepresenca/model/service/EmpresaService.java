package br.infnet.edu.controlepresenca.model.service;

import br.infnet.edu.controlepresenca.model.domain.Empresa;
import br.infnet.edu.controlepresenca.model.domain.Evento;
import br.infnet.edu.controlepresenca.model.domain.Usuario;
import br.infnet.edu.controlepresenca.model.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public void incluir(Empresa empresa) {
        empresaRepository.save(empresa);
    }

    public void excluir(Integer id) {
        empresaRepository.deleteById(id);
    }

    public Empresa obterPorId(Integer id) {
        return empresaRepository.findById(id).orElse(null);
    }

    public Collection<Empresa> obterLista(Usuario usuario) {
        return (Collection<Empresa>) empresaRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "nome"));
    }
    public Collection<Empresa> obterLista() {
        return (Collection<Empresa>) empresaRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
    }

}
