package br.infnet.edu.controlepresenca.model.repository;

import br.infnet.edu.controlepresenca.model.domain.Ouvinte;
import br.infnet.edu.controlepresenca.model.domain.Participante;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface OuvinteRepository extends CrudRepository<Ouvinte, Integer> {
    @Query("from Ouvinte p where p.usuario.id = :idUsuario")
    Collection<Ouvinte> findAll(Integer idUsuario, Sort by);

    Collection<Ouvinte> findAll(Sort by);
}