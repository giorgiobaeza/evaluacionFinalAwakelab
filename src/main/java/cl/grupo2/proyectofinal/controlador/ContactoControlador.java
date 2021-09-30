package cl.grupo2.proyectofinal.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactoControlador {
	@RequestMapping(value="/contacto", method = RequestMethod.GET)
	public String contacto() {
		return "contacto";
	}
	
	@RequestMapping(value="/contactoProcesar", method = RequestMethod.POST)
	public String contactoProcesar(Model model,
		@RequestParam ("nombre") String nombre,
		@RequestParam ("email") String email,
		@RequestParam ("telefono") String telefono,
		@RequestParam ("mensaje") String mensaje ) {
		
		System.out.println(nombre);
		System.out.println(email);
		System.out.println(telefono);
		System.out.println(mensaje);
		
		return "contacto";
	}

}
