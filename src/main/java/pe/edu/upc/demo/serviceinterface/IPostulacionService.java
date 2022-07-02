package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Postulacion;

public interface IPostulacionService {
	
	public void insert(Postulacion postulacion);

	public List<Postulacion> list();

	public void delete(int idPos);

	Optional<Postulacion> listId(int idPos);

	public void update(Postulacion postulacion);
}
