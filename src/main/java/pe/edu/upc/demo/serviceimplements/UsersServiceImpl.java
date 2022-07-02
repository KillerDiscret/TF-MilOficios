package pe.edu.upc.demo.serviceimplements;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Role;
import pe.edu.upc.demo.entities.Users;
import pe.edu.upc.demo.repositories.IRoleRepository;
import pe.edu.upc.demo.repositories.IUsersRepository;
import pe.edu.upc.demo.serviceinterface.IUsersService;

@Service
public class UsersServiceImpl implements IUsersService{

	@Autowired
	private IUsersRepository usersRepository;
	
	@Autowired
	private IRoleRepository roleRepository;
	
	
	@Override
	public void insert(Users users) {
		
		Users objUsers = users;
		
		Role rol = new Role();
		
		if(objUsers.getAuxrole().compareTo("ROLE_ADMIN")==0) {
			rol.setRol("ROLE_ADMIN");
		}
		
		if(objUsers.getAuxrole().compareTo("ROLE_EMPRESA")==0) {
			rol.setRol("ROLE_EMPRESA");
		}
		
		if(objUsers.getAuxrole().compareTo("ROLE_EMPLEADO")==0) {
			rol.setRol("ROLE_EMPLEADO");
		}
		
		rol = roleRepository.save(rol);
		
		objUsers.setRoles(new ArrayList<Role>());
		objUsers.getRoles().add(rol);
		objUsers = usersRepository.save(objUsers);
		
		
	}

	@Override
	public List<Users> list() {
		
		return usersRepository.findAll();
	}

	@Override
	public void delete(Long idUsers) {
		
		usersRepository.deleteById(idUsers);
		
	}

	@Override
	public Optional<Users> listId(Long idUsers) {
		
		return usersRepository.findById(idUsers);
	}

	@Override
	public void update(Users users) {
	
		usersRepository.save(users);
	}

	
	
	
	
	
}
