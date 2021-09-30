package cl.grupo2.proyectofinal.servicio;

import java.util.List;

import cl.grupo2.proyectofinal.modelo.Profesional;

public interface ProfesionalServicio {

	public List<Profesional> obtenerProfesional();
	public boolean crearProfesional(Profesional pro);
	public boolean eliminarProfesional(Profesional pro);
	public boolean editarProfesional(Profesional pro);
	public Profesional obtenerProfesionalPorId(int usuario_run);
}
