package cl.grupo2.proyectofinal.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cl.grupo2.proyectofinal.modelo.Cliente;
import cl.grupo2.proyectofinal.modelo.Usuario;
import cl.grupo2.proyectofinal.servicio.ClienteServicio;
import cl.grupo2.proyectofinal.servicio.UsuarioServicio;

@Controller
public class ClienteControlador {
	
	@Autowired
	ClienteServicio cs;
	
	@Autowired
	UsuarioServicio us;
	
	@RequestMapping(value="/editarCliente/{usuario_run}", method = RequestMethod.GET)
	public String editarCliente(Model model, @PathVariable int usuario_run) {
		Cliente rutcli = cs.obtenerClientePorId(usuario_run);
		model.addAttribute("cli", rutcli);
		Usuario rutusr = us.obtenerUsuarioPorId(usuario_run);
		model.addAttribute("usr", rutusr);
		return "editarCliente";
	}	
	
	@RequestMapping(value="/procesarEditarCliente", method = RequestMethod.POST)
	public String editarClientesProcesar(Model model, 
		@RequestParam ("txtrutCliente") int rutCliente,
		@RequestParam ("txtcliNombres") String cliNombres,
		@RequestParam ("txtcliApellidos") String cliApellidos,
		@RequestParam ("txtcliTelefono") String cliTelefono,
		@RequestParam ("txtcliAfp") String cliAfp,
		@RequestParam ("txtcliSistemaSalud") String cliSistemaSalud,
		@RequestParam ("txtcliDireccion") String cliDireccion,
		@RequestParam ("txtcliComuna") String cliComuna,
		@RequestParam ("txtcliEdad") int cliEdad,
		@RequestParam ("txtusuariorun") int usuario_run) {
		
		Cliente cli = new Cliente(rutCliente, cliNombres,
				cliApellidos, cliTelefono, cliAfp, cliSistemaSalud, cliDireccion, cliComuna, cliEdad, usuario_run);
		boolean result = cs.editarCliente(cli);
		String titulo ="Editar Cliente";
		model.addAttribute("msgtitulo", titulo);
		String mensaje = "";
		
		if (result) {
			mensaje = "El Cliente fue editado correctamente";
		}
		else {
			mensaje = "No se pudo editar Cliente";
		}
		model.addAttribute("msgmensaje", mensaje);
		String direccion = "/listarUsuarios";
		model.addAttribute("msgdireccion", direccion);
		return "msgcrear";
	}

}
