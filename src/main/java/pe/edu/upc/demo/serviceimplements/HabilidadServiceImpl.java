package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Habilidad;
import pe.edu.upc.demo.repositories.IHabilidadRepository;
import pe.edu.upc.demo.serviceinterface.IHabilidadService;

@Service
public class HabilidadServiceImpl implements IHabilidadService{

	@Autowired
	private IHabilidadRepository habilidadRepository;
	
	@Override
	public void insert(Habilidad habilidad) {
		// TODO Auto-generated method stub
		habilidadRepository.save(habilidad);
	}

	@Override
	public List<Habilidad> list() {
		// TODO Auto-generated method stub
		return habilidadRepository.findAll();
	}

	@Override
	public void delete(int idHab) {
		// TODO Auto-generated method stub
		habilidadRepository.deleteById(idHab);
	}

	@Override
	public Optional<Habilidad> listId(int idHab) {
		// TODO Auto-generated method stub
		return habilidadRepository.findById(idHab);
	}

	@Override
	public void update(Habilidad habilidad) {
		// TODO Auto-generated method stub
		habilidadRepository.save(habilidad);
	}

}
