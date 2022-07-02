package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Empresa;

public interface IEmpresaService {

	public void insert(Empresa empr);
	
	public List<Empresa> list();
	
	public void delete(int idEmpr);
	
	Optional<Empresa> listId(int idEmpr);
	
	public void update(Empresa empr);
	
	
}
