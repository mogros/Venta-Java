package com.mitocode.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
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

import com.mitocode.exception.ModeloNotFoundException;
import com.mitocode.model.Venta;
import com.mitocode.service.IVentaService;

@RestController
@RequestMapping("/ventas")
public class VentaController {

	@Autowired
	private IVentaService service;
	
	@GetMapping
	public ResponseEntity<List<Venta>> listar() throws Exception{
		return new ResponseEntity<>(service.listar(), HttpStatus.OK);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Venta> listarPorId(@PathVariable("id") Integer id) throws Exception{
		Ventaobj = service.listarPorId(id);
		
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<>(obj, HttpStatus.OK); 		
	}
	
	@PostMapping
	public ResponseEntity<Venta> registrar(@Valid @RequestBody ConsultaListaExamenDTO dto) throws Exception {
		//return new ResponseEntity<>(service.registrar(obj), HttpStatus.CREATED); //201 		
		 
		Consulta obj = service.registrarTransaccional(dto);
		//localhost:8080/consultas/1
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdConsulta()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Venta> modificar(@Valid @RequestBody Venta venta) throws Exception {
		return new ResponseEntity<>(service.modificar(venta), HttpStatus.OK);		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{		
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/hateoas/{id}")
	public EntityModel<Venta> listarHateoasPorId(@PathVariable("id") Integer id) throws Exception{
		Venta obj = service.listarPorId(id);
		
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		EntityModel<Venta> recurso = EntityModel.of(obj);
		//localhost:8080/Ventas/hateoas/1
		WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).listarHateoasPorId(id));
		WebMvcLinkBuilder link2 = linkTo(methodOn(this.getClass()).listarHateoasPorId(id));
		recurso.add(link1.withRel("Venta-recurso1"));
		recurso.add(link2.withRel("Venta-recurso2"));
		
		return recurso;
		
	}
	
	
}
