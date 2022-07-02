package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Curriculum;
import pe.edu.upc.demo.repositories.ICurriculumRepository;
import pe.edu.upc.demo.serviceinterface.ICurriculumService;

@Service
public class CurriculumServiceImpl implements ICurriculumService{

	
	@Autowired
	private ICurriculumRepository curriculumRepository;
	
	@Override
	public void insert(Curriculum curr) {
		// TODO Auto-generated method stub
		curriculumRepository.save(curr);
	}

	@Override
	public List<Curriculum> list() {
		// TODO Auto-generated method stub
		return curriculumRepository.findAll();
	}

	@Override
	public void delete(int idCurr) {
		// TODO Auto-generated method stub
		curriculumRepository.deleteById(idCurr);
	}

	@Override
	public Optional<Curriculum> listId(int idCurr) {
		// TODO Auto-generated method stub
		return curriculumRepository.findById(idCurr);
	}

	@Override
	public void update(Curriculum curr) {
		// TODO Auto-generated method stub
		curriculumRepository.save(curr);
	}

	
}
