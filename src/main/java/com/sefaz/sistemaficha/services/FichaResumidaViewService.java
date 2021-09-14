package com.sefaz.sistemaficha.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sefaz.sistemaficha.entities.FichaResumidaView;
import com.sefaz.sistemaficha.repositories.FichaResumidaViewRepository;
import com.sefaz.sistemaficha.services.exceptions.ResourceNotFoundException;

@Service
public class FichaResumidaViewService {

	private final FichaResumidaViewRepository repository;
	
	public FichaResumidaViewService(FichaResumidaViewRepository repository) {
		this.repository = repository;
	}

	public List<FichaResumidaView> findAll() {
		List<FichaResumidaView> list = repository.findAllFichas();
		return list;
	}

	public FichaResumidaView findById(Long id) {
		Optional<FichaResumidaView> ficha = repository.findById(id);
		return ficha.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public List<FichaResumidaView> findAllPorAnotacaoId(Long id){
		List<FichaResumidaView> list = repository.findAllPorAnotacaoId(id);
		return list;
	}
}
