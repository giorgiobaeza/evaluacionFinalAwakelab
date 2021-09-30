package cl.grupo2.proyectofinal.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.grupo2.proyectofinal.modelo.Usuario;
import cl.grupo2.proyectofinal.modelo.UsuarioRepositorio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{

	@Autowired
	UsuarioRepositorio ur;

	@Override
	public List<Usuario> obtenerUsuario() {
		return (List<Usuario>) ur.findAll();
	}

	@Override
	public boolean crearUsuario(Usuario usr) {
		ur.save(usr);
		return true;
	}

	@Override
	public Usuario obtenerUsuarioPorId(int run) {
		return ur.findOne(run);
	}

	
}
