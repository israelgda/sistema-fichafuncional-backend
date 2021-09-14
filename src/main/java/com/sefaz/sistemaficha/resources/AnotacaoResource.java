package com.sefaz.sistemaficha.resources;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

	@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
	@GetMapping
	public ResponseEntity<List<Anotacao>> findAll(){
		List<Anotacao> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Anotacao> findById(@PathVariable Long id){
		Anotacao anotacao = service.findById(id);
		return ResponseEntity.ok().body(anotacao);
	}
	
	@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
	@GetMapping(value = "/porficha/{id}")
	public ResponseEntity<List<Anotacao>> findAllByIdFicha(@PathVariable Long id){
		List<Anotacao> list = service.findAllByIdFicha(id);
		return ResponseEntity.ok().body(list);
	}
	
	@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
	@PostMapping
	public ResponseEntity<Anotacao> create(@RequestBody Anotacao anotacao){
		anotacao = service.create(anotacao);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(anotacao.getId()).toUri();
		return ResponseEntity.created(uri).body(anotacao);
	}
	
	@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Anotacao> update(@PathVariable Long id, @RequestBody Anotacao anotacao){
		Anotacao anotacaoAtualizada = service.update(id, anotacao);
		return ResponseEntity.ok().body(anotacaoAtualizada);
	}
	
	@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
