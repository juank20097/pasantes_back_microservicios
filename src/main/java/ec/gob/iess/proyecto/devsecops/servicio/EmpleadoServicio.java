package ec.gob.iess.proyecto.devsecops.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.iess.proyecto.devsecops.entidad.Empleado;
import ec.gob.iess.proyecto.devsecops.repositorio.IEmpleadoRepositorio;

@Service
public class EmpleadoServicio {

	@Autowired
	private IEmpleadoRepositorio iEmpleadoRepositorio;
	
	public Empleado insertarActualizar(Empleado empleado) {
		return this.iEmpleadoRepositorio.save(empleado);
	}
	
	public List<Empleado> buscarTodosActivos(){
		return this.iEmpleadoRepositorio.findByStatus();
	}
	
	public Empleado buscarPorId(Integer id) {
		return this.iEmpleadoRepositorio.findById(id).orElse(null);
	}
	
}
