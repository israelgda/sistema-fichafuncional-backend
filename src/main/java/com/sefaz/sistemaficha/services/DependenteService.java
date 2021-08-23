package com.sefaz.sistemaficha.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sefaz.sistemaficha.entities.Dependente;
import com.sefaz.sistemaficha.repositories.DependenteRepository;

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
		return dependente.get();
	}
	
	public Dependente create(Dependente dependente) {
		dependente = repository.save(dependente);
		return dependente;
	}
	
	public Dependente update(Integer id, Dependente dependente) {
		Dependente dependenteAtualizado = findById(id);
		
		/* Atualizando Dependente através do método local 'updateDependente' */
		dependenteAtualizado = updateDependente(dependente, dependenteAtualizado);
		return repository.save(dependenteAtualizado);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
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
