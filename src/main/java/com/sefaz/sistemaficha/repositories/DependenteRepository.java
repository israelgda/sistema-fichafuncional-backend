package com.sefaz.sistemaficha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sefaz.sistemaficha.entities.Dependente;

@Repository
public interface DependenteRepository extends JpaRepository<Dependente, Long>{

}
