package cl.grupo2.proyectofinal.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cl.grupo2.proyectofinal.modelo.Capacitacion;
import cl.grupo2.proyectofinal.modelo.Cliente;
import cl.grupo2.proyectofinal.servicio.CapacitacionServicio;
import cl.grupo2.proyectofinal.servicio.ClienteServicio;

@Controller
public class CapacitacionControlador {
	
	@Autowired
	CapacitacionServicio cs; 
	
	@Autowired
	ClienteServicio cls;
	
	@RequestMapping(value="/listarCapacitaciones", method = RequestMethod.GET)
	public String obtenerCapacitacion(Model model) {
		List<Capacitacion> listacapacitacion = cs.obtenerCapacitacion();
		model.addAttribute("lcapacitacion", listacapacitacion);
		return "listarCapacitaciones";
	}
	
	@RequestMapping(value="/crearCapacitacion", method = RequestMethod.GET)
	public String crearCapacitacion(Model model) {
		List<Cliente> listacli = cls.obtenerCliente();
		model.addAttribute("lcli", listacli);
		List<Capacitacion> listacapacitacion = cs.obtenerCapacitacion();
		int numeroid = listacapacitacion.size() + 1; 
		model.addAttribute("nid", numeroid);
		return "crearCapacitacion";
	}

	@RequestMapping(value="/crearCapacitacionProcesar", method = RequestMethod.POST)
	public String crearCapacitaciones(Model model,
		@RequestParam ("idcapacitacion") int idCapacitacion,
		@RequestParam ("capfecha") String capFecha,
		@RequestParam ("caphora") String capHora,
		@RequestParam ("caplugar") String capLugar,
		@RequestParam ("capduracion") int capDuracion,
		@RequestParam ("cliente_rutcliente") int cliente_RutCliente ) {
		
		Capacitacion cap = new Capacitacion(idCapacitacion, capFecha, capHora,
				capLugar, capDuracion, cliente_RutCliente);
		boolean result = cs.crearCapacitacion(cap);
		String titulo ="Crear Capacitacion";
		model.addAttribute("msgtitulo", titulo);		
		String mensaje ="";

		if (result) {
			mensaje = "Capacitacion Creada";
		}
		else {
			mensaje = "Problema al crear la Capacitacion";
		}
		model.addAttribute("msgmensaje", mensaje);
		String direccion = "/listarCapacitaciones";
		model.addAttribute("msgdireccion", direccion);
		return "msgcrear";
	}
	
	
}
