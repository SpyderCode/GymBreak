package Gym;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class ModificarCliente extends JPanel {
	public ModificarCliente(GymBreak g) {
		setBackground(Color.WHITE);
		setLayout(null);
		
				JPanel MainPanel = new JPanel();
				MainPanel.setBackground(Color.WHITE);
				MainPanel.setBounds(0, 0, 933, 447);
				add(MainPanel);
				MainPanel.setLayout(null);
				
				JLabel BackGround = new JLabel((String) null);
				BackGround.setBounds(0, -216, 933, 447);
				MainPanel.add(BackGround);
				BackGround.setIcon(new ImageIcon(ModificarCliente.class.getResource("/Logos/131754-red-and-white-polygon-abstract-background.jpg")));
				BackGround.setFont(new Font("Tahoma", Font.PLAIN, 99));
				BackGround.setForeground(Color.RED);
	}
}
