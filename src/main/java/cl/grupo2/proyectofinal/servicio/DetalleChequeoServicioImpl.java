package cl.grupo2.proyectofinal.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cl.grupo2.proyectofinal.modelo.DetalleChequeo;
import cl.grupo2.proyectofinal.modelo.DetalleChequeoRepositorio;

@Service
public class DetalleChequeoServicioImpl implements DetalleChequeoServicio{
	
	@Autowired
	DetalleChequeoRepositorio detcheq;

	@Override
	public List<DetalleChequeo> obtenerDetalleChequeo() {
		return (List<DetalleChequeo>) detcheq.findAll();
		
	}

	@Override
	public boolean crearDetalleChequeo(DetalleChequeo cheq) {
		detcheq.save(cheq);
		return true;
	}

	@Override
	public boolean eliminarDetalleChequeo(DetalleChequeo cheq) {
		detcheq.delete(cheq);
		return true;
		
	}

	@Override
	public boolean editarDetalleChequeo(DetalleChequeo cheq) {
		detcheq.save(cheq);
		return true;
		
	}

	@Override
	public DetalleChequeo obtenerDetalleChequeoPorId(int visita_idvisita) {
		return detcheq.findOne(visita_idvisita);
		
	}

}
