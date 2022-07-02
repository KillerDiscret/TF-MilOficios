package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Role;

public interface IRoleService {

	public void insert(Role role);

	public List<Role> list();
	
	public void delete(Long idRole);
	
	Optional<Role> listId(Long idRole);
	
	public void update(Role role);

}
