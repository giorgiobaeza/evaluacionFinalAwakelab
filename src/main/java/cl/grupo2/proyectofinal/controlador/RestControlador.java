package cl.grupo2.proyectofinal.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.grupo2.proyectofinal.modelo.Cliente;
import cl.grupo2.proyectofinal.servicio.ClienteServicio;


@RestController
public class RestControlador {

	@Autowired
	ClienteServicio cs;

	@RequestMapping(value = "/clilist", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Cliente> getClientes() {
		List<Cliente> listaclientes = cs.obtenerCliente();
		return listaclientes;
	}
	
	@RequestMapping(value = "/clilist", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addCliente(@RequestBody Cliente cliente) {
	cs.crearCliente(cliente);
	}
	
	@RequestMapping(value = "/clilist", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void updateCliente(@RequestBody Cliente cliente) {
	cs.editarCliente(cliente);
	}

	@RequestMapping(value = "/clidetalle/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Cliente getClientePorId(@PathVariable int id) {
	return cs.obtenerClientePorId(id);
	}

	@RequestMapping(value = "/clidetalle/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteCliente(@PathVariable("id") int id) {
		Cliente cli = cs.obtenerClientePorId(id);
		cs.eliminarCliente(cli);
	}
}
