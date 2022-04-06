package br.infnet.edu.controlepresenca.model.repository;

import br.infnet.edu.controlepresenca.model.domain.Participante;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ParticipanteRepository extends CrudRepository<Participante, Integer> {
    @Query("from Participante p where p.usuario.id = :idUsuario")
    Collection<Participante> findAll(Integer idUsuario, Sort by);

    Collection<Participante> findAll(Sort by);
}