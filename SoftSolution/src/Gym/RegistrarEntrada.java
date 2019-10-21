package Gym;
//Uncle sam im trying to sneak myself into japan but
//im dummy thicc and the clap of my ass cheeks is
//alerting the nations

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;

public class RegistrarEntrada extends JPanel{
	private JTextField textField;
	public RegistrarEntrada(GymBreak g) {
		setBackground(Color.WHITE);
		setLayout(null);

		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(Color.WHITE);
		MainPanel.setBounds(0, 0, 1137, 548);
		add(MainPanel);
		MainPanel.setLayout(null);
		
		JLabel lblNumeroTelefonico = new JLabel("Numero Telefonico");
		lblNumeroTelefonico.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNumeroTelefonico.setBounds(12, 13, 246, 33);
		MainPanel.add(lblNumeroTelefonico);
		
		textField = new JTextField();
		textField.setBounds(259, 19, 404, 33);
		MainPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBuscar.setBounds(12, 55, 123, 33);
		MainPanel.add(btnBuscar);
	}
}
