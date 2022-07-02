package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Empleado;

public interface IEmpleadoService {

	public void insert(Empleado emp);

	public List<Empleado> list();

	public void delete(int idCon);

	Optional<Empleado> listId(int idEmp);

	public void update(Empleado emp);
	

}
