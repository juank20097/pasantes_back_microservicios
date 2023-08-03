package ec.gob.iess.proyecto.devsecops.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.hateoas.RepresentationModel;

public class DepartamentoTO extends RepresentationModel<DepartamentoTO> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idDepa;
	private String creadoPor;
	private Timestamp fechaCreado;
	private String modificadoPor;
	private Timestamp fechaModificado;
	private Boolean estado;
	private String descripcion;
	private String nombre;
	private String telefono;
	private Integer idEmpr;

	public Integer getIdDepa() {
		return idDepa;
	}

	public void setIdDepa(Integer idDepa) {
		this.idDepa = idDepa;
	}

	public String getCreadoPor() {
		return creadoPor;
	}

	public void setCreadoPor(String creadoPor) {
		this.creadoPor = creadoPor;
	}

	public Timestamp getFechaCreado() {
		return fechaCreado;
	}

	public void setFechaCreado(Timestamp fechaCreado) {
		this.fechaCreado = fechaCreado;
	}

	public String getModificadoPor() {
		return modificadoPor;
	}

	public void setModificadoPor(String modificadoPor) {
		this.modificadoPor = modificadoPor;
	}

	public Timestamp getFechaModificado() {
		return fechaModificado;
	}

	public void setFechaModificado(Timestamp fechaModificado) {
		this.fechaModificado = fechaModificado;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getIdEmpr() {
		return idEmpr;
	}

	public void setIdEmpr(Integer idEmpr) {
		this.idEmpr = idEmpr;
	}
	
}
