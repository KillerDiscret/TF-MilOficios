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

import pe.edu.upc.demo.entities.Role;
import pe.edu.upc.demo.serviceinterface.IRoleService;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private IRoleService roleService;
	
	@GetMapping("/nuevo")
	public String newRole(Model model) {
		
		model.addAttribute("r", new Role());
		
		return "role/frmRegister";
	}
	
	@PostMapping("/guardar")
	public String saveRole(@Valid Role ro, BindingResult binRes, Model model) {

		if (binRes.hasErrors()) {
			
			model.addAttribute("r", ro);
			return "role/frmRegister";

		} else {

			roleService.insert(ro);
			model.addAttribute("mensaje", "Se guardó correctamente!");
			
			return "redirect:/role/listar";
		}
	}
	
	@GetMapping("/listar")
	public String listRole(Model model) {

		try {

			model.addAttribute("listaRoles", roleService.list());

		} catch (Exception e) {

			model.addAttribute("error", e.getMessage());

		}

		return "role/frmList";
	}
	
	@RequestMapping("/eliminar")
	public String deleteRole(Map<String, Object> model, @RequestParam(value = "id") Long id) {

		try {
			if (id != null && id > 0) {

				roleService.delete(id);
				model.put("listaRoles", roleService.list());

			}

		} catch (Exception e) {

			model.put("error", e.getMessage());
			//revisar
			//model.put("listaProvincias", provService.list());
		}

		return "redirect:/role/listar";
	}
	@RequestMapping("irmodificar/{id}")
	public String goUpdateRole(@PathVariable Long id, Model model) {

		Optional<Role> objProv = roleService.listId(id);

		model.addAttribute("listaRoles", roleService.list());
		model.addAttribute("rsa", objProv.get());

		return "role/frmUpdate";
	}
	
	@PostMapping("/modificar")
	public String updateProvincia(Role role) {

		roleService.update(role);
		
		// el redirect:/ es para llamar a funciones dentro del Controller
		return "redirect:/role/listar";

	}
	
	
}
