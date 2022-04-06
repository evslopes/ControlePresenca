package br.infnet.edu.controlepresenca.model.repository;

import br.infnet.edu.controlepresenca.model.domain.Palestra;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface PalestraRepository extends CrudRepository<Palestra, Integer> {
    @Query("from Palestra p where p.usuario.id = :idUsuario")
    Collection<Palestra> findAll(Integer idUsuario, Sort by);

    Collection<Palestra> findAll(Sort by);
}