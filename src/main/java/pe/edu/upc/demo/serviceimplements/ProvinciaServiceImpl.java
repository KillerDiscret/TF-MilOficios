package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Provincia;
import pe.edu.upc.demo.repositories.IProvinciaRepository;
import pe.edu.upc.demo.serviceinterface.IProvinciaService;

@Service
public class ProvinciaServiceImpl implements IProvinciaService{

	
	@Autowired
	private IProvinciaRepository provinciaRepository;
	
	
	
	@Override
	public void insert(Provincia prov) {
	
		provinciaRepository.save(prov);
	}

	@Override
	public List<Provincia> list() {
		
		return provinciaRepository.findAll();
	}

	@Override
	public void delete(int idProv) {
		
		provinciaRepository.deleteById(idProv);
	}

	@Override
	public Optional<Provincia> listId(int idProv) {
		
		
		return provinciaRepository.findById(idProv);
	}

	@Override
	public void update(Provincia prov) {
		
		provinciaRepository.save(prov);
	}

}
