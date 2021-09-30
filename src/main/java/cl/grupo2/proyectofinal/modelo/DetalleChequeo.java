package cl.grupo2.proyectofinal.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DetalleChequeo {
	
	private String cumple_observaciones;
	private int visita_idvisita;
	@Id
	private int chequeo_idchequeo;
	
	@Override
	public String toString() {
		return "DetalleChequeo [cumple_observaciones=" + cumple_observaciones + ", visita_idvisita=" + visita_idvisita
				+ ", chequeo_idchequeo=" + chequeo_idchequeo + "]";
	}

	public String getCumple_observaciones() {
		return cumple_observaciones;
	}

	public void setCumple_observaciones(String cumple_observaciones) {
		this.cumple_observaciones = cumple_observaciones;
	}

	public int getVisita_idvisita() {
		return visita_idvisita;
	}

	public void setVisita_idvisita(int visita_idvisita) {
		this.visita_idvisita = visita_idvisita;
	}

	public int getChequeo_idchequeo() {
		return chequeo_idchequeo;
	}

	public void setChequeo_idchequeo(int chequeo_idchequeo) {
		this.chequeo_idchequeo = chequeo_idchequeo;
	}

	public DetalleChequeo() {
		super();
	}

	public DetalleChequeo(String cumple_observaciones, int visita_idvisita, int chequeo_idchequeo) {
		super();
		this.cumple_observaciones = cumple_observaciones;
		this.visita_idvisita = visita_idvisita;
		this.chequeo_idchequeo = chequeo_idchequeo;
	}
	
	
	
	
}


