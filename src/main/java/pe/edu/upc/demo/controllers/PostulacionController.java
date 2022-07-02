package pe.edu.upc.demo.controllers;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.demo.entities.Convocatoria;
import pe.edu.upc.demo.entities.Empleado;
import pe.edu.upc.demo.entities.Postulacion;
import pe.edu.upc.demo.serviceinterface.IConvocatoriaService;
import pe.edu.upc.demo.serviceinterface.IEmpleadoService;
import pe.edu.upc.demo.serviceinterface.IPostulacionService;

@Controller
@RequestMapping("/postulacion")
public class PostulacionController {

	@Autowired
	private IPostulacionService posService;
	
	@Autowired
	private IEmpleadoService empService;
	
	@Autowired
	private IConvocatoriaService convService;
	
	
	@GetMapping("/nuevo")
	public String newPostulacion(Model model) {
	
		model.addAttribute("e", new Empleado());
		
		model.addAttribute("p", new Postulacion());
		
		model.addAttribute("c", new Convocatoria());
		
		model.addAttribute("listaEmpleados", empService.list());
		
		model.addAttribute("listaConvocatorias", convService.list());
		
		return "postulacion/frmRegister";
	}
	
	@PostMapping("/guardar")
	public String savePostulacion(@Valid Postulacion ps, BindingResult binRes, Model model) {

		if (binRes.hasErrors()) {

			model.addAttribute("error", "Ocurrió un error!");
			return "postulacion/frmRegister";

		} else {

			posService.insert(ps);
			model.addAttribute("mensaje", "Se guardó correctamente!");
			
			//return "redirect:/departamento/nuevo";
			return "redirect:/postulacion/listar";
		}
	}
	
	@GetMapping("/listar")
	public String listPostulacion(Model model) {

		try {

			model.addAttribute("listaPostulaciones", posService.list());

		} catch (Exception e) {

			model.addAttribute("error", e.getMessage());

		}

		return "postulacion/frmList";
	}
	
	@RequestMapping("/eliminar")
	public String deletePostulacion(Map<String, Object> model, @RequestParam(value = "id") Integer id) {

		try {
			if (id != null && id > 0) {

				posService.delete(id);
				model.put("listaPostulaciones", posService.list());

			}

		} catch (Exception e) {

			model.put("error", e.getMessage());
			//revisar
			//model.put("listaProvincias", provService.list());
		}

		return "redirect:/postulacion/listar";
	}
	
	@RequestMapping("irmodificar/{id}")
	public String goUpdatePostulacion(@PathVariable int id, Model model) {

		Optional<Postulacion> objPos = posService.listId(id);

		model.addAttribute("listaEmpleados", empService.list());
		model.addAttribute("listaConvocatorias", convService.list());

		model.addAttribute("psa", objPos.get());

		return "postulacion/frmUpdate";
	}
	
	@PostMapping("/modificar")
	public String updatePostulacion(Postulacion pos) {

		posService.update(pos);
		
		// el redirect:/ es para llamar a funciones dentro del Controller
		return "redirect:/postulacion/listar";

	}
	
	
}
