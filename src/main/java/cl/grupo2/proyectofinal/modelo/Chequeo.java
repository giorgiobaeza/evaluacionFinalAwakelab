package cl.grupo2.proyectofinal.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Chequeo {
	
	@Id
	private int idchequeo;
	private String nombrechequeo;
	
	public Chequeo(int idchequeo, String nombrechequeo) {
		super();
		this.idchequeo = idchequeo;
		this.nombrechequeo = nombrechequeo;
	}
	public Chequeo() {
		super();
	}
	@Override
	public String toString() {
		return "Chequeo [idchequeo=" + idchequeo + ", nombrechequeo=" + nombrechequeo + "]";
	}
	public int getidchequeo() {
		return idchequeo;
	}
	public void setidchequeo(int idchequeo) {
		this.idchequeo = idchequeo;
	}
	public String getNombrechequeo() {
		return nombrechequeo;
	}
	public void setNombrechequeo(String nombrechequeo) {
		this.nombrechequeo = nombrechequeo;
	}
	
	

}
