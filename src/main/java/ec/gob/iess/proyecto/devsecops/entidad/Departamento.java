package ec.gob.iess.proyecto.devsecops.entidad;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "DEPARTAMENTO", schema = "erick")
@JsonIgnoreProperties(value = "empresa")
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dep_s")
	@SequenceGenerator(name = "dep_s", sequenceName = "dep_s", allocationSize = 1)
	@Column(name = "id_Depa")
	private Integer idDepa;
	@Column(name = "creado_por", nullable = false)
	private String creadoPor;
	@Column(name = "fecha_creado", nullable = false)
	private Timestamp fechaCreado;
	@Column(name = "modificado_por", nullable = false)
	private String modificadoPor;
	@Column(name = "fecha_modificado", nullable = false)
	private Timestamp fechaModificado;
	@Column(name = "estado", nullable = false)
	private Boolean estado;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "nombre", nullable = false)
	private String nombre;
	@Column(name = "telefono")
	private String telefono;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idEmpr", nullable = false)
	private Empresa empresa;

	@OneToMany(mappedBy = "departamento", cascade = CascadeType.PERSIST)
	private List<DepartamentosEmpleados> departamentosEmpleados;

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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa2) {
		this.empresa = empresa2;
	}

	public List<DepartamentosEmpleados> getDepartamentosEmpleados() {
		return departamentosEmpleados;
	}

	public void setDepartamentosEmpleados(List<DepartamentosEmpleados> departamentosEmpleados) {
		this.departamentosEmpleados = departamentosEmpleados;
	}

}
