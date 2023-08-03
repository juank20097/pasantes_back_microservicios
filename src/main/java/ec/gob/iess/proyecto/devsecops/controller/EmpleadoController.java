package ec.gob.iess.proyecto.devsecops.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.iess.proyecto.devsecops.entidad.Empleado;
import ec.gob.iess.proyecto.devsecops.servicio.EmpleadoServicio;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

	@Autowired
	private EmpleadoServicio empleadoServicio;
	
	@PostMapping
	public Empleado insertar(@RequestBody Empleado empleado) {
		return this.empleadoServicio.insertarActualizar(empleado);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Empleado> buscarTodos(){
		return this.empleadoServicio.buscarTodosActivos();
	}
	
	@GetMapping(path = "/{id}")
	public Empleado buscarPorId(@PathVariable Integer id) {
		return this.empleadoServicio.buscarPorId(id);
	}
	
	@PutMapping
	public Empleado actualizar(@RequestBody Empleado empleado) {
		return this.empleadoServicio.insertarActualizar(empleado);
	}
	
}
