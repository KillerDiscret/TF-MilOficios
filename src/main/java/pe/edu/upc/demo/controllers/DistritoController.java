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

import pe.edu.upc.demo.entities.Distrito;
import pe.edu.upc.demo.entities.Provincia;
import pe.edu.upc.demo.serviceinterface.IDistritoService;
import pe.edu.upc.demo.serviceinterface.IProvinciaService;

@Controller
@RequestMapping("/distrito")
public class DistritoController {

	@Autowired
	private IProvinciaService proService;
	
	@Autowired
	private IDistritoService disService;
	
	
	@GetMapping("/nuevo")
	public String newDistrito(Model model) {
	
		model.addAttribute("p", new Provincia());
		
		model.addAttribute("d", new Distrito());
		
		model.addAttribute("listaProvincias", proService.list());
		
		return "distrito/frmRegister";
	}
	
	@PostMapping("/guardar")
	public String saveDistrito(@Valid Distrito dt, BindingResult binRes, Model model) {

		if (binRes.hasErrors()) {

			model.addAttribute("error", "Ocurrió un error!");
			return "distrito/frmRegister";

		} else {

			disService.insert(dt);
			model.addAttribute("mensaje", "Se guardó correctamente!");
			
			//return "redirect:/departamento/nuevo";
			return "redirect:/distrito/listar";
		}
	}
	
	@GetMapping("/listar")
	public String listDistrito(Model model) {

		try {

			model.addAttribute("listaDistritos", disService.list());

		} catch (Exception e) {

			model.addAttribute("error", e.getMessage());

		}

		return "distrito/frmList";
	}
	
	@RequestMapping("/eliminar")
	public String deleteDistrito(Map<String, Object> model, @RequestParam(value = "id") Integer id) {

		try {
			if (id != null && id > 0) {

				disService.delete(id);
				model.put("listaDistritos", disService.list());

			}

		} catch (Exception e) {

			model.put("error", e.getMessage());
			//revisar
			//model.put("listaProvincias", provService.list());
		}

		return "redirect:/distrito/listar";
	}
	
	@RequestMapping("irmodificar/{id}")
	public String goUpdateDistrito(@PathVariable int id, Model model) {

		Optional<Distrito> objDis = disService.listId(id);

		model.addAttribute("listaProvincias", proService.list());
		model.addAttribute("dsa", objDis.get());

		return "distrito/frmUpdate";
	}
	
	@PostMapping("/modificar")
	public String updateDistrito(Distrito dis) {

		disService.update(dis);
		
		// el redirect:/ es para llamar a funciones dentro del Controller
		return "redirect:/distrito/listar";

	}
	
	
	
	
	
}
