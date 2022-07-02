package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Habilidad;

public interface IHabilidadService {

	public void insert(Habilidad habilidad);

	public List<Habilidad> list();

	public void delete(int idHab);

	Optional<Habilidad> listId(int idHab);

	public void update(Habilidad habilidad);
}
