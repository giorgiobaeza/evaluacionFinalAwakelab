package cl.grupo2.proyectofinal.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.grupo2.proyectofinal.modelo.Administrativo;
import cl.grupo2.proyectofinal.modelo.AdministrativoRepositorio;


@Service
public class AdministrativoServicioImpl implements AdministrativoServicio {

	@Autowired
	AdministrativoRepositorio ad;
	
	@Override
	public List<Administrativo> obtenerAdministrativo() {
		return (List<Administrativo>) ad.findAll();
	}

	@Override
	public boolean crearAdministrativo(Administrativo adm) {
		ad.save(adm);
		return true;
	}

	@Override
	public boolean eliminarAdministrativo(Administrativo adm) {
		ad.delete(adm);
		return true;
	}

	@Override
	public boolean editarAdministrativo(Administrativo adm) {
		ad.save(adm);
		return true;
	}

	@Override
	public Administrativo obtenerAdministrativoPorId(int usuario_run) {
		
		return ad.findOne(usuario_run);
	}

}
