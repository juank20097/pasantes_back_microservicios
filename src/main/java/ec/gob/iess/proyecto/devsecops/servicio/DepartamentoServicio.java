package ec.gob.iess.proyecto.devsecops.servicio;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.iess.proyecto.devsecops.dto.DepartamentoTO;
import ec.gob.iess.proyecto.devsecops.entidad.Departamento;
import ec.gob.iess.proyecto.devsecops.entidad.Empresa;
import ec.gob.iess.proyecto.devsecops.repositorio.IDepartamentoRepositorio;
import ec.gob.iess.proyecto.devsecops.repositorio.IEmpresaRepositorio;

@Service
public class DepartamentoServicio {

	@Autowired
	private IDepartamentoRepositorio iDepartamentoRepositorio;
	
	@Autowired
	private IEmpresaRepositorio iEmpresaRepositorio;

	public Departamento insertarActualizar(DepartamentoTO departamentoTO) {
		Departamento departamento = null;
		Empresa empresa = this.iEmpresaRepositorio.findById(departamentoTO.getIdEmpr()).orElse(null);
		Optional<Departamento> departamentoExistente = this.iDepartamentoRepositorio.findById(departamentoTO.getIdDepa());
		if(departamentoExistente.isPresent()) {
			departamento = departamentoExistente.get();
			departamento.setCreadoPor(departamentoTO.getCreadoPor());
			departamento.setDescripcion(departamentoTO.getDescripcion());
			departamento.setEmpresa(empresa);
			departamento.setEstado(departamentoTO.getEstado());
			departamento.setFechaCreado(departamentoTO.getFechaCreado());
			departamento.setFechaModificado(departamentoTO.getFechaModificado());
			departamento.setModificadoPor(departamentoTO.getModificadoPor());
			departamento.setNombre(departamentoTO.getNombre());
			departamento.setTelefono(departamentoTO.getTelefono());
		} else {
			departamento = new Departamento();
			departamento.setCreadoPor(departamentoTO.getCreadoPor());
			departamento.setDescripcion(departamentoTO.getDescripcion());
			departamento.setEmpresa(empresa);
			departamento.setEstado(departamentoTO.getEstado());
			departamento.setFechaCreado(departamentoTO.getFechaCreado());
			departamento.setFechaModificado(departamentoTO.getFechaModificado());
			departamento.setModificadoPor(departamentoTO.getModificadoPor());
			departamento.setNombre(departamentoTO.getNombre());
			departamento.setTelefono(departamentoTO.getTelefono());
		}
		return this.iDepartamentoRepositorio.save(departamento);
	}

	public List<Departamento> buscarTodosActivos() {
		return this.iDepartamentoRepositorio.findByStatus();
	}

	public List<DepartamentoTO> buscarDepartamentos(Integer id) {
		List<Departamento> departamentosTodos = this.iDepartamentoRepositorio.findByEmpresaId(id);
		List<DepartamentoTO> departamentos = departamentosTodos.stream().map(e -> this.convertir(e))
				.collect(Collectors.toList());
		return departamentos;
	}
	
	public Optional<Departamento> buscarPorId(Integer id) {
		return this.iDepartamentoRepositorio.findById(id);
	}
	
	public List<DepartamentoTO> buscarActivos() {
		List<Departamento> departamentosTodos = this.iDepartamentoRepositorio.findByStatus();
		List<DepartamentoTO> departamentos = departamentosTodos.stream().map(e -> this.convertir(e))
				.collect(Collectors.toList());
		return departamentos;
	}
	
	
	private DepartamentoTO convertir(Departamento departamento) {
		DepartamentoTO d = new DepartamentoTO();
		d.setCreadoPor(departamento.getCreadoPor());
		d.setDescripcion(departamento.getDescripcion());
		d.setEstado(departamento.getEstado());
		d.setFechaCreado(departamento.getFechaCreado());
		d.setFechaModificado(departamento.getFechaModificado());
		d.setModificadoPor(departamento.getModificadoPor());
		d.setIdDepa(departamento.getIdDepa());
		d.setNombre(departamento.getNombre());
		d.setTelefono(departamento.getTelefono());
		d.setIdEmpr(departamento.getEmpresa().getIdEmpr());
		return d;
	}

}
