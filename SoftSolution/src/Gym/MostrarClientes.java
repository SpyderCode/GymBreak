package Gym;

import java.awt.Color;

import javax.swing.JPanel;

public class MostrarClientes extends JPanel{
	public MostrarClientes() {
		setBackground(Color.WHITE);
		setLayout(null);

		JPanel MainPanel = new JPanel();
		MainPanel.setBounds(0, 0, 933, 447);
		add(MainPanel);
		MainPanel.setLayout(null);
	}

}
