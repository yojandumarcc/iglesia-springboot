package com.arqui.ufps.freelancer.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_usuario database table.
 * 
 */
//@Entity
//@Table(name="tipo_usuario")
public class TipoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	//@Id
	//@Column(name="idtipo_usuario")
	private int idtipoUsuario;

	//@Lob
	private String tipo;

	
	private List<User> usuarios;

	public TipoUsuario() {
	}

	public int getIdtipoUsuario() {
		return this.idtipoUsuario;
	}

	public void setIdtipoUsuario(int idtipoUsuario) {
		this.idtipoUsuario = idtipoUsuario;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<User> getUsuarios() {
		return this.usuarios;
	}

	

}