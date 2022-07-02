package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Role;
import pe.edu.upc.demo.repositories.IRoleRepository;
import pe.edu.upc.demo.serviceinterface.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private IRoleRepository roleRepository;

	@Override
	public void insert(Role role) {
		// TODO Auto-generated method stub
		roleRepository.save(role);
	}

	@Override
	public List<Role> list() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	@Override
	public void delete(Long idRole) {
		// TODO Auto-generated method stub
		roleRepository.deleteById(idRole);
	}

	@Override
	public Optional<Role> listId(Long idRole) {
		// TODO Auto-generated method stub
		return roleRepository.findById(idRole);
	}

	@Override
	public void update(Role role) {
		roleRepository.save(role);
		
	}
	
	
	
	

	
	
	
	
}
