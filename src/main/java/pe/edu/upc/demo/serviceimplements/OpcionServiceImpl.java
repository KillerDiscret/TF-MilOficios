package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Opcion;
import pe.edu.upc.demo.repositories.IOpcionRepository;
import pe.edu.upc.demo.serviceinterface.IOpcionService;

@Service
public class OpcionServiceImpl implements IOpcionService{

	@Autowired
	private IOpcionRepository opcionRepository;
	
	@Override
	public void insert(Opcion opci) {
		// TODO Auto-generated method stub
		opcionRepository.save(opci);
	}

	@Override
	public List<Opcion> list() {
		// TODO Auto-generated method stub
		return opcionRepository.findAll();
	}

	@Override
	public void delete(int idOpci) {
		// TODO Auto-generated method stub
		opcionRepository.deleteById(idOpci);
	}

	@Override
	public Optional<Opcion> listId(int idOpci) {
		// TODO Auto-generated method stub
		return opcionRepository.findById(idOpci);
	}

	@Override
	public void update(Opcion opci) {
		// TODO Auto-generated method stub
		opcionRepository.save(opci);
	}

}
