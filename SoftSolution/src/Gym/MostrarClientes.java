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
import javax.swing.JViewport;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class MostrarClientes extends JPanel {
	public GymBreak principal;
	private JTextField txtNumTel;
	private JTable tabledatos;
	private JLabel lblProbmedicos;
	private JTextArea ProbMedicos;
	Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
	private int posx;
	private Long NumTely;
	int textSize=18;

	public MostrarClientes(GymBreak padre) {
		principal = padre;
		setBackground(Color.WHITE);
		setLayout(null);

		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(Color.WHITE);
		MainPanel.setBounds(0, 0, 1137, 548);
		add(MainPanel);
		MainPanel.setLayout(null);

		JLabel label = new JLabel("Numero Telefonico");
		label.setFont(new Font("Tahoma", Font.PLAIN, 33));
		label.setBounds(12, 24, 286, 41);
		MainPanel.add(label);

		txtNumTel = new JTextField();
		txtNumTel.setFont(new Font("Tahoma", Font.PLAIN, textSize));
		txtNumTel.setBorder(border);
		txtNumTel.setColumns(10);
		txtNumTel.setBounds(310, 24, 378, 33);
		MainPanel.add(txtNumTel);

		JScrollPane scrollPaneClientes = new JScrollPane();
		scrollPaneClientes.setBorder(border);
		tabledatos = new JTable();
		tabledatos.setFont(new Font("Tahoma", Font.PLAIN, textSize));
		tabledatos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {

					if (e.getClickCount() == 1) {
						final JTable jTable = (JTable) e.getSource();
						final int row = jTable.getSelectedRow();
						
						NumTely = (Long) jTable.getValueAt(row, 0);
						posx = principal.lista.buscarPosCliente(NumTely);
						
						System.out.println(NumTely);
						String detallesMedicosx = "";
						for (int i = 0; i < principal.lista.clientes.get(posx).getDetallesMedicos().size(); i++) {
							detallesMedicosx = detallesMedicosx
									+ principal.lista.clientes.get(posx).getDetallesMedicos().get(i) + "\n";
						}

						ProbMedicos.setText(detallesMedicosx);

					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
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
		btnBuscarCliente.setBounds(12, 78, 168, 33);
		MainPanel.add(btnBuscarCliente);

		JScrollPane scrollpaneEntradas = new JScrollPane();
		scrollpaneEntradas.setBorder(border);
		scrollpaneEntradas.setBounds(833, 370, 278, 165);
		scrollpaneEntradas.getViewport().setBackground(Color.WHITE);
		MainPanel.add(scrollpaneEntradas);

		JLabel lblEntradas = new JLabel("Entradas");
		lblEntradas.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEntradas.setBounds(833, 343, 124, 28);
		MainPanel.add(lblEntradas);

		// ScrollPaneClientes
		scrollPaneClientes.setBounds(12, 159, 785, 376);
		scrollPaneClientes.getViewport().setBackground(Color.WHITE);
		MainPanel.add(scrollPaneClientes);

		JLabel lblDiasParaPagar = new JLabel("Dias para pagar");
		lblDiasParaPagar.setForeground(Color.BLACK);
		lblDiasParaPagar.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDiasParaPagar.setBounds(954, 15, 157, 25);
		MainPanel.add(lblDiasParaPagar);

		JLabel lblDiasFaltantes = new JLabel("");
		lblDiasFaltantes.setForeground(Color.BLACK);
		lblDiasFaltantes.setBackground(Color.WHITE);
		lblDiasFaltantes.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDiasFaltantes.setBounds(808, 48, 135, 28);
		lblDiasFaltantes.setBorder(border);
		MainPanel.add(lblDiasFaltantes);

		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblClientes.setBounds(12, 124, 124, 28);
		MainPanel.add(lblClientes);

		JLabel lblFechaDeUltimo = new JLabel("Ultimo Pago");
		lblFechaDeUltimo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblFechaDeUltimo.setBounds(808, 13, 157, 28);
		MainPanel.add(lblFechaDeUltimo);

		JLabel lblUltimoPago = new JLabel("");
		lblUltimoPago.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblUltimoPago.setBounds(954, 48, 135, 28);
		lblUltimoPago.setBorder(border);
		MainPanel.add(lblUltimoPago);

		lblProbmedicos = new JLabel("ProbMedicos");
		lblProbmedicos.setBackground(Color.WHITE);
		lblProbmedicos.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblProbmedicos.setBounds(833, 124, 124, 28);
		MainPanel.add(lblProbmedicos);

		JButton btnActualizarTabla = new JButton("Actualizar Tabla");
		btnActualizarTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actualizar();
			}
		});
		btnActualizarTabla.setForeground(Color.BLACK);
		btnActualizarTabla.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnActualizarTabla.setBackground(Color.WHITE);
		btnActualizarTabla.setBounds(230, 78, 168, 33);
		MainPanel.add(btnActualizarTabla);
		lblProbmedicos.setOpaque(true);

		ProbMedicos = new JTextArea();
		ProbMedicos.setFont(new Font("Tahoma", Font.PLAIN, textSize));
		ProbMedicos.setBounds(833, 159, 278, 171);
		ProbMedicos.setBorder(border);
		MainPanel.add(ProbMedicos);

		JButton btnEleminarCliente = new JButton("Eleminar CLiente");
		btnEleminarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO eleminar cliente con NumTely
				try {
					principal.lista.eleminarClientes(NumTely);
					JOptionPane.showMessageDialog(null, "Cliente borrado con Exito", "Exito",
							JOptionPane.DEFAULT_OPTION);
					ProbMedicos.setText(null);
					actualizar();
					principal.save();

				} catch (NullPointerException ex) {
					JOptionPane.showMessageDialog(null, "Error: Selecciona a una persona con el mouse", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEleminarCliente.setForeground(Color.BLACK);
		btnEleminarCliente.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnEleminarCliente.setBackground(Color.WHITE);
		btnEleminarCliente.setBounds(455, 78, 180, 33);
		MainPanel.add(btnEleminarCliente);

		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(MostrarClientes.class.getResource("/Logos/RedCircle.jpg")));
		lblBackground.setBounds(120, 0, 931, 933);
		MainPanel.add(lblBackground);
		actualizar();
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
			// Sexo UwU
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
