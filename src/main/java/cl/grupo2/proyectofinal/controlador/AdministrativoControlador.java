package cl.grupo2.proyectofinal.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cl.grupo2.proyectofinal.modelo.Administrativo;
import cl.grupo2.proyectofinal.modelo.Usuario;
import cl.grupo2.proyectofinal.servicio.AdministrativoServicio;
import cl.grupo2.proyectofinal.servicio.UsuarioServicio;

@Controller
public class AdministrativoControlador {
	
	@Autowired
	AdministrativoServicio cs;
	
	@Autowired
	UsuarioServicio us;
	
	@RequestMapping(value="/editarAdministrativo/{usuario_run}", method = RequestMethod.GET)
	public String editarAdministrativo(Model model, @PathVariable int usuario_run) {
		Administrativo rutadm = cs.obtenerAdministrativoPorId(usuario_run);
		model.addAttribute("adm", rutadm);
		Usuario rutusr = us.obtenerUsuarioPorId(usuario_run);
		model.addAttribute("usr", rutusr);
		return "editarAdministrativo";
	}	
	
	@RequestMapping(value="/procesarEditarAdministrativo", method = RequestMethod.POST)
	public String editarAdministrativoProcesar(Model model, 
		@RequestParam ("txtrutadministrativo") int run,
		@RequestParam ("txtadmnombres") String nombres,
		@RequestParam ("txtadmapellidos") String apellidos,
		@RequestParam ("txtadmemail") String email,
		@RequestParam ("txtadmarea") String area,
		@RequestParam ("txtusuariorun") int usuario_run) {
		
		Administrativo adm = new Administrativo(run, nombres,
				apellidos, email, area, usuario_run);
		boolean result = cs.editarAdministrativo(adm);
		String titulo ="Editar Administrativo";
		model.addAttribute("msgtitulo", titulo);
		String mensaje = "";
		
		if (result) {
			mensaje = "El Administrativo fue editado correctamente";
		}
		else {
			mensaje = "No se pudo editar Administrativo";
		}
		model.addAttribute("msgmensaje", mensaje);
		String direccion = "/listarUsuarios";
		model.addAttribute("msgdireccion", direccion);
		return "msgcrear";
	}

}
