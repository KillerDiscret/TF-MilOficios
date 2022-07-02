package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Departamento;
import pe.edu.upc.demo.repositories.IDepartamentoRepository;
import pe.edu.upc.demo.serviceinterface.IDepartamentoService;

@Service
public class DepartamentoServiceImpl implements IDepartamentoService {

	@Autowired
	private IDepartamentoRepository departamentoRepository;
	
	
	@Override
	public void insert(Departamento depa) {
		
		departamentoRepository.save(depa);
	}

	@Override
	public List<Departamento> list() {
		
		return departamentoRepository.findAll();
	}

	@Override
	public void delete(int idDepa) {
		
		departamentoRepository.deleteById(idDepa);
	}

	@Override
	public Optional<Departamento> listId(int idDepa) {
		
		return departamentoRepository.findById(idDepa);
	}

	@Override
	public void update(Departamento depa) {
		
		departamentoRepository.save(depa);
		
	}

	
	
	
	
	
}
