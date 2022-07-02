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

import pe.edu.upc.demo.entities.Curriculum;
import pe.edu.upc.demo.entities.Empleado;
import pe.edu.upc.demo.serviceinterface.ICurriculumService;
import pe.edu.upc.demo.serviceinterface.IEmpleadoService;

@Controller
@RequestMapping("/curriculum")
public class CurriculumController {

	@Autowired
	private ICurriculumService currService;
	
	@Autowired 
	private IEmpleadoService emplService;
	
	@GetMapping("/nuevo")
	public String newOpcion(Model model) {

		model.addAttribute("c", new Curriculum());
		model.addAttribute("e", new Empleado());
		
		model.addAttribute("listaEmpleados", emplService.list());
		
		return "curriculum/frmRegister";
	}
	
	@PostMapping("/guardar")
	public String saveOpcion(@Valid Curriculum cu, BindingResult binRes, Model model) {

		if (binRes.hasErrors()) {

			model.addAttribute("error", "Ocurrió un error!");
			return "curriculum/frmRegister";

		} else {

			currService.insert(cu);
			model.addAttribute("mensaje", "Se guardó correctamente!");
			
			//return "redirect:/departamento/nuevo";
			return "redirect:/curriculum/listar";
		}
	}
	
	@GetMapping("/listar")
	public String listOpcion(Model model) {

		try {

			model.addAttribute("listaCurriculums", currService.list());

		} catch (Exception e) {

			model.addAttribute("error", e.getMessage());

		}

		return "curriculum/frmList";
	}
	
	@RequestMapping("/eliminar")
	public String deleteCurriculum(Map<String, Object> model, @RequestParam(value = "id") Integer id) {

		try {
			if (id != null && id > 0) {

				currService.delete(id);
				model.put("listaCurriculums", currService.list());

			}

		} catch (Exception e) {

			model.put("error", e.getMessage());
			//revisar
			//model.put("listaProvincias", provService.list());
		}

		return "redirect:/curriculum/listar";
	}
	
	@RequestMapping("irmodificar/{id}")
	public String goUpdateCurriculum(@PathVariable int id, Model model) {

		Optional<Curriculum> objCurr= currService.listId(id);

		model.addAttribute("listaEmpleados", emplService.list());
		model.addAttribute("csa", objCurr.get());

		return "curriculum/frmUpdate";
	}
	
	@PostMapping("/modificar")
	public String updateCurriculum(Curriculum curri) {

		currService.update(curri);
		
		// el redirect:/ es para llamar a funciones dentro del Controller
		return "redirect:/curriculum/listar";

	}
}
