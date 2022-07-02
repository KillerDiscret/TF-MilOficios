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

import pe.edu.upc.demo.entities.Departamento;
import pe.edu.upc.demo.entities.Provincia;
import pe.edu.upc.demo.serviceinterface.IDepartamentoService;
import pe.edu.upc.demo.serviceinterface.IProvinciaService;

@Controller
@RequestMapping("/provincia")
public class ProvinciaController {

	
	@Autowired
	private IDepartamentoService depaService;
	
	@Autowired
	private IProvinciaService provService;
	
	
	@GetMapping("/nuevo")
	public String newProvincia(Model model) {

		model.addAttribute("d", new Departamento());
		model.addAttribute("p", new Provincia());
		
		model.addAttribute("listaDepartamentos", depaService.list());
		
		return "provincia/frmRegister";
	}
	
	@PostMapping("/guardar")
	public String saveProvincia(@Valid Provincia pr, BindingResult binRes, Model model) {

		if (binRes.hasErrors()) {

			model.addAttribute("error", "Ocurrió un error!");
			return "provincia/frmRegister";

		} else {

			provService.insert(pr);
			model.addAttribute("mensaje", "Se guardó correctamente!");
			
			//return "redirect:/departamento/nuevo";
			return "redirect:/provincia/listar";
		}
	}
	
	@GetMapping("/listar")
	public String listProvincia(Model model) {

		try {

			model.addAttribute("listaProvincias", provService.list());

		} catch (Exception e) {

			model.addAttribute("error", e.getMessage());

		}

		return "provincia/frmList";
	}
	
	@RequestMapping("/eliminar")
	public String deleteProvincia(Map<String, Object> model, @RequestParam(value = "id") Integer id) {

		try {
			if (id != null && id > 0) {

				provService.delete(id);
				model.put("listaProvincias", provService.list());

			}

		} catch (Exception e) {

			model.put("error", e.getMessage());
			//revisar
			//model.put("listaProvincias", provService.list());
		}

		return "redirect:/provincia/listar";
	}
	
	@RequestMapping("irmodificar/{id}")
	public String goUpdateProvincia(@PathVariable int id, Model model) {

		Optional<Provincia> objProv = provService.listId(id);

		model.addAttribute("listaDepartamentos", depaService.list());
		model.addAttribute("psa", objProv.get());

		return "provincia/frmUpdate";
	}
	
	@PostMapping("/modificar")
	public String updateProvincia(Provincia prov) {

		provService.update(prov);
		
		// el redirect:/ es para llamar a funciones dentro del Controller
		return "redirect:/provincia/listar";

	}
	
	
	
	
}
