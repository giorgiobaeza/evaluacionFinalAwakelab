package cl.grupo2.proyectofinal.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Administrativo {
	
	
	private int run;
	private String nombres;
	private String apellidos;
	private String email;
	private String area;
	@Id
	private int usuario_run;
	
	public Administrativo(int run, String nombres, String apellidos, String email, String area, int usuario_run) {
		super();
		this.run = run;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
		this.area = area;
		this.usuario_run = usuario_run;
	}
	public Administrativo() {
		super();
	}
	@Override
	public String toString() {
		return "Administrativo [run=" + run + ", nombres=" + nombres + ", apellidos=" + apellidos + ", email=" + email
				+ ", area=" + area + ", usuario_run=" + usuario_run + "]";
	}
	public int getRun() {
		return run;
	}
	public void setRun(int run) {
		this.run = run;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getUsuario_run() {
		return usuario_run;
	}
	public void setUsuario_run(int usuario_run) {
		this.usuario_run = usuario_run;
	}
	
	
}
