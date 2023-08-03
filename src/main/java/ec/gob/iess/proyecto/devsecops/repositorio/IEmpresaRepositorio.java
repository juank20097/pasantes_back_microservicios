package ec.gob.iess.proyecto.devsecops.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ec.gob.iess.proyecto.devsecops.entidad.Empresa;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface IEmpresaRepositorio extends JpaRepository<Empresa, Integer>{

	@Query("select em from Empresa em where em.estado = true")
	public List<Empresa> findByStatus();
	
}
