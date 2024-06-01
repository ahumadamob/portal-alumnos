package com.ahumadamob.alumnos.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ahumadamob.alumnos.entity.Localidad;
import com.ahumadamob.alumnos.repository.LocalidadRepository;
import com.ahumadamob.alumnos.service.ILocalidadService;

@Service
public class LocalidadServiceImplJpa implements ILocalidadService {
	
	@Autowired
	private LocalidadRepository r;
	
	@Value("${localidad.error.list.notFound:default}")
    private String messageListNotFound;
	
	@Value("${localidad.error.notFound:default}")
    private String messageNotFound;
	
	@Value("${localidad.error.alreadyExist:default}")
    private String messageAlreadyExist;	
	
	@Value("${localidad.success.created:default}")
    private String messageSuccessCreated;
	
	@Value("${localidad.success.modified:default}")
    private String messageSuccessModified;
	
	@Value("${localidad.success.deleted:default}")
    private String messageSuccessDeleted;	

	@Override
	public List<Localidad> getAll() {
		return r.findAllByOrderByNombreAsc();
	}

	@Override
	public Localidad getById(Integer id) {
		Optional<Localidad> o = r.findById(id);
		return o.orElse(null);
	}

	@Override
	public Localidad save(Localidad localidad) {
		return r.save(localidad);
	}

	@Override
	public void delete(Integer id) {
		r.deleteById(id);		
	}
	
	@Override
	public boolean exists(Integer id) {
		return (id == null)? false : r.existsById(id);
	}

	@Override
	public String getMessageListNotFound() {
		return this.messageListNotFound;
	}

	@Override
	public String getMessageNotFound() {
		return this.messageListNotFound;
	}

	@Override
	public String getMessageAlreadyExist() {
		return this.messageAlreadyExist;
	}

	@Override
	public String getMessageSuccessCreated() {
		return this.messageSuccessCreated;
	}

	@Override
	public String getMessageSuccessModified() {
		return this.messageSuccessModified;
	}

	@Override
	public String getMessageSuccessDeleted() {
		return this.messageSuccessDeleted;
	}

}
