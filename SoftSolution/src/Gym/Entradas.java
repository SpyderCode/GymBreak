package Gym;

import java.text.SimpleDateFormat;
import java.time.LocalTime;

public class Entradas {
	SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
	//Atributos
	private String Fecha;
	LocalTime Hora = LocalTime.now();
	public Entradas(String fecha, LocalTime hora) {
		super();
		Fecha = fecha;
		Hora = hora;
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
	
}
