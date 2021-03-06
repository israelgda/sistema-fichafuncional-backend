package com.sefaz.sistemaficha.resources;

import java.net.URI;
import java.util.List;

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

import com.sefaz.sistemaficha.entities.Dependente;
import com.sefaz.sistemaficha.services.DependenteService;

@RestController
@RequestMapping(value = "/dependentes")
public class DependenteResource {

	private final DependenteService service;
	
	public DependenteResource(DependenteService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<Dependente>> findAll(){
		List<Dependente> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Dependente> findById(@PathVariable Long id){
		Dependente dependente = service.findById(id);
		return ResponseEntity.ok().body(dependente);
	}
	
	@GetMapping(value = "/porfichafuncional/{id}")
	public ResponseEntity<List<Dependente>> findAllPorFichaId(@PathVariable Long id){
		List<Dependente> list = service.findAllPorFichaId(id);
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Dependente> create(@RequestBody Dependente dependente){
		dependente = service.create(dependente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dependente.getId()).toUri();
		return ResponseEntity.created(uri).body(dependente);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Dependente> update(@PathVariable Long id, @RequestBody Dependente dependente){
		Dependente dependenteAtualizado = service.update(id, dependente);
		return ResponseEntity.ok().body(dependenteAtualizado);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}

