package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Convocatoria;
import pe.edu.upc.demo.repositories.IConvocatoriaRepository;
import pe.edu.upc.demo.serviceinterface.IConvocatoriaService;

@Service
public class ConvocatoriaServiceImpl implements IConvocatoriaService {

	
	@Autowired
	private IConvocatoriaRepository convocatoriaRepository;
	
	
	@Override
	public void insert(Convocatoria con) {
		
		convocatoriaRepository.save(con);
	}

	@Override
	public List<Convocatoria> list() {
		
		return convocatoriaRepository.findAll();
	}

	@Override
	public void delete(int idCon) {
		
		convocatoriaRepository.deleteById(idCon);
	}

	@Override
	public Optional<Convocatoria> listId(int idCon) {

		return convocatoriaRepository.findById(idCon);
	}

	@Override
	public void update(Convocatoria con) {
		
		convocatoriaRepository.save(con);
	}
	
	@Override
	public List<String[]> reporteConvExtensa() {
		// TODO Auto-generated method stub
		return convocatoriaRepository.reporteConvExtensa();
	}

	@Override
	public List<String[]> reporteAngello() {
		// TODO Auto-generated method stub
		return convocatoriaRepository.reporteAngello();
	}

}
