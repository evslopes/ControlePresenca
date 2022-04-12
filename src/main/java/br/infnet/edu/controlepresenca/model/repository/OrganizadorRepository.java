package br.infnet.edu.controlepresenca.model.repository;

import br.infnet.edu.controlepresenca.model.domain.Organizador;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface OrganizadorRepository extends CrudRepository<Organizador, Integer> {
    @Query("from Organizador p where p.usuario.id = :idUsuario")
    Collection<Organizador> findAll(Integer idUsuario, Sort by);

    Collection<Organizador> findAll(Sort by);
}