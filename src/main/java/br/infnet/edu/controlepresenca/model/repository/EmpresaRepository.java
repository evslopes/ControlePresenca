package br.infnet.edu.controlepresenca.model.repository;

import br.infnet.edu.controlepresenca.model.domain.Empresa;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

public interface EmpresaRepository extends CrudRepository<Empresa, Integer> {
//    Object findAll(Integer id, Sort nome);
//
//    Object findAll(Sort nome);
}