package cl.grupo2.proyectofinal.servicio;

import java.util.List;

import cl.grupo2.proyectofinal.modelo.Chequeo;

public interface ChequeoServicio {

	public List<Chequeo> obtenerChequeos();
	public Chequeo obtenerChequeoPorId(int idchequeo);
}
