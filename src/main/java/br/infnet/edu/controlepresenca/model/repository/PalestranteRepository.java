package br.infnet.edu.controlepresenca.model.repository;

import br.infnet.edu.controlepresenca.model.domain.Palestrante;
import br.infnet.edu.controlepresenca.model.domain.Participante;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface PalestranteRepository extends CrudRepository<Palestrante, Integer> {
    @Query("from Palestrante p where p.usuario.id = :idUsuario")
    Collection<Palestrante> findAll(Integer idUsuario, Sort by);

    Collection<Palestrante> findAll(Sort by);
}