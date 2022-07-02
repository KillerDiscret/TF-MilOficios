package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Pregunta;

public interface IPreguntaService {

	public void insert(Pregunta preg);

	public List<Pregunta> list();

	public void delete(int idPreg);

	Optional<Pregunta> listId(int idPreg);

	public void update(Pregunta preg);

}
