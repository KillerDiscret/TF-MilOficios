package pe.edu.upc.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inicio")
public class InicioController {

	@RequestMapping(" ")
	public String irPaginaInicio() {
		
		return "home/inicio";
	}
	
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenido() {
		
		return "home/bienvenido";
	}
	
}
