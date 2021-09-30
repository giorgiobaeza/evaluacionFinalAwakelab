package cl.grupo2.proyectofinal.controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.grupo2.proyectofinal.modelo.Chequeo;
import cl.grupo2.proyectofinal.modelo.DetalleChequeo;
import cl.grupo2.proyectofinal.servicio.ChequeoServicio;
import cl.grupo2.proyectofinal.servicio.DetalleChequeoServicio;
import cl.grupo2.proyectofinal.servicio.VisitaServicio;

@Controller
public class ChequeoControlador {
	
	@Autowired
	DetalleChequeoServicio ds;
	
	@Autowired
	VisitaServicio vs;
	
	@Autowired
	ChequeoServicio cs;
	
	@RequestMapping(value="/listarDetalleChequeo/{Idvisita}", method = RequestMethod.GET)
	public String obtenerChequeo(Model model, @PathVariable int Idvisita) {
		DetalleChequeo listacheq = ds.obtenerDetalleChequeoPorId(Idvisita);
		model.addAttribute("dchequeo", listacheq);
		Chequeo chequeoid = cs.obtenerChequeoPorId(Idvisita);
		model.addAttribute("chequeo", chequeoid);
		return "listarDetalleChequeo";
	}
	
	
}
