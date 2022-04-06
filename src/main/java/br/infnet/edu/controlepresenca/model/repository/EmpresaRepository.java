package br.infnet.edu.controlepresenca.model.repository;

import br.infnet.edu.controlepresenca.model.domain.Empresa;
import br.infnet.edu.controlepresenca.model.domain.Organizador;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface EmpresaRepository extends CrudRepository<Empresa, Integer> {
    @Query("from Empresa p where p.usuario.id = :idUsuario")
    Collection<Empresa> findAll(Integer idUsuario, Sort by);

    Collection<Empresa> findAll(Sort by);
}