package Gym;

import java.io.Serializable;
import java.util.ArrayList;

public class Clientes implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String apellido;
	private char sexo;
	private int edad;
	private String numeroTel;
	private String direccion;
	private String detallesMedicos;
	private ArrayList<Entradas> entradas=new ArrayList<Entradas>();
	
	public Clientes(String nombre, String apellido, char sexo, int edad, String numeroTel, String direccion,
			String detallesMedicos) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.edad = edad;
		this.numeroTel = numeroTel;
		this.direccion = direccion;
		this.detallesMedicos = detallesMedicos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getNumeroTel() {
		return numeroTel;
	}
	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDetallesMedicos() {
		return detallesMedicos;
	}
	public void setDetallesMedicos(String detallesMedicos) {
		this.detallesMedicos = detallesMedicos;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((numeroTel == null) ? 0 : numeroTel.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clientes other = (Clientes) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numeroTel == null) {
			if (other.numeroTel != null)
				return false;
		} else if (!numeroTel.equals(other.numeroTel))
			return false;
		return true;
	}
	
	public void altaEntrada(Entradas entradax) {
		entradas.add(entradax);
	}
	
	
}
