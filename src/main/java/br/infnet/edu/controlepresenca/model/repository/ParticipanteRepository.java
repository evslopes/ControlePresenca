package br.infnet.edu.controlepresenca.model.repository;

import br.infnet.edu.controlepresenca.model.domain.Participante;
import org.springframework.data.repository.CrudRepository;

public interface ParticipanteRepository extends CrudRepository<Participante, Integer> {
}