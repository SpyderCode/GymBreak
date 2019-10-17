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
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class AñadirCliente extends JPanel {
	public GymBreak principal;
	private JTextField txtNumTel;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEdad;
	private JTextField txtDireccion;
	private JTextArea txtProbMedicos;

	public AñadirCliente(GymBreak padre) {
		principal = padre;
		setBackground(Color.WHITE);
		setLayout(null);

		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(Color.WHITE);
		MainPanel.setBounds(0, 0, 933, 447);
		add(MainPanel);
		MainPanel.setLayout(null);

		JLabel lblNumeroTel = new JLabel("Numero Telefonico");
		lblNumeroTel.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNumeroTel.setBounds(12, 13, 267, 41);
		MainPanel.add(lblNumeroTel);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNombre.setBounds(12, 78, 100, 35);
		MainPanel.add(lblNombre);

		JLabel lblApellidos = new JLabel("Apellido(s)");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblApellidos.setBounds(329, 75, 184, 41);
		MainPanel.add(lblApellidos);

		JLabel lblNewLabel = new JLabel("Sexo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel.setBounds(203, 136, 114, 41);
		MainPanel.add(lblNewLabel);

		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblEdad.setBounds(12, 136, 68, 41);
		MainPanel.add(lblEdad);

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblDireccion.setBounds(12, 190, 124, 41);
		MainPanel.add(lblDireccion);

		JLabel lblProblemasMedicos = new JLabel("Problemas Medicos");
		lblProblemasMedicos.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblProblemasMedicos.setBounds(12, 257, 250, 47);
		MainPanel.add(lblProblemasMedicos);

		txtNumTel = new JTextField();
		txtNumTel.setBounds(264, 26, 405, 25);
		MainPanel.add(txtNumTel);
		txtNumTel.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(124, 88, 193, 25);
		MainPanel.add(txtNombre);

		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(476, 88, 193, 25);
		MainPanel.add(txtApellido);

		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(81, 145, 114, 25);
		MainPanel.add(txtEdad);

		ButtonGroup sexo = new ButtonGroup();
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setFont(new Font("Tahoma", Font.PLAIN, 19));
		rdbtnMasculino.setBackground(Color.WHITE);
		rdbtnMasculino.setBounds(271, 148, 124, 25);
		sexo.add(rdbtnMasculino);
		MainPanel.add(rdbtnMasculino);

		JRadioButton rdbtnFemenino = new JRadioButton("Femenino");
		rdbtnFemenino.setFont(new Font("Tahoma", Font.PLAIN, 19));
		rdbtnFemenino.setBackground(Color.WHITE);
		rdbtnFemenino.setBounds(399, 148, 124, 25);
		sexo.add(rdbtnFemenino);
		MainPanel.add(rdbtnFemenino);

		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(141, 206, 528, 25);
		MainPanel.add(txtDireccion);

		txtProbMedicos = new JTextArea();
		txtProbMedicos.setLineWrap(true);
		txtProbMedicos.setForeground(Color.BLACK);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		txtProbMedicos
				.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		txtProbMedicos.setBounds(280, 257, 389, 165);
		MainPanel.add(txtProbMedicos);
		txtProbMedicos.setColumns(100);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(715, 409, 97, 25);
		MainPanel.add(btnCancelar);

		JButton btnAceptra = new JButton("Aceptar");
		btnAceptra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					// Inicializa y obtiene los datos de cada caja
					long NumTelx = Long.parseLong(txtNumTel.getText());
					String nombrex = txtNombre.getText();
					String Apellidox = txtApellido.getText();
					char sexox = 'M';

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
							DetallesMedicosx, null);
					clientex.toStringMedicos(DetallesMedicosx);

					// Lo añade a la lista principal
					System.out.println("Añadir cliente before");
					padre.lista.altaClientes(clientex);
					padre.save();

					// Debug
					System.out.println("Cliente añadido a lista");
					// Bora las cajas de texto
					txtApellido.setText(null);
					txtDireccion.setText(null);
					txtEdad.setText(null);
					txtNombre.setText(null);
					txtNumTel.setText(null);
					txtProbMedicos.setText(null);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null,
							"Error: No se permite letras en el numero de telefono\nni en la edad.", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAceptra.setBounds(824, 409, 97, 25);
		MainPanel.add(btnAceptra);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AñadirCliente.class.getResource("/Logos/Logo_White.jpeg")));
		label.setBounds(708, 0, 466, 448);
		MainPanel.add(label);
	}
}
