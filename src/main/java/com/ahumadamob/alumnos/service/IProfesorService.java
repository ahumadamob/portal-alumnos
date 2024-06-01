package com.ahumadamob.alumnos.service;

import java.util.List;

import com.ahumadamob.alumnos.entity.Profesor;

public interface IProfesorService {
	public List<Profesor> getAll();
	public Profesor getById(Integer id);
	public Profesor save(Profesor localidad);
	public void delete(Integer id);
	public boolean exists(Integer id);
}
