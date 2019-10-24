package Gym;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class A�adirCliente extends JPanel {
	public GymBreak principal;
	private JTextField txtNumTel;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEdad;
	private JTextField txtDireccion;
	private JTextArea txtProbMedicos;
	int textSize=18;

	public A�adirCliente(GymBreak padre) {
		principal = padre;
		setBackground(Color.WHITE);
		setLayout(null);

		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(Color.WHITE);
		MainPanel.setBounds(0, 0,1137, 548);
		add(MainPanel);
		MainPanel.setLayout(null);

		JLabel lblNumeroTel = new JLabel("Numero Telefonico");
		lblNumeroTel.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblNumeroTel.setBounds(12, 222, 277, 41);
		MainPanel.add(lblNumeroTel);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblNombre.setBounds(12, 25, 133, 38);
		MainPanel.add(lblNombre);

		JLabel lblApellidos = new JLabel("Apellido(s)");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblApellidos.setBounds(389, 25, 184, 41);
		MainPanel.add(lblApellidos);

		JLabel lblNewLabel = new JLabel("Sexo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblNewLabel.setBounds(358, 91, 69, 41);
		MainPanel.add(lblNewLabel);

		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblEdad.setBounds(12, 91, 100, 41);
		MainPanel.add(lblEdad);

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblDireccion.setBounds(12, 145, 183, 64);
		MainPanel.add(lblDireccion);

		JLabel lblProblemasMedicos = new JLabel("Problemas Medicos");
		lblProblemasMedicos.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblProblemasMedicos.setBounds(12, 290, 277, 64);
		MainPanel.add(lblProblemasMedicos);

		txtNumTel = new JTextField();
		txtNumTel.setFont(new Font("Tohoma",Font.PLAIN,textSize));
		txtNumTel.setBounds(301, 228, 549, 35);
		MainPanel.add(txtNumTel);
		txtNumTel.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, textSize));
		txtNombre.setColumns(10);
		txtNombre.setBounds(147, 31, 230, 35);
		MainPanel.add(txtNombre);

		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Tohoma",Font.PLAIN,textSize));
		txtApellido.setColumns(10);
		txtApellido.setBounds(573, 31, 277, 35);
		MainPanel.add(txtApellido);

		txtEdad = new JTextField();
		txtEdad.setFont(new Font("Tohoma",Font.PLAIN,textSize));
		txtEdad.setColumns(10);
		txtEdad.setBounds(113, 100, 176, 32);
		MainPanel.add(txtEdad);

		ButtonGroup sexo = new ButtonGroup();
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setFont(new Font("Tahoma", Font.PLAIN, 24));
		rdbtnMasculino.setBackground(Color.WHITE);
		rdbtnMasculino.setBounds(449, 100, 155, 29);
		sexo.add(rdbtnMasculino);
		MainPanel.add(rdbtnMasculino);

		JRadioButton rdbtnFemenino = new JRadioButton("Femenino");
		rdbtnFemenino.setFont(new Font("Tahoma", Font.PLAIN, 24));
		rdbtnFemenino.setBackground(Color.WHITE);
		rdbtnFemenino.setBounds(612, 98, 167, 32);
		sexo.add(rdbtnFemenino);
		MainPanel.add(rdbtnFemenino);

		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Tohoma",Font.PLAIN,textSize));
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(301, 169, 549, 35);
		MainPanel.add(txtDireccion);

		txtProbMedicos = new JTextArea();
		txtProbMedicos.setFont(new Font("Tohoma",Font.PLAIN,textSize));
		txtProbMedicos.setLineWrap(true);
		txtProbMedicos.setForeground(Color.BLACK);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		txtProbMedicos
				.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		txtProbMedicos.setBounds(301, 300, 549, 223);
		MainPanel.add(txtProbMedicos);
		txtProbMedicos.setColumns(100);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Borra las cajas
				borrarCajas();
			}
		});
		btnCancelar.setBounds(892, 496, 114, 39);
		MainPanel.add(btnCancelar);

		JButton btnAceptra = new JButton("Aceptar");
		btnAceptra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					// Inicializa y obtiene los datos de cada caja
					long NumTelx = Long.parseLong(txtNumTel.getText());
					String nombrex = txtNombre.getText();
					String Apellidox = txtApellido.getText();
					char sexox = 'M';//Male by default

					// Sets si es masculino o femenino
					if (rdbtnFemenino.isSelected())
						sexox = 'F';
					if (rdbtnMasculino.isSelected())
						sexox = 'M';

					int edadx = Integer.parseInt(txtEdad.getText());
					String direccionx = txtDireccion.getText();

					String s[] = txtProbMedicos.getText().split("\\r?\\n");
					ArrayList<String> DetallesMedicosx = new ArrayList<>(Arrays.asList(s));

					// Crea el cliente
					Clientes clientex = new Clientes(nombrex, Apellidox, sexox, edadx, NumTelx, direccionx,
							DetallesMedicosx);
					clientex.toStringMedicos();

					// Lo a�ade a la lista principal
					System.out.println("A�adir cliente before");
					padre.lista.altaClientes(clientex);
					padre.save();

					// Debug
					System.out.println("Cliente a�adido a lista");
					// Bora las cajas de texto
					borrarCajas();
			
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null,
							"Error: No se permite letras en el numero de telefono\nni en la edad.", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnAceptra.setBounds(1011, 496, 114, 39);
		MainPanel.add(btnAceptra);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(A�adirCliente.class.getResource("/Logos/Logo_White.jpeg")));
		label.setBounds(909, 0, 466, 448);
		MainPanel.add(label);
	}

	protected void borrarCajas() {
		txtApellido.setText(null);
		txtDireccion.setText(null);
		txtEdad.setText(null);
		txtNombre.setText(null);
		txtNumTel.setText(null);
		txtProbMedicos.setText(null);
		
	}
}
