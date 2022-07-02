package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Provincia;

public interface IProvinciaService {

	public void insert(Provincia prov);

	public List<Provincia> list();

	public void delete(int idProv);

	Optional<Provincia> listId(int idProv);

	public void update(Provincia prov);

}
