package com.sefaz.sistemaficha.resources;

import java.net.URI;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sefaz.sistemaficha.entities.Anotacao;
import com.sefaz.sistemaficha.services.AnotacaoService;

@RestController
@RequestMapping(value = "/anotacoes")
public class AnotacaoResource {
	
	private final AnotacaoService service;
	
	public AnotacaoResource(AnotacaoService service) {
		this.service = service;
	}
	
	//	IMPLEMENTAÇÃO DO CRUD

	@GetMapping
	public ResponseEntity<Page<Anotacao>> findAll(Pageable pageable){
		Page<Anotacao> list = service.findAll(pageable);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Anotacao> findById(@PathVariable Long id){
		Anotacao anotacao = service.findById(id);
		return ResponseEntity.ok().body(anotacao);
	}
	
	@GetMapping(value = "/porficha/{id}")
	public ResponseEntity<List<Anotacao>> findAllByIdFicha(@PathVariable Long id){
		List<Anotacao> list = service.findAllByIdFicha(id);
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Anotacao> create(@RequestBody Anotacao anotacao){
		anotacao = service.create(anotacao);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(anotacao.getId()).toUri();
		return ResponseEntity.created(uri).body(anotacao);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Anotacao> update(@PathVariable Long id, @RequestBody Anotacao anotacao){
		Anotacao anotacaoAtualizada = service.update(id, anotacao);
		return ResponseEntity.ok().body(anotacaoAtualizada);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
