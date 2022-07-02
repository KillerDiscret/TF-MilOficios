package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Empleado;
import pe.edu.upc.demo.repositories.IEmpleadoRepository;
import pe.edu.upc.demo.serviceinterface.IEmpleadoService;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

	
	@Autowired
	private IEmpleadoRepository empleadoRepository;
	
	
	@Override
	public void insert(Empleado emp) {
		
		empleadoRepository.save(emp);
	}

	@Override
	public List<Empleado> list() {
		
		return empleadoRepository.findAll();
	}

	@Override
	public void delete(int idEmp) {
		
		empleadoRepository.deleteById(idEmp);
	}

	@Override
	public Optional<Empleado> listId(int idEmp) {

		return empleadoRepository.findById(idEmp);
	}

	@Override
	public void update(Empleado emp) {
		
		empleadoRepository.save(emp);
	}


}
