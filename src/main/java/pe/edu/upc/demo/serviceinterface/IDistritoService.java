package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Distrito;

public interface IDistritoService {

	public void insert(Distrito distrito);

	public List<Distrito> list();

	public void delete(int idDis);

	Optional<Distrito> listId(int idDis);

	public void update(Distrito distrito);
	
	
}
