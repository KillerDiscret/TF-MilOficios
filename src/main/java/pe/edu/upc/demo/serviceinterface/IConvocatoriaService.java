package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Convocatoria;

public interface IConvocatoriaService {

	public void insert(Convocatoria con);

	public List<Convocatoria> list();

	public void delete(int idCon);

	Optional<Convocatoria> listId(int idCon);

	public void update(Convocatoria con);
	
	List<String[]> reporteConvExtensa();

	List<String[]> reporteAngello(); 
}
