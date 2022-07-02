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
import pe.edu.upc.demo.entities.Distrito;
import pe.edu.upc.demo.entities.Empresa;
import pe.edu.upc.demo.serviceinterface.IConvocatoriaService;
import pe.edu.upc.demo.serviceinterface.IDistritoService;
import pe.edu.upc.demo.serviceinterface.IEmpresaService;

@Controller
@RequestMapping("/convocatoria")
public class ConvocatoriaController {

	@Autowired
	private IDistritoService disService;

	@Autowired
	private IEmpresaService empService;

	@Autowired
	private IConvocatoriaService conService;

	@GetMapping("/nuevo")
	public String newConvocatoria(Model model) {

		model.addAttribute("d", new Distrito());

		model.addAttribute("e", new Empresa());

		model.addAttribute("c", new Convocatoria());

		model.addAttribute("listaDistritos", disService.list());

		model.addAttribute("listaEmpresas", empService.list());

		return "convocatoria/frmRegister";
	}

	@PostMapping("/guardar")
	public String saveConvocatoria(@Valid Convocatoria con, BindingResult binRes, Model model) {

		if (binRes.hasErrors()) {

			model.addAttribute("error", "Ocurrió un error!");
			return "convocatoria/frmRegister";

		} else {

			conService.insert(con);
			model.addAttribute("mensaje", "Se guardó correctamente!");

			return "redirect:/convocatoria/listar";
		}
	}

	@GetMapping("/listar")
	public String listConvocatoria(Model model) {

		try {

			model.addAttribute("listaConvocatorias", conService.list());

		} catch (Exception e) {

			model.addAttribute("error", e.getMessage());

		}

		return "convocatoria/frmList";

	}
	
	@RequestMapping("/eliminar")
	public String deleteConvocatoria(Map<String, Object> model, @RequestParam(value = "id") Integer id) {

		try {
			if (id != null && id > 0) {

				conService.delete(id);
				model.put("listaConvocatorias", conService.list());

			}

		} catch (Exception e) {

			model.put("error", e.getMessage());
			//revisar
			//model.put("listaProvincias", provService.list());
		}

		return "redirect:/convocatoria/listar";
	}
	
	@RequestMapping("irmodificar/{id}")
	public String goUpdateConvocatoria(@PathVariable int id, Model model) {

		Optional<Convocatoria> objCon = conService.listId(id);

		model.addAttribute("listaDistritos", disService.list());

		model.addAttribute("listaEmpresas", empService.list());

		model.addAttribute("csa", objCon.get());

		return "convocatoria/frmUpdate";
	}
	
	@PostMapping("/modificar")
	public String updateConvocatoria(Convocatoria con) {

		conService.update(con);
		
		// el redirect:/ es para llamar a funciones dentro del Controller
		return "redirect:/convocatoria/listar";

	}
	
	@RequestMapping("/reporteConvExtensa")
    public String reporteConvExtensa(Map<String, Object> model) {

        model.put("lista", conService.reporteConvExtensa());

        return "convocatoria/reporteConvExtensa";
    }
	

}
