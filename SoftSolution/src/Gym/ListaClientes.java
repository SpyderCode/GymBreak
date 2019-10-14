package Gym;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ListaClientes {
	public ArrayList<Clientes> clientes = new ArrayList<Clientes>();

	public void altaClientes(Clientes e) {
		// Primero busca a ver si existe el cliente
		if (buscarPosCliente(e.getNumeroTel()) == -1) {
			clientes.add(e);
			JOptionPane.showMessageDialog(null, "Cliente dado de alta", "Exito", JOptionPane.INFORMATION_MESSAGE);
		} else { //Como cada numero telefonico es unico, 
			JOptionPane.showMessageDialog(null, "Este numero telefonico ya esta registrado a un cliente", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public void eleminarClientes(String numTel) {
		int pos = buscarPosCliente(numTel);
		if (pos >= 0)
			clientes.remove(pos);
		else
			JOptionPane.showMessageDialog(null, "No existe este numero de telefono, cheque que este bien escrito",
					"Error", JOptionPane.ERROR_MESSAGE);
	}

	public int buscarPosCliente(String numTel) {
		int pos = -1;
		int i = 0;
		for (Clientes e : clientes) {
			if (e.equals(numTel)) {
				pos = i;
				break;
			}
			i++;
		}
		return pos;
	}
}
