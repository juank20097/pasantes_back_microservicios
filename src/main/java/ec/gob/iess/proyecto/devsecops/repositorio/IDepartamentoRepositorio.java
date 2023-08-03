package ec.gob.iess.proyecto.devsecops.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.gob.iess.proyecto.devsecops.entidad.Departamento;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface IDepartamentoRepositorio extends JpaRepository<Departamento, Integer>{

	@Query("select d from Departamento d where d.estado = true")
	List<Departamento> findByStatus();

	@Query("Select d from Departamento d where d.empresa.idEmpr = :id")
	List<Departamento> findByEmpresaId(@Param("id") Integer id);
}
