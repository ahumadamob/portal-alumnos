package com.ahumadamob.alumnos.service;

import java.util.List;
import com.ahumadamob.alumnos.entity.Localidad;

public interface ILocalidadService {
	
	public List<Localidad> getAll();
	public Localidad getById(Integer id);
	public Localidad save(Localidad localidad);
	public void delete(Integer id);
	public boolean exists(Integer id);
	public String getMessageListNotFound();
	public String getMessageNotFound();
	public String getMessageAlreadyExist();
	public String getMessageSuccessCreated();
	public String getMessageSuccessModified();
	public String getMessageSuccessDeleted();

}
