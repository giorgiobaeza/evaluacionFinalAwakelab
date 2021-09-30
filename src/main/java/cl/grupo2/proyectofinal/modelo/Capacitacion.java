package cl.grupo2.proyectofinal.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Capacitacion {

	@Id
	private int idCapacitacion;
	private String capFecha;
	private String capHora;
	private String capLugar;
	private int capDuracion;
	private int cliente_RutCliente;
	
	public Capacitacion() {
		super();
	}

	public Capacitacion(int idCapacitacion, String capFecha, String capHora, String capLugar, int capDuracion,
			int cliente_RutCliente) {
		super();
		this.idCapacitacion = idCapacitacion;
		this.capFecha = capFecha;
		this.capHora = capHora;
		this.capLugar = capLugar;
		this.capDuracion = capDuracion;
		this.cliente_RutCliente = cliente_RutCliente;
	}

	public int getIdCapacitacion() {
		return idCapacitacion;
	}

	public void setIdCapacitacion(int idCapacitacion) {
		this.idCapacitacion = idCapacitacion;
	}

	public String getCapFecha() {
		return capFecha;
	}

	public void setCapFecha(String capFecha) {
		this.capFecha = capFecha;
	}

	public String getCapHora() {
		return capHora;
	}

	public void setCapHora(String capHora) {
		this.capHora = capHora;
	}

	public String getCapLugar() {
		return capLugar;
	}

	public void setCapLugar(String capLugar) {
		this.capLugar = capLugar;
	}

	public int getCapDuracion() {
		return capDuracion;
	}

	public void setCapDuracion(int capDuracion) {
		this.capDuracion = capDuracion;
	}

	public int getCliente_rutCliente() {
		return cliente_RutCliente;
	}

	public void setCliente_rutCliente(int cliente_rutCliente) {
		this.cliente_RutCliente = cliente_rutCliente;
	}

	@Override
	public String toString() {
		return "Capacitacion [idCapacitacion=" + idCapacitacion + ", capFecha=" + capFecha + ", capHora=" + capHora
				+ ", capLugar=" + capLugar + ", capDuracion=" + capDuracion + ", cliente_RutCliente="
				+ cliente_RutCliente + "]";
	}
	
	
	
	

}
