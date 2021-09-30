package cl.grupo2.proyectofinal.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.grupo2.proyectofinal.modelo.Cliente;
import cl.grupo2.proyectofinal.modelo.ClienteRepositorio;

@Service
public class ClienteServicioImpl implements ClienteServicio{

	@Autowired
	ClienteRepositorio cl;
	
	@Override
	public List<Cliente> obtenerCliente() {
		return (List<Cliente>) cl.findAll();

	}

	@Override
	public boolean crearCliente(Cliente cli) {
		cl.save(cli);
		return true;
	}

	@Override
	public boolean eliminarCliente(Cliente cli) {
		cl.delete(cli);
		return true;
	}

	@Override
	public boolean editarCliente(Cliente cli) {
		cl.save(cli);
		return true;
	}

	@Override
	public Cliente obtenerClientePorId(int usuario_run) {
		return cl.findOne(usuario_run);
	}

}
