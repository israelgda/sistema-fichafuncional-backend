package com.sefaz.sistemaficha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sefaz.sistemaficha.entities.FichaFuncional;

@Repository
public interface FichaFuncionalRepository extends JpaRepository<FichaFuncional, Integer>{

}
