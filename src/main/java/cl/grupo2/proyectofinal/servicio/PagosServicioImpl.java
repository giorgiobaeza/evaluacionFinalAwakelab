package cl.grupo2.proyectofinal.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.grupo2.proyectofinal.modelo.Pagos;
import cl.grupo2.proyectofinal.modelo.PagosRepositorio;

@Service
public class PagosServicioImpl implements PagosServicio {
	@Autowired
	PagosRepositorio pr;

	@Override
	public List<Pagos> obtenerPagos() {
		return (List<Pagos>) pr.findAll();
	}

	@Override
	public boolean crearPagos(Pagos pag) {
		pr.save(pag);
		return true;
	}

	@Override
	public boolean eliminarPagos(Pagos pag) {
		pr.delete(pag);
		return true;
	}

	@Override
	public boolean editarPagos(Pagos pag) {
		pr.save(pag);
		return true;
	}

	@Override
	public Pagos obtenerPagosPorId(int idpagos) {
		// TODO Auto-generated method stub
		return pr.findOne(idpagos);
	}

}
