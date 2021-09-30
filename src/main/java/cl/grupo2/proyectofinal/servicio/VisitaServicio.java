package cl.grupo2.proyectofinal.servicio;

import java.util.List;

import cl.grupo2.proyectofinal.modelo.Visita;

public interface VisitaServicio {

	public List<Visita> obtenerVisita();
	public boolean crearVisita(Visita vis);
	public boolean eliminarCliente(Visita vis);
	public boolean editarCliente(Visita vis);
	public Visita obtenerVisitaPorId(int idvisita);
}
	