package com.sefaz.sistemaficha.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sefaz.sistemaficha.entities.FichaResumidaView;
import com.sefaz.sistemaficha.services.FichaResumidaViewService;

@RestController
@RequestMapping(value = "/consultar")
public class FichaResumidaViewResource {

	@Autowired
	private FichaResumidaViewService service;
	
	@GetMapping
	public ResponseEntity<List<FichaResumidaView>> findAll(){
		List<FichaResumidaView> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<FichaResumidaView> findById(@PathVariable Integer id){
		FichaResumidaView ficha = service.findById(id);
		return ResponseEntity.ok().body(ficha);
	}
	
	@GetMapping(value = "/poranotacao/{id}")
	public ResponseEntity<List<FichaResumidaView>> findAllPorAnotacaoId(@PathVariable Integer id){
		List<FichaResumidaView> list = service.findAllPorAnotacaoId(id);
		return ResponseEntity.ok().body(list);
	}
}
