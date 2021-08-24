package com.sefaz.sistemaficha.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sefaz.sistemaficha.entities.Dependente;

@Repository
public interface DependenteRepository extends JpaRepository<Dependente, Long>{

	@Query(value = "CALL sp_consulta_dependentes(:id)", nativeQuery = true)
	List<Dependente> findAllPorFichaId(Long id);
}
