package com.sefaz.sistemaficha.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sefaz.sistemaficha.entities.FichaResumidaView;

@Repository
public interface FichaResumidaViewRepository extends JpaRepository<FichaResumidaView, Integer>{
	
	@Query(value = "SELECT * FROM v_listar_fichas", nativeQuery = true)
	List<FichaResumidaView> findAllFichas();
	
	@Query(value = "CALL sp_filtra_fichas_por_anotacao(:id)", nativeQuery=true)
	List<FichaResumidaView> findAllPorAnotacaoId(Integer id);

}
