package pe.edu.upc.demo.controllers;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.demo.entities.Users;
import pe.edu.upc.demo.serviceinterface.IUsersService;

@Controller
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder2;
	
	@Autowired
	private IUsersService usersService;
	
	@GetMapping("/nuevo")
	public String newUsers(Model model) {
		
		model.addAttribute("u", new Users());
		
		return "users/frmRegister";
	}
	
	@GetMapping("/registrarse")
	public String nuevaCuenta(Model model) {
		
		model.addAttribute("u", new Users());
		
		return "users/frmRegistro";
	}
	
	
	
	@PostMapping("/guardar")
	public String saveUsers(@Valid Users us, BindingResult binRes, Model model) {

		if (binRes.hasErrors()) {
			
			model.addAttribute("u", us);
			return "users/frmRegister";

		} else {

			us.setPassword(passwordEncoder2.encode(us.getPassword()));
			us.setEnabled(true);
			usersService.insert(us);
			model.addAttribute("mensaje", "Se guardó correctamente!");
			
			return "redirect:/users/listar";
		}
	}
	
	@PostMapping("/guardar2")
	public String saveUsers2(@Valid Users us, BindingResult binRes, Model model) throws Exception{

		if (binRes.hasErrors()) {
			
			model.addAttribute("u", us);
			return "users/frmRegistro";

		} else {

			us.setPassword(passwordEncoder2.encode(us.getPassword()));
			us.setEnabled(true);
			usersService.insert(us);
			model.addAttribute("mensaje", "Se guardó correctamente!");
			
			return "redirect:/login";
		}
	}
	
	
	
	
	@GetMapping("/listar")
	public String listUsers(Model model) {

		try {

			model.addAttribute("listaUsuarios", usersService.list());

		} catch (Exception e) {

			model.addAttribute("error", e.getMessage());

		}

		return "users/frmList";
	}
	
	@RequestMapping("/eliminar")
	public String deleteUsers(Map<String, Object> model, @RequestParam(value = "id") Long id) {

		try {
			if (id != null && id > 0) {

				usersService.delete(id);
				model.put("listaUsuarios", usersService.list());

			}

		} catch (Exception e) {

			model.put("error", e.getMessage());
		}

		return "redirect:/users/listar";
	}
	
	@RequestMapping("irmodificar/{id}")
	public String goUpdateUsers(@PathVariable Long id, Model model) {

		Optional<Users> objUsers = usersService.listId(id);

		model.addAttribute("usa", objUsers.get());

		return "users/frmUpdate";
	}
	
	
	
	

}
