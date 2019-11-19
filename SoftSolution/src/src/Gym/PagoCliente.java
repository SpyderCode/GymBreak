package Gym;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PagoCliente implements Serializable{
	LocalDate pago;//Dia
	int meses;//Mensualidad
	LocalDate hoy=LocalDate.now();

	public PagoCliente(LocalDate pago, int meses) {
		super();
		this.pago = pago;
		this.meses = meses;
	}

	public LocalDate getPago() {
		return pago;
	}

	public void setPago(LocalDate pago) {
		this.pago = pago;
	}

	public int getMeses() {
		return meses;
	}

	public void setMeses(int meses) {
		this.meses = meses;
	}

	public int diasFaltantes() {
		//Toma el tiempo en dias entre hoy y el dia final
		LocalDate endDate = pago.plusMonths(meses);
		return (int) ChronoUnit.DAYS.between(LocalDate.now(), endDate);
		
	}

	@Override
	public String toString() {
		return "" + pago + "_" + meses + "";
	}
	
	

}
