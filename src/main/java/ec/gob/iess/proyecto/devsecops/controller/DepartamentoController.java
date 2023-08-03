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

import ec.gob.iess.proyecto.devsecops.dto.DepartamentoTO;
import ec.gob.iess.proyecto.devsecops.entidad.Departamento;
import ec.gob.iess.proyecto.devsecops.servicio.DepartamentoServicio;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

	@Autowired
	private DepartamentoServicio departamentoServicio;

	@PostMapping
	public Departamento insertar(@RequestBody DepartamentoTO departamento) {
		return this.departamentoServicio.insertarActualizar(departamento);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DepartamentoTO> buscarTodos() {
		return this.departamentoServicio.buscarActivos();
	}
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Departamento> buscarPorId(@PathVariable Integer id) {
		return this.departamentoServicio.buscarPorId(id);
	}
	

	@PutMapping
	public Departamento actualizar(@RequestBody DepartamentoTO departamento) {
		return this.departamentoServicio.insertarActualizar(departamento);
	}
	
}
