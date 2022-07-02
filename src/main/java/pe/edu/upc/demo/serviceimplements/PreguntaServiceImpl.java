package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Pregunta;
import pe.edu.upc.demo.repositories.IPreguntaRepository;
import pe.edu.upc.demo.serviceinterface.IPreguntaService;

@Service
public class PreguntaServiceImpl implements IPreguntaService {

	@Autowired
	private IPreguntaRepository preguntaRepository;
	
	@Override
	public void insert(Pregunta preg) {
		// TODO Auto-generated method stub
		preguntaRepository.save(preg);
	}

	@Override
	public List<Pregunta> list() {
		
		return preguntaRepository.findAll();
	}

	@Override
	public void delete(int idPreg) {
		
		preguntaRepository.deleteById(idPreg);
		
	}

	@Override
	public Optional<Pregunta> listId(int idPreg) {
		
		return preguntaRepository.findById(idPreg);
	}

	@Override
	public void update(Pregunta preg) {
		// TODO Auto-generated method stub
		preguntaRepository.save(preg);
	}

	
}
