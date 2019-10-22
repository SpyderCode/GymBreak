package Gym;
//Uncle sam im trying to sneak myself into japan but
//im dummy thicc and the clap of my ass cheeks is
//alerting the nations

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.Font;
import javax.swing.JButton;
import com.toedter.calendar.JMonthChooser;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.awt.event.ActionEvent;

public class RegistrarEntrada extends JPanel{
	private JTextField textField;
	Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
	int textSize=18;
	LocalDate Hoy=LocalDate.now();
	LocalTime Hora=LocalTime.now();	
	
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
		
		JPanel DatosPanel = new JPanel();
		DatosPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 20), Color.BLACK));
		DatosPanel.setOpaque(false);
		DatosPanel.setBounds(12, 101, 527, 434);
		DatosPanel.setLayout(null);
		MainPanel.add(DatosPanel);
		
		JLabel Nombrelbl = new JLabel("Nombre");
		Nombrelbl.setFont(new Font("Tahoma", Font.PLAIN, 33));
		Nombrelbl.setBounds(12, 24, 133, 38);
		DatosPanel.add(Nombrelbl);
		
		JLabel Apellidolbl = new JLabel("Apellido(s)");
		Apellidolbl.setFont(new Font("Tahoma", Font.PLAIN, 33));
		Apellidolbl.setBounds(12, 75, 184, 41);
		DatosPanel.add(Apellidolbl);
		
		JLabel Edadlbl = new JLabel("Edad");
		Edadlbl.setFont(new Font("Tahoma", Font.PLAIN, 33));
		Edadlbl.setBounds(12, 129, 100, 41);
		DatosPanel.add(Edadlbl);
		
		JLabel label_3 = new JLabel("Sexo");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 33));
		label_3.setBounds(296, 129, 69, 41);
		DatosPanel.add(label_3);
		
		JTextArea ProbMedicotxt = new JTextArea();
		ProbMedicotxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ProbMedicotxt.setBorder(border);
		ProbMedicotxt.setBounds(12, 232, 461, 189);
		DatosPanel.add(ProbMedicotxt);
		
		JLabel ProbMedicolbl = new JLabel("Problemas medicos");
		ProbMedicolbl.setFont(new Font("Tahoma", Font.PLAIN, 33));
		ProbMedicolbl.setBounds(12, 183, 314, 41);
		DatosPanel.add(ProbMedicolbl);
		
		JLabel Nombretxt = new JLabel("");
		Nombretxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Nombretxt.setBorder(border);
		Nombretxt.setBounds(196, 24, 277, 38);
		DatosPanel.add(Nombretxt);
		
		JLabel Apellidotxt = new JLabel("");
		Apellidotxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Apellidotxt.setBorder(border);
		Apellidotxt.setBounds(196, 78, 277, 38);
		DatosPanel.add(Apellidotxt);
		
		JLabel Edadtxt = new JLabel("");
		Edadtxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Edadtxt.setBorder(border);
		Edadtxt.setBounds(98, 129, 127, 38);
		DatosPanel.add(Edadtxt);
		
		JLabel Sexotxt = new JLabel("");
		Sexotxt.setBounds(392, 132, 77, 38);
		DatosPanel.add(Sexotxt);
		Sexotxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Sexotxt.setBorder(border);
		
		JButton EntradaBtn = new JButton("Dar de Alta");
		EntradaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		EntradaBtn.setBounds(973, 496, 152, 39);
		MainPanel.add(EntradaBtn);
		
		JLabel lblDiaDeHoy = new JLabel("Dia de Hoy");
		lblDiaDeHoy.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblDiaDeHoy.setBounds(565, 108, 165, 38);
		MainPanel.add(lblDiaDeHoy);
		
		JTextField Fechatxt = new JTextField();
		Fechatxt.setFont(new Font("Tahoma", Font.PLAIN, textSize));
		Fechatxt.setBounds(742, 108, 315, 38);
		Fechatxt.setBorder(border);
		Fechatxt.setText(""+Hoy);
		MainPanel.add(Fechatxt);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblHora.setBounds(565, 167, 165, 38);
		MainPanel.add(lblHora);
		
		JTextField Horatxt = new JTextField();
		Horatxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Horatxt.setBorder(border);
		Horatxt.setBounds(742, 167, 315, 38);
		Horatxt.setText(""+Hora);
		MainPanel.add(Horatxt);
	}
}
