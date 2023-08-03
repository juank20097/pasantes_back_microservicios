package ec.gob.iess.proyecto.devsecops.servicio;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.iess.proyecto.devsecops.dto.EmpresaTO;
import ec.gob.iess.proyecto.devsecops.entidad.Empresa;
import ec.gob.iess.proyecto.devsecops.repositorio.IEmpresaRepositorio;

@Service
public class EmpresaServicio {

	@Autowired
	private IEmpresaRepositorio iEmpresaRepositorio;

	public Empresa insertarActualizar(Empresa empresa) {
		return this.iEmpresaRepositorio.save(empresa);
	}

	public List<Empresa> buscarTodosActivos() {
		return this.iEmpresaRepositorio.findByStatus();
	}

	public Empresa buscarPorId(Integer id) {
		return this.iEmpresaRepositorio.findById(id).orElse(null);
	}
	
	public List<EmpresaTO> buscarEmpresas() {
		List<Empresa> empresaTodos = this.iEmpresaRepositorio.findByStatus();
		List<EmpresaTO> empresas = empresaTodos.stream().map(e -> this.convertir(e))
				.collect(Collectors.toList());
		return empresas;
	}

	private EmpresaTO convertir(Empresa empresa) {
		EmpresaTO e = new EmpresaTO();
		e.setCreadoPor(empresa.getCreadoPor());
		e.setEstado(empresa.getEstado());
		e.setFechaCreado(empresa.getFechaCreado());
		e.setFechaModificado(empresa.getFechaModificado());
		e.setModificadoPor(empresa.getModificadoPor());
		e.setIdEmpr(empresa.getIdEmpr());
		e.setNombre(empresa.getNombre());
		e.setTelefono(empresa.getTelefono());
		e.setDireccion(empresa.getDireccion());
		return e;
	}
}
