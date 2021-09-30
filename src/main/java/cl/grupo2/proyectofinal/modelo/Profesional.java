package cl.grupo2.proyectofinal.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Profesional {

	private int run;
	private String nombres;
	private String apellidos;
	private long telefono;
	private String tituloprofesional;
	private String proyecto;
	@Id
	private int usuario_run;
	
	public Profesional(int run, String nombres, String apellidos, long telefono, String tituloprofesional,
			String proyecto, int usuario_run) {
		super();
		this.run = run;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.tituloprofesional = tituloprofesional;
		this.proyecto = proyecto;
		this.usuario_run = usuario_run;
	}
	public Profesional() {
		super();
	}
	@Override
	public String toString() {
		return "Profesional [run=" + run + ", nombres=" + nombres + ", apellidos=" + apellidos + ", telefono="
				+ telefono + ", tituloprofesional=" + tituloprofesional + ", proyecto=" + proyecto + ", usuario_run="
				+ usuario_run + "]";
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
	public long getTelefono() {
		return telefono;
	}
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	public String getTituloprofesional() {
		return tituloprofesional;
	}
	public void setTituloprofesional(String tituloprofesional) {
		this.tituloprofesional = tituloprofesional;
	}
	public String getProyecto() {
		return proyecto;
	}
	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}
	public int getUsuario_run() {
		return usuario_run;
	}
	public void setUsuario_run(int usuario_run) {
		this.usuario_run = usuario_run;
	}
	
	
}
