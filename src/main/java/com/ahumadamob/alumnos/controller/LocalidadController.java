package com.ahumadamob.alumnos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahumadamob.alumnos.controller.util.APIResponse;
import com.ahumadamob.alumnos.controller.util.ResponseUtil;
import com.ahumadamob.alumnos.entity.Localidad;
import com.ahumadamob.alumnos.service.ILocalidadService;

import jakarta.validation.ConstraintViolationException;

@RestController
@RequestMapping("/api/v1/localidad")
public class LocalidadController {
	 
	@Autowired
	ILocalidadService localidadService;

	@GetMapping
	public ResponseEntity<APIResponse<List<Localidad>>> getAllLocalidad() {

		List<Localidad> localidades = localidadService.getAll();
		return (localidades.isEmpty()) 
				? ResponseUtil.success(localidadService.getMessageListNotFound())
				: ResponseUtil.success(localidades);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<APIResponse<Localidad>>getLocalidadById(@PathVariable("id") Integer id){
		return localidadService.exists(id)
			? ResponseUtil.success(localidadService.getById(id))
			: ResponseUtil.success(localidadService.getMessageNotFound());
	}
	
	@PostMapping
	public ResponseEntity<APIResponse<Localidad>>createLocalidad(@RequestBody Localidad localidad){
		return localidadService.exists(localidad.getId())
			? ResponseUtil.badRequest(localidadService.getMessageAlreadyExist())
			: ResponseUtil.created(localidadService.save(localidad), localidadService.getMessageSuccessCreated());
		
	}
	
	@PutMapping
	public ResponseEntity<APIResponse<Localidad>>modifyLocalidad(@RequestBody Localidad localidad){
		return localidadService.exists(localidad.getId())
			? ResponseUtil.success(localidadService.save(localidad), localidadService.getMessageSuccessModified())
			: ResponseUtil.notFound(localidadService.getMessageNotFound());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<APIResponse<Localidad>>deleteLocalidad(@PathVariable("id") Integer id){
		return localidadService.exists(id)
			? ResponseUtil.success(localidadService.getMessageSuccessDeleted())
			: ResponseUtil.notFound(localidadService.getMessageNotFound());
	}
		
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<APIResponse<Object>> handleConstraintViolationException(ConstraintViolationException ex){
		return ResponseUtil.handleConstraintException(ex);
	}
	
}
	


