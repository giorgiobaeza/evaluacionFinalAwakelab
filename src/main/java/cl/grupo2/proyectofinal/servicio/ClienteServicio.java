package cl.grupo2.proyectofinal.servicio;

import java.util.List;

import cl.grupo2.proyectofinal.modelo.Cliente;

public interface ClienteServicio {

	public List<Cliente> obtenerCliente();
	public boolean crearCliente(Cliente cli);
	public boolean eliminarCliente(Cliente cli);
	public boolean editarCliente(Cliente cli);
	public Cliente obtenerClientePorId(int usuario_run);
}
