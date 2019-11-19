package Gym;

import java.io.Serializable;
import java.time.LocalTime;

public class Entradas implements Serializable{
	//Atributos
	private String Fecha;
	LocalTime Hora;
	public Entradas(String fecha, LocalTime hora) {
		super();
		Fecha = fecha;
		Hora = hora;
	}
	public Entradas() {
		
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	public LocalTime getHora() {
		return Hora;
	}
	public void setHora(LocalTime hora) {
		Hora = hora;
	}

	public String getStringFecha() {
		return ""+Fecha;
	}
	public String getStringHora() {
		return ""+Hora;
	}
	
}
