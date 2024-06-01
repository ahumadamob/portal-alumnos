package com.ahumadamob.alumnos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahumadamob.alumnos.controller.util.APIResponse;
import com.ahumadamob.alumnos.controller.util.ResponseUtil;
import com.ahumadamob.alumnos.entity.Profesor;
import com.ahumadamob.alumnos.service.IProfesorService;

@RestController
@RequestMapping("/api/v1/profesor")
public class ProfesorController {
	
	@Autowired
	private IProfesorService profesorService;
	
	//private IPersonaService personaService;
	
	@GetMapping
	public ResponseEntity<APIResponse<List<Profesor>>> getAllProfesor() {

		List<Profesor> profesores = profesorService.getAll();
		return (profesores.isEmpty()) 
				? ResponseUtil.success("No se encontraron profesores.")
				: ResponseUtil.success(profesores);
	}
	
	@PostMapping
	public ResponseEntity<APIResponse<Profesor>>createProfesor(@RequestBody Profesor profesor){

		return profesorService.exists(profesor.getId())
			? ResponseUtil.badRequest("El ID especificado ya se encuentra registrado")
			: ResponseUtil.created(profesorService.save(profesor), "Profesor creado satisfactoriamente");
	}
}
