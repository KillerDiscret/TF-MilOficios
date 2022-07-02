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
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.demo.entities.Departamento;
import pe.edu.upc.demo.serviceinterface.IDepartamentoService;

@Controller
@RequestMapping("/departamento")
public class DepartamentoController {

	@Autowired
	private IDepartamentoService depaService;

	@GetMapping("/nuevo")
	public String newDepartamento(Model model) {

		model.addAttribute("d", new Departamento());

		return "departamento/frmRegister";
	}

	@PostMapping("/guardar")
	public String saveDepartamento(@Valid Departamento de, BindingResult binRes, Model model, SessionStatus status)
			throws Exception {

		if (binRes.hasErrors()) {

			model.addAttribute("error", "Ocurrió un error!");
			return "departamento/frmRegister";

		} else {

			depaService.insert(de);
			model.addAttribute("mensaje", "Se guardó correctamente!");

			return "redirect:/departamento/listar";
		}
	}

	@GetMapping("/listar")
	public String listDepartamento(Model model) {

		try {

			model.addAttribute("listaDepartamentos", depaService.list());

		} catch (Exception e) {

			model.addAttribute("error", e.getMessage());

		}

		return "departamento/frmList";
	}

	@RequestMapping("/eliminar")
	public String deleteDepartamento(Map<String, Object> model, @RequestParam(value = "id") Integer id) {

		try {
			if (id != null && id > 0) {

				depaService.delete(id);
				model.put("listaDepartamentos", depaService.list());

			}

		} catch (Exception e) {

			model.put("error", e.getMessage());
		}

		return "redirect:/departamento/listar";
	}

	@RequestMapping("irmodificar/{id}")
	public String goUpdateDepartamento(@PathVariable int id, Model model) {

		Optional<Departamento> objDepa = depaService.listId(id);

		model.addAttribute("dsa", objDepa.get());

		return "departamento/frmUpdate";
	}

	@PostMapping("/modificar")
	public String updateDepartamento(Departamento de) {

		depaService.update(de);

		// el redirect:/ es para llamar a funciones dentro del Controller
		return "redirect:/departamento/listar";

	}

}
