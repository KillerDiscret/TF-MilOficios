package pe.edu.upc.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.entities.Convocatoria;

@Repository
public interface IConvocatoriaRepository extends JpaRepository<Convocatoria, Integer> {

	@Query(value =  "select conv.nombre, conv.fechainicio, conv.fechafin, dias= datediff(day,fechainicio,fechafin) from conv group by conv.nombre, conv.fechainicio, conv.fechafin order by dias desc", nativeQuery=true)
    List<String[]> reporteConvExtensa();
	
	
}


