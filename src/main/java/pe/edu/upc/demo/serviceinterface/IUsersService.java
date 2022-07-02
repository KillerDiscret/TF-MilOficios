package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Users;

public interface IUsersService {

	public void insert(Users users);
	
	public List<Users> list();
	
	public void delete(Long idUsers);
	
	Optional<Users> listId(Long idUsers);
	
	public void update(Users users);
	
}
