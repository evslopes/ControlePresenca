package br.infnet.edu.controlepresenca.model.repository;

import br.infnet.edu.controlepresenca.model.domain.Palestrante;
import org.springframework.data.repository.CrudRepository;

public interface PalestranteRepository extends CrudRepository<Palestrante, Integer> {
}