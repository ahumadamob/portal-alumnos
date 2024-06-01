package com.ahumadamob.alumnos.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahumadamob.alumnos.entity.Profesor;
import com.ahumadamob.alumnos.repository.ProfesorRepository;
import com.ahumadamob.alumnos.service.IProfesorService;

@Service
public class ProfesorServiceImplJpa implements IProfesorService {
	
	@Autowired
	private ProfesorRepository r;

	@Override
	public List<Profesor> getAll() {
		return r.findByIsDeletedFalseOrderByPersonaApellidoAscPersonaNombreAsc();
	}

	@Override
	public Profesor getById(Integer id) {
		Optional<Profesor> o = r.findById(id);
		return o.orElse(null);
	}

	@Override
	public Profesor save(Profesor localidad) {
		return r.save(localidad);
	}

	@Override
	public void delete(Integer id) {
		r.deleteById(id);
	}

	@Override
	public boolean exists(Integer id) {		
		return (id == null)? false : r.existsById(null);
	}

}
