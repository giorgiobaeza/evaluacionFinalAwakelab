package cl.grupo2.proyectofinal.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cl.grupo2.proyectofinal.modelo.Usuario;
import cl.grupo2.proyectofinal.servicio.UsuarioServicio;

@Controller
public class UsuarioControlador {

	@Autowired
	UsuarioServicio us;
	
	@RequestMapping(value="/listarUsuarios", method = RequestMethod.GET)
	public String obtenerUsuarios(Model model) {
		List<Usuario> listausuarios = us.obtenerUsuario();
		model.addAttribute("lusuarios", listausuarios);
		return "listarUsuarios";	
	}
	
	@RequestMapping(value="/crearUsuario", method = RequestMethod.GET)
	public String crearUsuario(Model model) {
		return "crearUsuario";
	}

	@RequestMapping(value="/crearUsuarioProcesar", method = RequestMethod.POST)
	public String crearUsuarios(Model model,
		@RequestParam ("usnombre") String nombre,
		@RequestParam ("usapellido") String apellido,
		@RequestParam ("usfecha") String fechanacimiento,
		@RequestParam ("usrun") int run,
		@RequestParam ("tipousuario") String tipousuario ) {
		
		Usuario usr = new Usuario(nombre, apellido, fechanacimiento, run, tipousuario);
		boolean result = us.crearUsuario(usr);
		String titulo ="Crear Usuario";
		String mensaje ="";
		model.addAttribute("msgtitulo", titulo);

		if (result) {
			mensaje = "Usuario Creado";
		}
		else {
			mensaje = "Problema al crear el Usuario";
		}
		model.addAttribute("msgmensaje", mensaje);		
		String direccion = "/crearUsuario";
		model.addAttribute("msgdireccion", direccion);
		return "msgcrear";
	}
}
