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
import pe.edu.upc.demo.entities.Habilidad;
import pe.edu.upc.demo.serviceinterface.ICurriculumService;
import pe.edu.upc.demo.serviceinterface.IHabilidadService;

@Controller
@RequestMapping("/habilidad")
public class HabilidadController {
	
	@Autowired
	private ICurriculumService curService;
	
	@Autowired
	private IHabilidadService habService;
	
	
	@GetMapping("/nuevo")
	public String newHabilidad(Model model) {
	
		model.addAttribute("c", new Curriculum());
		
		model.addAttribute("h", new Habilidad());
		
		model.addAttribute("listaCurriculums", curService.list());
		
		return "habilidad/frmRegister";
	}
	
	@PostMapping("/guardar")
	public String saveHabilidad(@Valid Habilidad hb, BindingResult binRes, Model model) {

		if (binRes.hasErrors()) {

			model.addAttribute("error", "Ocurrió un error!");
			return "habilidad/frmRegister";

		} else {

			habService.insert(hb);
			model.addAttribute("mensaje", "Se guardó correctamente!");
			
			//return "redirect:/departamento/nuevo";
			return "redirect:/habilidad/listar";
		}
	}
	
	@GetMapping("/listar")
	public String listHabilidad(Model model) {

		try {

			model.addAttribute("listaHabilidades", habService.list());

		} catch (Exception e) {

			model.addAttribute("error", e.getMessage());

		}

		return "habilidad/frmList";
	}
	
	@RequestMapping("/eliminar")
	public String deleteHabilidad(Map<String, Object> model, @RequestParam(value = "id") Integer id) {

		try {
			if (id != null && id > 0) {

				habService.delete(id);
				model.put("listaHabilidades", habService.list());

			}

		} catch (Exception e) {

			model.put("error", e.getMessage());
			//revisar
			//model.put("listaProvincias", provService.list());
		}

		return "redirect:/habilidad/listar";
	}
	
	@RequestMapping("irmodificar/{id}")
	public String goUpdateHabilidad(@PathVariable int id, Model model) {

		Optional<Habilidad> objHab = habService.listId(id);

		model.addAttribute("listaCurriculums", curService.list());
		model.addAttribute("hsa", objHab.get());

		return "habilidad/frmUpdate";
	}
	
	@PostMapping("/modificar")
	public String updateHabilidad(Habilidad hab) {

		habService.update(hab);
		
		// el redirect:/ es para llamar a funciones dentro del Controller
		return "redirect:/habilidad/listar";

	}

}
