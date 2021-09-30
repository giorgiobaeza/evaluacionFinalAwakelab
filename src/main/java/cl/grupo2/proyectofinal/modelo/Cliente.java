package cl.grupo2.proyectofinal.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente {
	
	private int rutCliente;
	private String cliNombres;
	private String cliApellidos;
	private String cliTelefono;
	private String cliAfp;
	private String cliSistemaSalud;
	private String cliDireccion;
	private String cliComuna;
	private int cliEdad;
	@Id
	private int usuario_run;
	
	public int getRutCliente() {
		return rutCliente;
	}

	public void setRutCliente(int rutCliente) {
		this.rutCliente = rutCliente;
	}

	public String getCliNombres() {
		return cliNombres;
	}

	public void setCliNombres(String cliNombres) {
		this.cliNombres = cliNombres;
	}

	public String getCliApellidos() {
		return cliApellidos;
	}

	public void setCliApellidos(String cliApellidos) {
		this.cliApellidos = cliApellidos;
	}

	public String getCliTelefono() {
		return cliTelefono;
	}

	public void setCliTelefono(String cliTelefono) {
		this.cliTelefono = cliTelefono;
	}

	public String getCliAfp() {
		return cliAfp;
	}

	public void setCliAfp(String cliAfp) {
		this.cliAfp = cliAfp;
	}

	public String getCliSistemaSalud() {
		return cliSistemaSalud;
	}

	public void setCliSistemaSalud(String cliSistemaSalud) {
		this.cliSistemaSalud = cliSistemaSalud;
	}

	public String getCliDireccion() {
		return cliDireccion;
	}

	public void setCliDireccion(String cliDireccion) {
		this.cliDireccion = cliDireccion;
	}

	public String getCliComuna() {
		return cliComuna;
	}

	public void setCliComuna(String cliComuna) {
		this.cliComuna = cliComuna;
	}

	public int getCliEdad() {
		return cliEdad;
	}

	public void setCliEdad(int cliEdad) {
		this.cliEdad = cliEdad;
	}

	public int getUsuario_run() {
		return usuario_run;
	}

	public void setUsuario_run(int usuario_run) {
		this.usuario_run = usuario_run;
	}

	@Override
	public String toString() {
		return "Cliente [rutCliente=" + rutCliente + ", cliNombres=" + cliNombres + ", cliApellidos=" + cliApellidos
				+ ", cliTelefono=" + cliTelefono + ", cliAfp=" + cliAfp + ", cliSistemaSalud=" + cliSistemaSalud
				+ ", cliDireccion=" + cliDireccion + ", cliComuna=" + cliComuna + ", cliEdad=" + cliEdad
				+ ", usuario_run=" + usuario_run + "]";
	}

	public Cliente() {
		super();
	}

	public Cliente(int rutCliente, String cliNombres, String cliApellidos, String cliTelefono, String cliAfp,
			String cliSistemaSalud, String cliDireccion, String cliComuna, int cliEdad, int usuario_run) {
		super();
		this.rutCliente = rutCliente;
		this.cliNombres = cliNombres;
		this.cliApellidos = cliApellidos;
		this.cliTelefono = cliTelefono;
		this.cliAfp = cliAfp;
		this.cliSistemaSalud = cliSistemaSalud;
		this.cliDireccion = cliDireccion;
		this.cliComuna = cliComuna;
		this.cliEdad = cliEdad;
		this.usuario_run = usuario_run;
	}
	
	

}
