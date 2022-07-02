package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Opcion;

public interface IOpcionService {

	public void insert(Opcion opci);
	
	public List<Opcion> list();
	
	public void delete (int idOpci);
	
	Optional<Opcion> listId(int idOpci);
	
	public void update(Opcion opci);
	
	
}
