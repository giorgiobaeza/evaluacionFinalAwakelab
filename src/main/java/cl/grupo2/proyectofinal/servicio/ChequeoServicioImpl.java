package cl.grupo2.proyectofinal.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.grupo2.proyectofinal.modelo.Chequeo;
import cl.grupo2.proyectofinal.modelo.ChequeoRepositorio;

@Service
public class ChequeoServicioImpl implements ChequeoServicio {

	@Autowired
	ChequeoRepositorio cr;
	
	@Override
	public Chequeo obtenerChequeoPorId(int idchequeo) {
 		return cr.findOne(idchequeo);
	}

	@Override
	public List<Chequeo> obtenerChequeos() {
		return (List<Chequeo>) cr.findAll();
	}

}
