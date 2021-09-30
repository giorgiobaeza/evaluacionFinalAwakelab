package cl.grupo2.proyectofinal.servicio;

import java.util.List;

import cl.grupo2.proyectofinal.modelo.Administrativo;


public interface AdministrativoServicio {

	public List<Administrativo> obtenerAdministrativo();
	public boolean crearAdministrativo(Administrativo adm);
	public boolean eliminarAdministrativo(Administrativo adm);
	public boolean editarAdministrativo(Administrativo adm);
	public Administrativo obtenerAdministrativoPorId(int usuario_run);
}
