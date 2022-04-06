package br.infnet.edu.controlepresenca.model.repository;

import br.infnet.edu.controlepresenca.model.domain.Evento;
import br.infnet.edu.controlepresenca.model.domain.Organizador;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface EventoRepository extends CrudRepository<Evento, Integer> {
    @Query("from Evento p where p.usuario.id = :idUsuario")
    Collection<Evento> findAll(Integer idUsuario, Sort by);

    Collection<Evento> findAll(Sort by);
}