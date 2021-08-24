package com.sefaz.sistemaficha.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.sefaz.sistemaficha.entities.FichaFuncional;
import com.sefaz.sistemaficha.services.FichaFuncionalService;

@RestController
@RequestMapping(value = "/fichasfuncionais")
public class FichaFuncionalResource {

	/* Injeção do FichaFuncionalService */
	@Autowired
	private FichaFuncionalService service;
	
	@GetMapping
	public ResponseEntity<List<FichaFuncional>> findAll(){
		List<FichaFuncional> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<FichaFuncional> findById(@PathVariable Long id){
		FichaFuncional ficha = service.findById(id);
		return ResponseEntity.ok().body(ficha);
	}
	
	@PostMapping
	public ResponseEntity<FichaFuncional> create(@RequestBody FichaFuncional ficha){
		ficha = service.create(ficha);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ficha.getId()).toUri();
		return ResponseEntity.created(uri).body(ficha);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<FichaFuncional> update(@PathVariable Long id, @RequestBody FichaFuncional ficha){
		FichaFuncional fichaAtualizada = service.update(id, ficha);
		return ResponseEntity.ok().body(fichaAtualizada);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
