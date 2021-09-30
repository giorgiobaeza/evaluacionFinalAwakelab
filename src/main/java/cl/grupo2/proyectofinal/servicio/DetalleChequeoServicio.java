package cl.grupo2.proyectofinal.servicio;

import java.util.List;

import cl.grupo2.proyectofinal.modelo.DetalleChequeo;

public interface DetalleChequeoServicio {
	
	public List<DetalleChequeo> obtenerDetalleChequeo();
	public boolean crearDetalleChequeo(DetalleChequeo cheq);
	public boolean eliminarDetalleChequeo(DetalleChequeo cheq);
	public boolean editarDetalleChequeo(DetalleChequeo cheq);
	public DetalleChequeo obtenerDetalleChequeoPorId(int visita_idvisita);

}
