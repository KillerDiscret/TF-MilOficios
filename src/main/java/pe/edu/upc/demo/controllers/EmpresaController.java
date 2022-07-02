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

import pe.edu.upc.demo.entities.Empresa;
import pe.edu.upc.demo.serviceinterface.IEmpresaService;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {

	@Autowired
	private IEmpresaService emprService;
	
	@GetMapping("/nuevo")
	public String newEmpresa(Model model) {

		model.addAttribute("e", new Empresa());

		return "empresa/frmRegister";
	}
	
	
	@PostMapping("/guardar")
	public String saveEmpresa(@Valid Empresa em, BindingResult binRes, Model model) {

		if (binRes.hasErrors()) {

			model.addAttribute("error", "Ocurrió un error!");
			return "empresa/frmRegister";

		} else {

			emprService.insert(em);
			model.addAttribute("mensaje", "Se guardó correctamente!");
			return "redirect:/empresa/listar";
		}
	}	
	
	
	@GetMapping("/listar")
	public String listEmpresa(Model model) {

		try {

			model.addAttribute("listaEmpresas", emprService.list());

		} catch (Exception e) {

			model.addAttribute("error", e.getMessage());

		}

		return "empresa/frmList";
	}

	@RequestMapping("/eliminar")
	public String deleteEmpresa(Map<String, Object> model, @RequestParam(value = "id") Integer id) {

		try {
			if (id != null && id > 0) {

				emprService.delete(id);
				model.put("listaEmpresas", emprService.list());

			}

		} catch (Exception e) {

			model.put("error", e.getMessage());
		}

		return "redirect:/empresa/listar";
	}
	
	@RequestMapping("irmodificar/{id}")
	public String goUpdateEmpresa(@PathVariable int id, Model model) {

		Optional<Empresa> objEmpr = emprService.listId(id);

		model.addAttribute("esa", objEmpr.get());

		return "empresa/frmUpdate";
	}
	
	@PostMapping("/modificar")
	public String updateEmpresa(Empresa em) {

		emprService.update(em);
		
		// el redirect:/ es para llamar a funciones dentro del Controller
		return "redirect:/empresa/listar";

	}
	
}
