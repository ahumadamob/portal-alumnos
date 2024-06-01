package com.ahumadamob.alumnos.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ahumadamob.alumnos.entity.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {
	List<Profesor> findByIsDeletedFalseOrderByPersonaApellidoAscPersonaNombreAsc();
}
