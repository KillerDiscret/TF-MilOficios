package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Departamento;

public interface IDepartamentoService {

	public void insert(Departamento depa);
	
	public List<Departamento> list();
	
	public void delete(int idDepa);
	
	Optional<Departamento> listId(int idDepa);
	
	public void update(Departamento depa);
	
	
}
