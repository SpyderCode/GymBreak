package Gym;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JButton;
import com.toedter.calendar.JMonthChooser;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegistrarEntrada extends JPanel {

	public GymBreak principal;
	public JTextField txtNumTel;

	LocalDate Hoy;
	LocalTime Hora;

	Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
	int textSize = 18;
	int posx;

	public RegistrarEntrada(GymBreak padre) {
		principal = padre;
		setBackground(Color.WHITE);
		setLayout(null);

		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(Color.WHITE);
		MainPanel.setBounds(0, 0, 1068, 488);
		add(MainPanel);
		MainPanel.setLayout(null);

		JLabel lblNumeroTelefonico = new JLabel("Numero Telefonico");
		lblNumeroTelefonico.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNumeroTelefonico.setBounds(12, 13, 246, 33);
		MainPanel.add(lblNumeroTelefonico);

		txtNumTel = new JTextField();
		txtNumTel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || (ke.getKeyCode() == KeyEvent.VK_BACK_SPACE)
						|| (ke.getKeyCode() == KeyEvent.VK_DELETE)) {
					txtNumTel.setEditable(true);
				} else {
					txtNumTel.setEditable(false);

				}
			}
		});
		txtNumTel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNumTel.setBounds(259, 19, 404, 33);
		MainPanel.add(txtNumTel);
		txtNumTel.setDocument(new JTextLimit(10));
		txtNumTel.setColumns(10);

		JPanel DatosPanel = new JPanel();
		DatosPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos", TitledBorder.LEADING,
				TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 20), Color.BLACK));
		DatosPanel.setOpaque(false);
		DatosPanel.setBounds(12, 101, 527, 434);
		DatosPanel.setLayout(null);
		MainPanel.add(DatosPanel);
		
		JLabel OcupacionLabel = new JLabel("Ocupacion");
		OcupacionLabel.setFont(new Font("Tahoma", Font.PLAIN, 33));
		OcupacionLabel.setBounds(12, 78, 172, 38);
		DatosPanel.add(OcupacionLabel);
		
		JLabel txtOcupacion = new JLabel("");
		txtOcupacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtOcupacion.setBorder(border);
		txtOcupacion.setBounds(196, 78, 277, 38);
		DatosPanel.add(txtOcupacion);

		JLabel Nombrelbl = new JLabel("Nombre");
		Nombrelbl.setFont(new Font("Tahoma", Font.PLAIN, 33));
		Nombrelbl.setBounds(12, 24, 133, 38);
		DatosPanel.add(Nombrelbl);

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
		ProbMedicotxt.setBounds(12, 232, 461, 143);
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

		JLabel lblDiaDeHoy = new JLabel("Dia de Hoy");
		lblDiaDeHoy.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblDiaDeHoy.setBounds(565, 108, 165, 38);
		MainPanel.add(lblDiaDeHoy);

		JTextField Fechatxt = new JTextField();
		Fechatxt.setFont(new Font("Tahoma", Font.PLAIN, textSize));
		Fechatxt.setBounds(742, 108, 241, 38);
		Fechatxt.setBorder(border);
		Fechatxt.setText("" + LocalDate.now());
		MainPanel.add(Fechatxt);

		JLabel lblHora = new JLabel("Hora");
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblHora.setBounds(565, 167, 165, 38);
		MainPanel.add(lblHora);

		JTextField Horatxt = new JTextField();
		Horatxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Horatxt.setBorder(border);
		Horatxt.setBounds(742, 167, 241, 38);
		Horatxt.setText("" + LocalTime.now());
		MainPanel.add(Horatxt);

		JLabel lblDiasParaPagar = new JLabel("Dias para Pagar");
		lblDiasParaPagar.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblDiasParaPagar.setBounds(565, 259, 274, 38);
		MainPanel.add(lblDiasParaPagar);

		JLabel DiasFalttxt = new JLabel("");
		DiasFalttxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		DiasFalttxt.setBorder(border);
		DiasFalttxt.setBounds(855, 259, 128, 38);
		MainPanel.add(DiasFalttxt);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					// Obtiene posicion del cliente
					long telNumx = Long.parseLong(txtNumTel.getText());
					posx = principal.lista.buscarPosCliente(telNumx);

					// La caja de problema medica
					String detallesMedicosx = "";
					for (int i = 0; i < principal.lista.clientes.get(posx).getDetallesMedicos().size(); i++) {
						detallesMedicosx = detallesMedicosx
								+ principal.lista.clientes.get(posx).getDetallesMedicos().get(i) + "\n";
					}

					// Sets datos en la caja de datos
					Nombretxt.setText(getCliente(posx).getNombre()+" "+getCliente(posx).getApellido());
					txtOcupacion.setText(""+getCliente(posx).getOcupacion());
					Edadtxt.setText("" + getCliente(posx).getEdad());
					Sexotxt.setText("" + getCliente(posx).getSexo());
					ProbMedicotxt.setText(detallesMedicosx);
					Horatxt.setText(""+LocalTime.now());

					// if else para no obtener errores
					if (getCliente(posx).getPago() == null) {// Si no tiene pagos, no pasa nada

					} else {// Si si,obtiene los dias faltantes
						DiasFalttxt.setText("" + getCliente(posx).getPago().diasFaltantes());
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Error: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
				} catch (ArrayIndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(null, "Cliente no existe o el numero telefonico esta mal escrito",
							"ERROR", JOptionPane.ERROR_MESSAGE);
				}

			}

			private Clientes getCliente(int posx) {
				return principal.lista.clientes.get(posx);
			}
		});
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBuscar.setBounds(12, 55, 123, 33);
		MainPanel.add(btnBuscar);

		JButton EntradaBtn = new JButton("Dar Entrada");
		EntradaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					// Obtiene posicion
					long telNumx = Long.parseLong(txtNumTel.getText());
					int posy = principal.lista.buscarPosCliente(telNumx);

					// Crea una nueva entrada y se le añade al cliente
					Entradas entradayeet = new Entradas();
					entradayeet.setFecha("" + LocalDate.now());
					entradayeet.setHora(LocalTime.now());
					principal.lista.clientes.get(posy).altaEntrada(entradayeet);

					// Muestra un mensaje dando a entender la hora y tiempo de entrada al cliente
					JOptionPane.showMessageDialog(null,
							"Dado de Alta la entrada\nFecha: " + LocalDate.now() + "\nHora: " + LocalTime.now(),
							"Exito", JOptionPane.DEFAULT_OPTION);

					principal.save();// Guarda todo
					cleartext();// Borra las cajas
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Error: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
				} catch (HeadlessException e) {
					JOptionPane.showMessageDialog(null, "Error: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Error: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
				}

			}

			private void cleartext() {// Borra las cajas
				txtNumTel.setText(null);
				txtOcupacion.setText(null);
				DiasFalttxt.setText(null);
				Edadtxt.setText(null);
				Nombretxt.setText(null);
				ProbMedicotxt.setText(null);
				Sexotxt.setText(null);

			}
		});
		EntradaBtn.setBounds(905, 449, 152, 39);
		MainPanel.add(EntradaBtn);

		JLabel BackGround = new JLabel("");
		BackGround.setIcon(new ImageIcon(RegistrarEntrada.class.getResource("/Logos/108287-red-and-white-wave.jpg")));
		BackGround.setBounds(0, 0, 1137, 558);
		MainPanel.add(BackGround);
	}
}
