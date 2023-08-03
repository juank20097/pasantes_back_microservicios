package ec.gob.iess.proyecto.devsecops.entidad;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 * The Class Empleado.
 */
@Entity
@Table(name = "EMPLEADO", schema = "erick")
public class Empleado {

	/** The id empl. */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_s")
	@SequenceGenerator(name = "emp_s", sequenceName = "emp_s", allocationSize = 1)
	@Column(name = "id_Empl")
	private Integer idEmpl;

	/** The creado por. */
	@Column(name = "creado_por", nullable = false)
	private String creadoPor;
	
	/** The fecha creado. */
	@Column(name = "fecha_creado", nullable = false)
	private Timestamp fechaCreado;
	
	/** The modificado por. */
	@Column(name = "modificado_por", nullable = false)
	private String modificadoPor;
	
	/** The fecha modificado. */
	@Column(name = "fecha_modificado", nullable = false)
	private Timestamp fechaModificado;
	
	/** The estado. */
	@Column(name = "estado", nullable = false)
	private Boolean estado;
	
	/** The edad. */
	@Column(name = "edad")
	private Integer edad;
	
	/** The correo. */
	@Column(name = "correo")
	private String correo;
	
	/** The nombre. */
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	/** The posicion. */
	@Column(name = "posicion")
	private String posicion;
	
	/** The apellido. */
	@Column(name = "apellido", nullable = false)
	private String apellido;

	/** The departamentos empleados. */
	@OneToMany(mappedBy = "empleado", cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties(value = "departamentosEmpleados")
	private List<DepartamentosEmpleados> departamentosEmpleados;

	/**
	 * Gets the id empl.
	 *
	 * @return the id empl
	 */
	public Integer getIdEmpl() {
		return idEmpl;
	}

	/**
	 * Sets the id empl.
	 *
	 * @param idEmpl the new id empl
	 */
	public void setIdEmpl(Integer idEmpl) {
		this.idEmpl = idEmpl;
	}

	/**
	 * Gets the creado por.
	 *
	 * @return the creado por
	 */
	public String getCreadoPor() {
		return creadoPor;
	}

	/**
	 * Sets the creado por.
	 *
	 * @param creadoPor the new creado por
	 */
	public void setCreadoPor(String creadoPor) {
		this.creadoPor = creadoPor;
	}

	/**
	 * Gets the fecha creado.
	 *
	 * @return the fecha creado
	 */
	public Timestamp getFechaCreado() {
		return fechaCreado;
	}

	/**
	 * Sets the fecha creado.
	 *
	 * @param fechaCreado the new fecha creado
	 */
	public void setFechaCreado(Timestamp fechaCreado) {
		this.fechaCreado = fechaCreado;
	}

	/**
	 * Gets the modificado por.
	 *
	 * @return the modificado por
	 */
	public String getModificadoPor() {
		return modificadoPor;
	}

	/**
	 * Sets the modificado por.
	 *
	 * @param modificadoPor the new modificado por
	 */
	public void setModificadoPor(String modificadoPor) {
		this.modificadoPor = modificadoPor;
	}

	/**
	 * Gets the fecha modificado.
	 *
	 * @return the fecha modificado
	 */
	public Timestamp getFechaModificado() {
		return fechaModificado;
	}

	/**
	 * Sets the fecha modificado.
	 *
	 * @param fechaModificado the new fecha modificado
	 */
	public void setFechaModificado(Timestamp fechaModificado) {
		this.fechaModificado = fechaModificado;
	}

	/**
	 * Gets the estado.
	 *
	 * @return the estado
	 */
	public Boolean getEstado() {
		return estado;
	}

	/**
	 * Sets the estado.
	 *
	 * @param estado the new estado
	 */
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	/**
	 * Gets the edad.
	 *
	 * @return the edad
	 */
	public Integer getEdad() {
		return edad;
	}

	/**
	 * Sets the edad.
	 *
	 * @param edad the new edad
	 */
	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	/**
	 * Gets the correo.
	 *
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * Sets the correo.
	 *
	 * @param correo the new correo
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Gets the posicion.
	 *
	 * @return the posicion
	 */
	public String getPosicion() {
		return posicion;
	}

	/**
	 * Sets the posicion.
	 *
	 * @param posicion the new posicion
	 */
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	/**
	 * Gets the apellido.
	 *
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Sets the apellido.
	 *
	 * @param apellido the new apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Gets the departamentos empleados.
	 *
	 * @return the departamentos empleados
	 */
	public List<DepartamentosEmpleados> getDepartamentosEmpleados() {
		return departamentosEmpleados;
	}

	/**
	 * Sets the departamentos empleados.
	 *
	 * @param departamentosEmpleados the new departamentos empleados
	 */
	public void setDepartamentosEmpleados(List<DepartamentosEmpleados> departamentosEmpleados) {
		this.departamentosEmpleados = departamentosEmpleados;
	}

}
