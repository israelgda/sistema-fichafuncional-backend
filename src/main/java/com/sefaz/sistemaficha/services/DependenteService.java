package com.sefaz.sistemaficha.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sefaz.sistemaficha.entities.Dependente;
import com.sefaz.sistemaficha.repositories.DependenteRepository;
import com.sefaz.sistemaficha.services.exceptions.ResourceNotFoundException;

@Service
public class DependenteService {

	@Autowired
	private DependenteRepository repository;
	
	public List<Dependente> findAll(){
		List<Dependente> list = repository.findAll();
		return list;
	}
	
	public Dependente findById(Integer id) {
		Optional<Dependente> dependente = repository.findById(id);
		return dependente.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Dependente create(Dependente dependente) {
		dependente = repository.save(dependente);
		return dependente;
	}
	
	public Dependente update(Integer id, Dependente dependente) {
		try {
			Dependente dependenteAtualizado = findById(id);
			
			/* Atualizando Dependente através do método local 'updateDependente' */
			dependenteAtualizado = updateDependente(dependente, dependenteAtualizado);
			return repository.save(dependenteAtualizado);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public void delete(Integer id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public Dependente updateDependente(Dependente dependente, Dependente dependenteAtualizado) {
		
		dependenteAtualizado.setDataNascimento(dependente.getDataNascimento());
		dependenteAtualizado.setNome(dependente.getNome());
		dependenteAtualizado.setNumCpf(dependente.getNumCpf());
		dependenteAtualizado.setNumRegistroCivil(dependente.getNumRegistroCivil());
		dependenteAtualizado.setParentesco(dependente.getParentesco());
		dependenteAtualizado.setSexo(dependente.getSexo());
		return repository.save(dependenteAtualizado);
	}
}
