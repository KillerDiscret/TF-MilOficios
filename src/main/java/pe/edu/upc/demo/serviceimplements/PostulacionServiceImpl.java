package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Postulacion;
import pe.edu.upc.demo.repositories.IPostulacionRepository;
import pe.edu.upc.demo.serviceinterface.IPostulacionService;

@Service
public class PostulacionServiceImpl implements IPostulacionService {

	@Autowired
	private IPostulacionRepository postulacionRepository;
	
	@Override
	public void insert(Postulacion postulacion) {
		// TODO Auto-generated method stub
		postulacionRepository.save(postulacion);
	}

	@Override
	public List<Postulacion> list() {
		// TODO Auto-generated method stub
		return postulacionRepository.findAll();
	}

	@Override
	public void delete(int idPos) {
		// TODO Auto-generated method stub
		postulacionRepository.deleteById(idPos);
	}

	@Override
	public Optional<Postulacion> listId(int idPos) {
		// TODO Auto-generated method stub
		return postulacionRepository.findById(idPos);
	}

	@Override
	public void update(Postulacion postulacion) {
		// TODO Auto-generated method stub
		postulacionRepository.save(postulacion);
	}

}
