package ec.gob.iess.proyecto.devsecops.entidad;

import java.sql.Timestamp;
import java.util.List;

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
 * The Class Empresa.
 */
@Entity
@Table(name = "EMPRESA", schema = "erick")
public class Empresa {

	/** The id empr. */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ent_s")
	@SequenceGenerator(name = "ent_s", sequenceName = "ent_s", allocationSize = 1)
	@Column(name = "id_Empr")
	private Integer idEmpr;
	
	/** The creado por. */
	@Column(name = "creado_por", nullable = false)
	private String creadoPor;
	
	/** The fecha creado. */
	@Column(name = "fecha_creado", nullable = false)
	private Timestamp fechaCreado;
	
	/** The modificado por. */
	@Column(name = "modificado_Por", nullable = false)
	private String modificadoPor;
	
	/** The fecha modificado. */
	@Column(name = "fecha_modificado", nullable = false)
	private Timestamp fechaModificado;
	
	/** The estado. */
	@Column(name = "estado", nullable = false)
	private Boolean estado;
	
	/** The direccion. */
	@Column(name = "direccion", length = 256)
	private String direccion;
	
	/** The nombre. */
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	/** The telefono. */
	@Column(name = "telefono", length = 10)
	private String telefono;

	/** The departamentos. */
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.PERSIST)
	private List<Departamento> departamentos;

	/**
	 * Gets the id empr.
	 *
	 * @return the id empr
	 */
	public Integer getIdEmpr() {
		return idEmpr;
	}

	/**
	 * Sets the id empr.
	 *
	 * @param idEmpr the new id empr
	 */
	public void setIdEmpr(Integer idEmpr) {
		this.idEmpr = idEmpr;
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
	 * Gets the direccion.
	 *
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Sets the direccion.
	 *
	 * @param direccion the new direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
	 * Gets the telefono.
	 *
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Sets the telefono.
	 *
	 * @param telefono the new telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Gets the departamentos.
	 *
	 * @return the departamentos
	 */
	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	/**
	 * Sets the departamentos.
	 *
	 * @param departamentos the new departamentos
	 */
	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

}
