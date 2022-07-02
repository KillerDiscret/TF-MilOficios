package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Empresa;
import pe.edu.upc.demo.repositories.IEmpresaRepository;
import pe.edu.upc.demo.serviceinterface.IEmpresaService;

@Service
public class EmpresaServiceImpl implements IEmpresaService{

	@Autowired
	private IEmpresaRepository empresaRepository;
	
	@Override
	public void insert(Empresa empr) {
		empresaRepository.save(empr);
		
	}

	@Override
	public List<Empresa> list() {
		// TODO Auto-generated method stub
		return empresaRepository.findAll();
	}

	@Override
	public void delete(int idEmpr) {
		// TODO Auto-generated method stub
		empresaRepository.deleteById(idEmpr);
	}
	
	@Override
	public Optional<Empresa> listId(int idEmpr) {
		// TODO Auto-generated method stub
		return empresaRepository.findById(idEmpr);
	}

	@Override
	public void update(Empresa empr) {
		// TODO Auto-generated method stub
		empresaRepository.save(empr);
	}

}
