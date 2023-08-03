package ec.gob.iess.proyecto.devsecops.entidad;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "DEPARTAMENTOS_EMPLEADOS", schema = "erick")
public class DepartamentosEmpleados {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dep_emp_s")
	@SequenceGenerator(name = "dep_emp_s", sequenceName = "dep_emp_s", allocationSize = 1)
	@Column(name = "id_depEmp")
	private Integer idDepaEmpl;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idDepa")
	private Departamento departamento;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idEmpl")
	private Empleado empleado;

	public Integer getIdDepaEmpl() {
		return idDepaEmpl;
	}

	public void setIdDepaEmpl(Integer idDepaEmpl) {
		this.idDepaEmpl = idDepaEmpl;
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

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

}
