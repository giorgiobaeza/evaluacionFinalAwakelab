package cl.grupo2.proyectofinal.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.grupo2.proyectofinal.modelo.Capacitacion;
import cl.grupo2.proyectofinal.modelo.CapacitacionRepositorio;


@Service
public class CapacitacionServicioImpl implements CapacitacionServicio {

	@Autowired
	CapacitacionRepositorio ca;
	
	@Override
	public List<Capacitacion> obtenerCapacitacion() {
		return (List<Capacitacion>) ca.findAll();
	}

	@Override
	public boolean crearCapacitacion(Capacitacion cap) {
		ca.save(cap);
		return true;
	}

	@Override
	public boolean eliminarCapacitacion(Capacitacion cap) {
		ca.delete(cap);
		return true;
	}

	@Override
	public boolean editarCapacitacion(Capacitacion cap) {
		ca.save(cap);
		return true;
	}

	@Override
	public Capacitacion obtenerCapacitacionPorId(int idcap) {
		
		return ca.findOne(idcap);
	}

}
