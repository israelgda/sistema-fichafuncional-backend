package com.sefaz.sistemaficha.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sefaz.sistemaficha.entities.Anotacao;

@Repository
public interface AnotacaoRepository extends JpaRepository<Anotacao, Long>{
	
	@Query(value = "CALL sp_consulta_anotacoes_id_ficha(:id)", nativeQuery = true)
	List<Anotacao> findAllByIdFicha(Long id);

}
