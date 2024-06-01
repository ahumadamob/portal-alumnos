package com.ahumadamob.alumnos.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Alumno extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
	
	@OneToOne
	//@JoinColumn(name="persona_id")
	private Persona persona;
	
	@ManyToMany
    
	@JoinTable(
        name = "alumno_curso", // Nombre de la tabla de unión
        joinColumns = @JoinColumn(name = "alumno_id"), // Columna de la entidad actual en la tabla de unión
        inverseJoinColumns = @JoinColumn(name = "curso_id") // Columna de la entidad objetivo en la tabla de unión
    )    
	private List<Curso> cursos;	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
}
