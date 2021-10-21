package model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;


@Entity
@Table(name="Cliente")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String rut;

	private String nombre;
	
	private String apellido;

	private Date fechaNac;

	private int nroContacto;

	private String correo;

	public Cliente() {
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public int getNroContacto() {
		return nroContacto;
	}

	public void setNroContacto(int nroContacto) {
		this.nroContacto = nroContacto;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}



}