package com.ahumadamob.alumnos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahumadamob.alumnos.entity.Localidad;

public interface LocalidadRepository extends JpaRepository<Localidad, Integer> {
	
	public List<Localidad> findAllByOrderByNombreAsc();
}
