package com.microservicios.celulares.controlladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.microservicios.celulares.entity.Celular;
import com.microservicios.celulares.servicios.CelularService;

@RestController
public class CelularController {
	@Autowired
	private CelularService service;

	@GetMapping("/list")
	public List<Celular> listar() { return service.findAll(); }

	@GetMapping("/celular/{id}")
	public Celular detail(@PathVariable long id) { return service.findById(id); }

	@DeleteMapping ("/celular/{id}")
	public ResponseEntity<Void> drop(@PathVariable long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/celular")
	public ResponseEntity<Celular> create(@RequestBody Celular instance) {
		Celular cel = service.save(instance);
		return new ResponseEntity<>(cel, HttpStatus.CREATED);
	}

	@PutMapping("/celular/{id}")
	public ResponseEntity<Celular> update( @PathVariable long id, @RequestBody Celular instance) {
		if(service.existsById(id)) {
			instance.setId(id);
			Celular cel = service.save(instance);
			return new ResponseEntity<>(cel, HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}


}
