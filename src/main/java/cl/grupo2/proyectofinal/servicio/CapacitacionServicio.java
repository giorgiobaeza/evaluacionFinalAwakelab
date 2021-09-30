package cl.grupo2.proyectofinal.servicio;

import java.util.List;

import cl.grupo2.proyectofinal.modelo.Capacitacion;


public interface CapacitacionServicio {

	public List<Capacitacion> obtenerCapacitacion();
	public boolean crearCapacitacion(Capacitacion cap);
	public boolean eliminarCapacitacion(Capacitacion cap);
	public boolean editarCapacitacion(Capacitacion cap);
	public Capacitacion obtenerCapacitacionPorId(int idcap);
}
