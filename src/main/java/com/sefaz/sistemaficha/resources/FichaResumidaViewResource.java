package com.sefaz.sistemaficha.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sefaz.sistemaficha.entities.FichaResumidaView;
import com.sefaz.sistemaficha.services.FichaResumidaViewService;

@RestController
@RequestMapping(value = "/consultar")
public class FichaResumidaViewResource {

	private final FichaResumidaViewService service;
	
	public FichaResumidaViewResource(FichaResumidaViewService service) {
		this.service = service;
	}
	
	@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
	@GetMapping
	public ResponseEntity<List<FichaResumidaView>> findAll(){
		List<FichaResumidaView> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
	@GetMapping(value = "/{id}")
	public ResponseEntity<FichaResumidaView> findById(@PathVariable Long id){
		FichaResumidaView ficha = service.findById(id);
		return ResponseEntity.ok().body(ficha);
	}
	
	@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
	@GetMapping(value = "/poranotacao/{id}")
	public ResponseEntity<List<FichaResumidaView>> findAllPorAnotacaoId(@PathVariable Long id){
		List<FichaResumidaView> list = service.findAllPorAnotacaoId(id);
		return ResponseEntity.ok().body(list);
	}
}
