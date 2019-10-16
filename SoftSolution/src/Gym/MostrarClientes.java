package Gym;

import java.awt.Color;

import javax.swing.JPanel;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MostrarClientes extends JPanel {
	public GymBreak principal;
	private JTextField txtNumTel;
	Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
	private JTable tabledatos;

	public MostrarClientes(GymBreak padre) {
		principal = padre;
		setBackground(Color.WHITE);
		setLayout(null);

		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(Color.WHITE);
		MainPanel.setBounds(0, 0, 933, 447);
		add(MainPanel);
		MainPanel.setLayout(null);

		JLabel label = new JLabel("Numero Telefonico");
		label.setFont(new Font("Tahoma", Font.PLAIN, 29));
		label.setBounds(12, 13, 240, 41);
		MainPanel.add(label);

		txtNumTel = new JTextField();
		txtNumTel.setColumns(10);
		txtNumTel.setBounds(264, 26, 340, 28);
		MainPanel.add(txtNumTel);

		JScrollPane scrollPaneClientes = new JScrollPane();
		tabledatos = new JTable();
		scrollPaneClientes.setViewportView(tabledatos);

		JButton btnBuscarCliente = new JButton("Buscar Cliente");
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String[] encabezado = { "NumTel", "Nombre", "Apellido", "Sexo", "Edad", "Dir" };
					Object datos[][] = new Object[principal.lista.clientes.size()][];

					int renglon = 0;
					long NumTelx = Long.parseLong(txtNumTel.getText());
					int pos = principal.lista.buscarPosCliente(NumTelx);

					for (int i = pos; i < principal.lista.clientes.size(); i++) {
						datos[renglon] = new Object[6];
						// Numero de telefono
						datos[renglon][0] = principal.lista.clientes.get(i).getNumeroTel();
						// Nombre
						datos[renglon][1] = principal.lista.clientes.get(i).getNombre();
						// Apellido(s)
						datos[renglon][2] = principal.lista.clientes.get(i).getApellido();
						// Sexo
						datos[renglon][3] = principal.lista.clientes.get(i).getSexo();
						// Edad
						datos[renglon][4] = principal.lista.clientes.get(i).getEdad();
						// Dirrecion
						datos[renglon][5] = principal.lista.clientes.get(i).getDireccion();
						renglon++;
					}
					DefaultTableModel modelo = new DefaultTableModel(datos, encabezado);
					tabledatos.setModel(modelo);

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBuscarCliente.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnBuscarCliente.setForeground(Color.BLACK);
		btnBuscarCliente.setBackground(Color.WHITE);
		btnBuscarCliente.setBounds(12, 73, 168, 33);
		MainPanel.add(btnBuscarCliente);

		JScrollPane scrollpaneEntradas = new JScrollPane();
		scrollpaneEntradas.setBounds(710, 306, 211, 128);
		scrollpaneEntradas.getViewport().setBackground(Color.WHITE);
		MainPanel.add(scrollpaneEntradas);

		JLabel lblEntradas = new JLabel("Entradas");
		lblEntradas.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEntradas.setBounds(710, 277, 124, 28);
		MainPanel.add(lblEntradas);

		// ScrollPaneClientes
		scrollPaneClientes.setBounds(12, 152, 686, 282);
		scrollPaneClientes.getViewport().setBackground(Color.WHITE);
		MainPanel.add(scrollPaneClientes);

		JLabel lblDiasParaPagar = new JLabel("Dias para pagar");
		lblDiasParaPagar.setForeground(Color.BLACK);
		lblDiasParaPagar.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDiasParaPagar.setBounds(776, 25, 157, 25);
		MainPanel.add(lblDiasParaPagar);

		JLabel lblDiasFaltantes = new JLabel("");
		lblDiasFaltantes.setForeground(Color.BLACK);
		lblDiasFaltantes.setBackground(Color.WHITE);
		lblDiasFaltantes.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDiasFaltantes.setBounds(630, 46, 135, 28);
		lblDiasFaltantes.setBorder(border);
		MainPanel.add(lblDiasFaltantes);

		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblClientes.setBounds(12, 119, 124, 28);
		MainPanel.add(lblClientes);

		JLabel lblFechaDeUltimo = new JLabel("Ultimo Pago");
		lblFechaDeUltimo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblFechaDeUltimo.setBounds(630, 23, 157, 28);
		MainPanel.add(lblFechaDeUltimo);

		JLabel lblUltimoPago = new JLabel("");
		lblUltimoPago.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblUltimoPago.setBounds(776, 46, 135, 28);
		lblUltimoPago.setBorder(border);
		MainPanel.add(lblUltimoPago);

		JLabel lblProbmedicos = new JLabel("ProbMedicos");
		lblProbmedicos.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblProbmedicos.setBounds(710, 97, 124, 28);
		MainPanel.add(lblProbmedicos);

		JScrollPane scrollpaneMedicos = new JScrollPane();
		scrollpaneMedicos.setBounds(710, 136, 190, 128);
		scrollpaneMedicos.getViewport().setBackground(Color.WHITE);
		MainPanel.add(scrollpaneMedicos);

		JButton btnActualizarTabla = new JButton("Actualizar Tabla");
		btnActualizarTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actualizar();
			}
		});
		btnActualizarTabla.setForeground(Color.BLACK);
		btnActualizarTabla.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnActualizarTabla.setBackground(Color.WHITE);
		btnActualizarTabla.setBounds(248, 73, 168, 33);
		MainPanel.add(btnActualizarTabla);

		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(MostrarClientes.class.getResource("/Logos/RedCircle.jpg")));
		lblBackground.setBounds(-313, 0, 931, 933);
		MainPanel.add(lblBackground);

	}

	private void actualizar() {
		String[] encabezado = { "NumTel", "Nombre", "Apellido", "Sexo", "Edad", "Dir" };
		Object datos[][] = new Object[principal.lista.clientes.size()][];
		int renglon = 0;

		for (Clientes x : principal.lista.clientes) {
			datos[renglon] = new Object[6];
			// Numero de telefono
			datos[renglon][0] = x.getNumeroTel();
			// Nombre
			datos[renglon][1] = x.getNombre();
			// Apellido(s)
			datos[renglon][2] = x.getApellido();
			// Sexo
			datos[renglon][3] = x.getSexo();
			// Edad
			datos[renglon][4] = x.getEdad();
			// Dirrecion
			datos[renglon][5] = x.getDireccion();
			renglon++;
		}

		DefaultTableModel modelo = new DefaultTableModel(datos, encabezado);
		tabledatos.setModel(modelo);
	}
}
