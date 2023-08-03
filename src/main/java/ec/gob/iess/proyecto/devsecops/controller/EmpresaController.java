package ec.gob.iess.proyecto.devsecops.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.iess.proyecto.devsecops.dto.DepartamentoTO;
import ec.gob.iess.proyecto.devsecops.dto.EmpresaTO;
import ec.gob.iess.proyecto.devsecops.entidad.Empresa;
import ec.gob.iess.proyecto.devsecops.servicio.DepartamentoServicio;
import ec.gob.iess.proyecto.devsecops.servicio.EmpresaServicio;


/**
 * The Class EmpresaController.
 */
@RestController
@RequestMapping("/empresas")
public class EmpresaController {

	/** The empresa servicio. */
	@Autowired
	private EmpresaServicio empresaServicio;
	
	/** The departamento servicio. */
	@Autowired
	private DepartamentoServicio departamentoServicio;
	
	/**
	 * Insertar.
	 *
	 * @param empresa the empresa
	 * @return the empresa
	 */
	@PostMapping
	public Empresa insertar(@RequestBody Empresa empresa) {
		return this.empresaServicio.insertarActualizar(empresa);
	}
	
	/*@GetMapping
	public List<Empresa> buscarTodos(){
		return this.empresaServicio.buscarTodosActivos();
	}*/
	
	/**
	 * Buscar por id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	@GetMapping(path = "/{id}")
	public Empresa buscarPorId(@PathVariable Integer id) {
		return this.empresaServicio.buscarPorId(id);
	}
	
	/**
	 * Actualizar datos.
	 *
	 * @param empresa the empresa
	 * @return the empresa
	 */
	@PutMapping
	public Empresa actualizarDatos(@RequestBody Empresa empresa) {
		return this.empresaServicio.insertarActualizar(empresa);
	}
	
	/**
	 * Buscar todos.
	 *
	 * @return the list
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EmpresaTO> buscarTodos(){
		List<EmpresaTO> e = this.empresaServicio.buscarEmpresas();
		for(EmpresaTO l : e) {
			Link miLink = linkTo(methodOn(EmpresaController.class).buscarPorIdEmpr(l.getIdEmpr())).withRel("departamentos");
			l.add(miLink);
		}
		return e;
	}
	
	/**
	 * Buscar por id empr.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@GetMapping(path = "/{id}/departamentos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DepartamentoTO> buscarPorIdEmpr(@PathVariable Integer id){
		return new ResponseEntity(this.departamentoServicio.buscarDepartamentos(id), null, 217);
	}
}
