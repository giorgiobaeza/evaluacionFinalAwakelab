package cl.grupo2.proyectofinal.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cl.grupo2.proyectofinal.modelo.Profesional;
import cl.grupo2.proyectofinal.modelo.Usuario;
import cl.grupo2.proyectofinal.servicio.ProfesionalServicio;
import cl.grupo2.proyectofinal.servicio.UsuarioServicio;

@Controller
public class ProfesionalControlador {
	
	@Autowired
	ProfesionalServicio pr;
	
	@Autowired
	UsuarioServicio us;
	
	@RequestMapping(value="/editarProfesional/{usuario_run}", method = RequestMethod.GET)
	public String editarProfesional(Model model, @PathVariable int usuario_run) {
		Profesional rutpro = pr.obtenerProfesionalPorId(usuario_run);
		model.addAttribute("pro", rutpro);
		Usuario rutusr = us.obtenerUsuarioPorId(usuario_run);
		model.addAttribute("usr", rutusr);
		return "editarProfesional";
	}	
	
	@RequestMapping(value="/procesarEditarProfesional", method = RequestMethod.POST)
	public String editarProfesionalProcesar(Model model, 
		@RequestParam ("txtrutprofesional") int run,
		@RequestParam ("txtpronombres") String nombres,
		@RequestParam ("txtproapellidos") String apellidos,
		@RequestParam ("txtprotelefono") long telefono,
		@RequestParam ("txtprotitulo") String tituloProfesional,
		@RequestParam ("txtproproyecto") String proyecto,
		@RequestParam ("txtusuariorun") int usuario_run) {
		
		Profesional pro = new Profesional(run, nombres,
				apellidos, telefono, tituloProfesional, proyecto, usuario_run);
		boolean result = pr.editarProfesional(pro);
		String titulo ="Editar Profesional";
		model.addAttribute("msgtitulo", titulo);
		String mensaje = "";
		
		if (result) {
			mensaje = "El Profesional fue editado correctamente";
		}
		else {
			mensaje = "No se pudo editar Profesional";
		}
		model.addAttribute("msgmensaje", mensaje);
		String direccion = "/listarUsuarios";
		model.addAttribute("msgdireccion", direccion);
		return "msgcrear";
	}
}
