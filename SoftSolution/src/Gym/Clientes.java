package Gym;

import java.io.Serializable;
import java.util.ArrayList;

public class Clientes implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String apellido;
	private char sexo;
	private int edad;
	private long numeroTel;
	private String direccion;
	
	private ArrayList<String> detallesMedicos = new ArrayList<>();
	private ArrayList<Entradas> entradas = new ArrayList<Entradas>();
	
	private PagoCliente pago;
	private String formaPago;
	
	private String toStringMedicos = "";
	private String Ocupacion;

	public Clientes(String nombre, String apellido, char sexo, int edad, long numeroTel, String direccion,
			ArrayList<String> detallesMedicos, ArrayList<Entradas> entradas, PagoCliente pago) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.edad = edad;
		this.numeroTel = numeroTel;
		this.direccion = direccion;
		this.detallesMedicos = detallesMedicos;
		this.entradas = entradas;
		this.pago = pago;
	}
	public Clientes(String nombre, String apellido, char sexo, int edad, long numeroTel, String direccion,
			ArrayList<String> detallesMedicos, ArrayList<String> entradas) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.edad = edad;
		this.numeroTel = numeroTel;
		this.direccion = direccion;
		this.detallesMedicos = detallesMedicos;
	}

	public Clientes(String nombrex, String apellidox, char sexox, int edadx, long numTelx, String direccionx,
			ArrayList<String> detallesMedicosx) {
		super();
		this.nombre = nombrex;
		this.apellido = apellidox;
		this.sexo = sexox;
		this.edad = edadx;
		this.numeroTel = numTelx;
		this.direccion = direccionx;
		this.detallesMedicos = detallesMedicosx;
	}

	//Getters y Setters
	public ArrayList<Entradas> getEntradas() {
		return entradas;
	}

	public void setEntradas(ArrayList<Entradas> entradas) {
		this.entradas = entradas;
	}

	public PagoCliente getPago() {
		return pago;
	}

	public void setPago(PagoCliente pago) {
		this.pago = pago;
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

	public long getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(long numeroTel) {
		this.numeroTel = numeroTel;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public ArrayList<String> getDetallesMedicos() {
		return detallesMedicos;
	}

	public void setDetallesMedicos(ArrayList<String> detallesMedicos) {
		this.detallesMedicos = detallesMedicos;
	}
	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	public String getOcupacion() {
		return Ocupacion;
	}
	public void setOcupacion(String ocupacion) {
		Ocupacion = ocupacion;
	}
	
	//toStrings
	public String toStringMedicos() {
		for (String string : detallesMedicos) {
			toStringMedicos += string + "_";
		}
		return toStringMedicos;
	}

	public String toStringPagos(PagoCliente pagox) {
		if (pagox == null) {
			return "_";
		} else {
			return pagox.toString();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		return true;
	}

	public void altaEntrada(Entradas x) {
		System.out.println(x.toString());
		entradas.add(x);
	}
	public int getUltimaEntrada() {
		return entradas.size()-1;
	}

}
