package cl.grupo2.proyectofinal.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.grupo2.proyectofinal.modelo.Visita;
import cl.grupo2.proyectofinal.modelo.VisitaRepositorio;

@Service
public class VisitaServicioImpl implements VisitaServicio{

	@Autowired
	VisitaRepositorio vr;

	@Override
	public List<Visita> obtenerVisita() {
	
		return (List<Visita>) vr.findAll();
	}

	@Override
	public boolean crearVisita(Visita vis) {
		vr.save(vis);
		return true;
	}

	@Override
	public boolean eliminarCliente(Visita vis) {
		vr.delete(vis);
		return true;
	}

	@Override
	public boolean editarCliente(Visita vis) {
		vr.save(vis);
		return true;
	}

	@Override
	public Visita obtenerVisitaPorId(int idvisita) {
		return vr.findOne(idvisita);
	}

}

	