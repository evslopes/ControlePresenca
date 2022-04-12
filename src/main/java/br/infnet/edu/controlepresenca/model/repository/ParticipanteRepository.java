package br.infnet.edu.controlepresenca.model.repository;

import br.infnet.edu.controlepresenca.model.domain.Participante;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface ParticipanteRepository extends CrudRepository<Participante, Integer> {
    @Query("from Participante p where p.usuario.id = :idusuario")
    Collection<Participante> findAll(Integer idusuario, Sort by);

    Collection<Participante> findAll(Sort by);
}