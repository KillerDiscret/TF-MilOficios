package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Curriculum;

public interface ICurriculumService {

	public void insert(Curriculum curr);

	public List<Curriculum> list();

	public void delete(int idCurr);

	Optional<Curriculum> listId(int idCurr);

	public void update(Curriculum curr);
}
