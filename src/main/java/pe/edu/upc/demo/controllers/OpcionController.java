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

import pe.edu.upc.demo.entities.Opcion;
import pe.edu.upc.demo.entities.Pregunta;
import pe.edu.upc.demo.serviceinterface.IOpcionService;
import pe.edu.upc.demo.serviceinterface.IPreguntaService;

@Controller
@RequestMapping("/opcion")
public class OpcionController {

	@Autowired
	private IOpcionService opciService;
	
	@Autowired
	private IPreguntaService pregService;
	
	@GetMapping("/nuevo")
	public String newOpcion(Model model) {

		model.addAttribute("o", new Opcion());
		model.addAttribute("p", new Pregunta());
		
		model.addAttribute("listaPreguntas", pregService.list());
		
		return "opcion/frmRegister";
	}
	
	@PostMapping("/guardar")
	public String saveOpcion(@Valid Opcion op, BindingResult binRes, Model model) {

		if (binRes.hasErrors()) {

			model.addAttribute("error", "Ocurrió un error!");
			return "opcion/frmRegister";

		} else {

			opciService.insert(op);
			model.addAttribute("mensaje", "Se guardó correctamente!");
			
			//return "redirect:/departamento/nuevo";
			return "redirect:/opcion/listar";
		}
	}
	
	@GetMapping("/listar")
	public String listOpcion(Model model) {

		try {

			model.addAttribute("listaOpciones", opciService.list());

		} catch (Exception e) {

			model.addAttribute("error", e.getMessage());

		}

		return "opcion/frmList";
	}
	
	@RequestMapping("/eliminar")
	public String deleteOpcion(Map<String, Object> model, @RequestParam(value = "id") Integer id) {

		try {
			if (id != null && id > 0) {

				opciService.delete(id);
				model.put("listaOpciones", opciService.list());

			}

		} catch (Exception e) {

			model.put("error", e.getMessage());
			//revisar
			//model.put("listaProvincias", provService.list());
		}

		return "redirect:/opcion/listar";
	}
	
	@RequestMapping("irmodificar/{id}")
	public String goUpdateOpcion(@PathVariable int id, Model model) {

		Optional<Opcion> objOpci= opciService.listId(id);

		model.addAttribute("listaPreguntas", pregService.list());
		model.addAttribute("osa", objOpci.get());

		return "opcion/frmUpdate";
	}
	
	@PostMapping("/modificar")
	public String updateOpcion(Opcion opci) {

		opciService.update(opci);
		
		// el redirect:/ es para llamar a funciones dentro del Controller
		return "redirect:/opcion/listar";

	}
}
