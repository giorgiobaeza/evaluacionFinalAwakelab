package cl.grupo2.proyectofinal.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cl.grupo2.proyectofinal.modelo.Cliente;
import cl.grupo2.proyectofinal.modelo.Visita;
import cl.grupo2.proyectofinal.servicio.ClienteServicio;
import cl.grupo2.proyectofinal.servicio.VisitaServicio;

@Controller
public class VisitaControlador {

	@Autowired
	VisitaServicio vs;
	
	@Autowired
	ClienteServicio cs;
	
	@RequestMapping(value="/listarVisitas", method = RequestMethod.GET)
	public String listarVisitas(Model model) {
		List<Visita> listvis = vs.obtenerVisita();
		model.addAttribute("lvisita", listvis);
		List<Cliente> rutcliente = cs.obtenerCliente();
		model.addAttribute("rutclie", rutcliente);
		int numeroid = listvis.size() + 1;
		model.addAttribute("nid", numeroid);
		return "listarVisita";
	}
	
	@RequestMapping(value="/crearVisita", method = RequestMethod.POST)
	public String crearVisita(Model model, 
			@RequestParam ("txtidvisita") int idvisita,
			@RequestParam ("txtvisfecha") String visfecha,
			@RequestParam ("txtvishora") String vishora,
			@RequestParam ("txtvislugar") String vislugar,
			@RequestParam ("txtviscomentarios") String viscomentarios,
			@RequestParam ("txtrutcliente") int cliente_rutcliente) {
		
		Visita vis = new Visita(idvisita, visfecha, vishora, vislugar, viscomentarios, cliente_rutcliente);
		boolean result = vs.crearVisita(vis);
		String mensaje = "";
		if(result) {
			mensaje = "La Visita fue creada correctamente";
		}
		else {
			mensaje = "No se pudo crear la Visita";
		}
		model.addAttribute("msgmensaje", mensaje);
		return "redirect:/listarVisitas";
	}	
	
}
