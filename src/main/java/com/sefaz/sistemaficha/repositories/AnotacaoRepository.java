package com.sefaz.sistemaficha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sefaz.sistemaficha.entities.Anotacao;

@Repository
public interface AnotacaoRepository extends JpaRepository<Anotacao, Long>{

}
