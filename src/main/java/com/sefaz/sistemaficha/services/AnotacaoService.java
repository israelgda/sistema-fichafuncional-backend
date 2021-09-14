package com.sefaz.sistemaficha.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sefaz.sistemaficha.entities.Anotacao;
import com.sefaz.sistemaficha.repositories.AnotacaoRepository;
import com.sefaz.sistemaficha.services.exceptions.ResourceNotFoundException;

@Service
public class AnotacaoService {

	private final AnotacaoRepository repository;
	
	public AnotacaoService(AnotacaoRepository repository) {
		this.repository = repository;
	}
	
	public List<Anotacao> findAll(){
		List<Anotacao> list = repository.findAll();
		return list;
	}
	
	public Anotacao findById(Long id) {
		Optional<Anotacao> anotacao = repository.findById(id);
		return anotacao.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public List<Anotacao> findAllByIdFicha(Long id){
		List<Anotacao> list = repository.findAllByIdFicha(id);
		return list;
	}
	
	public Anotacao create(Anotacao anotacao) {
		anotacao = repository.save(anotacao);
		return anotacao;
	}
	
	public Anotacao update(Long id, Anotacao anotacao) {
		try {
			Anotacao anotacaoAtualizada = findById(id);
			
			/* Atualizando Anotacao através do método local 'updateAnotacao' */
			anotacaoAtualizada = updateAnotacao(anotacao, anotacaoAtualizada);
			return repository.save(anotacaoAtualizada);
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private Anotacao updateAnotacao(Anotacao anotacao, Anotacao anotacaoAtualizada) {
		
		anotacaoAtualizada.setDescricao(anotacao.getDescricao());
		anotacaoAtualizada.setTipo(anotacao.getTipo());
		anotacaoAtualizada.setDataAnotacao(anotacao.getDataAnotacao());
		return anotacaoAtualizada;
	}
	
	
}
