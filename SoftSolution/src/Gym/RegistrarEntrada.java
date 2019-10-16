package Gym;

import java.awt.Color;

import javax.swing.JPanel;

public class RegistrarEntrada extends JPanel{
	public RegistrarEntrada(GymBreak g) {
		setBackground(Color.WHITE);
		setLayout(null);

		JPanel MainPanel = new JPanel();
		MainPanel.setBounds(0, 0, 933, 447);
		add(MainPanel);
		MainPanel.setLayout(null);
	}

}
