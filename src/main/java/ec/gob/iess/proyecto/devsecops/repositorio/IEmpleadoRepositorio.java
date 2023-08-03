package ec.gob.iess.proyecto.devsecops.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.gob.iess.proyecto.devsecops.entidad.Empleado;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface IEmpleadoRepositorio extends JpaRepository<Empleado, Integer>{

	@Query("select e from Empleado e where e.estado = true")
	List<Empleado> findByStatus();
	
	@Query("select e from Empleado e where e.idEmpl = :id")
	Optional<Empleado>  findById(@Param("id") Integer id);
}
