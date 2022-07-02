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


import pe.edu.upc.demo.entities.Pregunta;
import pe.edu.upc.demo.serviceinterface.IPreguntaService;

@Controller
@RequestMapping("/pregunta")
public class PreguntaController {

	@Autowired
	private IPreguntaService pregService;

	@GetMapping("/nuevo")
	public String newPregunta(Model model) {

		model.addAttribute("p", new Pregunta());

		return "pregunta/frmRegister";
	}

	@PostMapping("/guardar")
	public String savePregunta(@Valid Pregunta pr, BindingResult binRes, Model model) {

		if (binRes.hasErrors()) {

			model.addAttribute("error", "Ocurrió un error!");
			return "pregunta/frmRegister";

		} else {

			pregService.insert(pr);
			model.addAttribute("mensaje", "Se guardó correctamente!");
			return "redirect:/pregunta/listar";
		}
	}

	@GetMapping("/listar")
	public String listPregunta(Model model) {

		try {

			model.addAttribute("listaPreguntas", pregService.list());

		} catch (Exception e) {

			model.addAttribute("error", e.getMessage());

		}

		return "pregunta/frmList";
	}

	@RequestMapping("/eliminar")
	public String deletePregunta(Map<String, Object> model, @RequestParam(value = "id") Integer id) {

		try {
			if (id != null && id > 0) {

				pregService.delete(id);
				model.put("listaPreguntas", pregService.list());

			}

		} catch (Exception e) {

			model.put("error", e.getMessage());
		}

		return "redirect:/pregunta/listar";
	}

	@RequestMapping("irmodificar/{id}")
	public String goUpdatePregunta(@PathVariable int id, Model model) {

		Optional<Pregunta> objPreg = pregService.listId(id);

		model.addAttribute("psa", objPreg.get());

		return "pregunta/frmUpdate";
	}
	
	@PostMapping("/modificar")
	public String updatePregunta(Pregunta pe) {

		pregService.update(pe);
		
		// el redirect:/ es para llamar a funciones dentro del Controller
		return "redirect:/pregunta/listar";

	}
}
