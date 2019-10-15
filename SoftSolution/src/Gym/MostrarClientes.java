package Gym;

import java.awt.Color;

import javax.swing.JPanel;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class MostrarClientes extends JPanel{
	private JTextField textField;
	Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
	
	public MostrarClientes() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(Color.WHITE);
		MainPanel.setBounds(0, 0, 933, 447);
		add(MainPanel);
		MainPanel.setLayout(null);
		
		JLabel label = new JLabel("Numero Telefonico");
		label.setFont(new Font("Tahoma", Font.PLAIN, 29));
		label.setBounds(12, 13, 592, 41);
		MainPanel.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(264, 26, 340, 28);
		MainPanel.add(textField);
		
		JButton btnBuscarCliente = new JButton("Buscar Cliente");
		btnBuscarCliente.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnBuscarCliente.setForeground(Color.BLACK);
		btnBuscarCliente.setBackground(Color.WHITE);
		btnBuscarCliente.setBounds(12, 73, 168, 33);
		MainPanel.add(btnBuscarCliente);
		
		JScrollPane scrollpaneEntradas = new JScrollPane();
		scrollpaneEntradas.setBounds(538, 152, 211, 282);
		scrollpaneEntradas.getViewport().setBackground(Color.WHITE);
		MainPanel.add(scrollpaneEntradas);
		
		JLabel lblEntradas = new JLabel("Entradas");
		lblEntradas.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEntradas.setBounds(538, 123, 124, 28);
		MainPanel.add(lblEntradas);
		
		JScrollPane scrollPaneClientes = new JScrollPane();
		scrollPaneClientes.setBounds(12, 152, 484, 282);
		scrollPaneClientes.getViewport().setBackground(Color.WHITE);
		MainPanel.add(scrollPaneClientes);
		
		JLabel lblDiasParaPagar = new JLabel("Dias para pagar");
		lblDiasParaPagar.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDiasParaPagar.setBounds(764, 123, 157, 25);
		MainPanel.add(lblDiasParaPagar);
		
		JLabel lblDiasFaltantes = new JLabel("");
		lblDiasFaltantes.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDiasFaltantes.setBounds(761, 153, 135, 28);
		lblDiasFaltantes.setBorder(border);
		MainPanel.add(lblDiasFaltantes);
		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblClientes.setBounds(12, 119, 124, 28);
		MainPanel.add(lblClientes);
		
		JLabel lblFechaDeUltimo = new JLabel("Ultimo Pago");
		lblFechaDeUltimo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblFechaDeUltimo.setBounds(764, 206, 157, 28);
		MainPanel.add(lblFechaDeUltimo);
		
		JLabel lblUltimoPago = new JLabel("");
		lblUltimoPago.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblUltimoPago.setBounds(761, 247, 135, 28);
		lblUltimoPago.setBorder(border);
		MainPanel.add(lblUltimoPago);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(MostrarClientes.class.getResource("/Logos/RedCircle.jpg")));
		lblBackground.setBounds(315, 0, 798, 925);
		MainPanel.add(lblBackground);
	}
}
