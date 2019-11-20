package Gym;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.HeadlessException;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.time.LocalDate;

import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class MostrarClientes extends JPanel {
	public GymBreak principal;
	public JTextField txtNumTel;
	private JTextArea ProbMedicos;
	private JTable tabledatos;
	private JTable tabledatosEntrada;
	private JLabel lblProbmedicos;
	private JLabel lblUltimoPago;
	private JLabel lblDiasFaltantes;
	Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
	private Long NumTely;
	private int textSize = 18;
	private int posx;

	public MostrarClientes(GymBreak padre) {
		principal = padre;
		setBackground(Color.WHITE);
		setLayout(null);

		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(Color.WHITE);
		MainPanel.setBounds(0, 0, 1068, 488);
		add(MainPanel);
		MainPanel.setLayout(null);

		JLabel Ocupaciontxt = new JLabel("");
		Ocupaciontxt.setFont(new Font("Tahoma", Font.PLAIN, 19));
		Ocupaciontxt.setBorder(border);
		Ocupaciontxt.setBounds(833, 173, 223, 28);
		Ocupaciontxt.setBackground(Color.WHITE);
		MainPanel.add(Ocupaciontxt);

		JLabel OcupacionLabel = new JLabel("Ocupacion");
		OcupacionLabel.setForeground(Color.BLACK);
		OcupacionLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		OcupacionLabel.setBackground(Color.LIGHT_GRAY);
		OcupacionLabel.setBounds(955, 133, 101, 28);
		MainPanel.add(OcupacionLabel);

		JLabel label = new JLabel("Numero Telefonico");
		label.setFont(new Font("Tahoma", Font.PLAIN, 33));
		label.setBounds(12, 24, 286, 41);
		MainPanel.add(label);

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
		txtNumTel.setFont(new Font("Tahoma", Font.PLAIN, textSize));
		txtNumTel.setBorder(border);
		txtNumTel.setColumns(10);
		txtNumTel.setBounds(310, 24, 378, 33);
		txtNumTel.setDocument(new JTextLimit(10));
		MainPanel.add(txtNumTel);

		JScrollPane scrollpaneEntradas = new JScrollPane();
		tabledatosEntrada = new JTable();
		tabledatosEntrada.setFont(new Font("Tahoma", Font.PLAIN, textSize));
		scrollpaneEntradas.setBorder(border);
		scrollpaneEntradas.setBounds(833, 227, 223, 96);
		scrollpaneEntradas.getViewport().setBackground(Color.WHITE);
		MainPanel.add(scrollpaneEntradas);

		JButton btnBuscarCliente = new JButton("Buscar Cliente");
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String[] encabezado = { "NumTel", "Nombre", "Apellido", "Sexo", "Edad", "Dir" };
					Object datos[][] = new Object[principal.lista.clientes.size()][];

					int renglon = 0;
					long NumTelx = Long.parseLong(txtNumTel.getText());
					int pos = principal.lista.buscarPosCliente(NumTelx);

					for (int i = pos; i < principal.lista.clientes.size(); i++) {// empieza desde el cliente buscado
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

		JLabel lblEntradas = new JLabel("Entradas");
		lblEntradas.setBackground(Color.LIGHT_GRAY);
		lblEntradas.setForeground(Color.BLACK);
		lblEntradas.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEntradas.setBounds(976, 200, 80, 28);
		MainPanel.add(lblEntradas);

		JLabel lblDiasParaPagar = new JLabel("Dias para pagar");
		lblDiasParaPagar.setForeground(Color.BLACK);
		lblDiasParaPagar.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDiasParaPagar.setBounds(899, 15, 157, 25);
		MainPanel.add(lblDiasParaPagar);

		lblDiasFaltantes = new JLabel("");
		lblDiasFaltantes.setForeground(Color.BLACK);
		lblDiasFaltantes.setBackground(Color.WHITE);
		lblDiasFaltantes.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDiasFaltantes.setBounds(899, 51, 135, 28);
		lblDiasFaltantes.setBorder(border);
		MainPanel.add(lblDiasFaltantes);

		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblClientes.setBounds(12, 124, 124, 28);
		MainPanel.add(lblClientes);

		JLabel lblFechaDeUltimo = new JLabel("Ultimo Pago");
		lblFechaDeUltimo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblFechaDeUltimo.setBounds(753, 13, 157, 28);
		MainPanel.add(lblFechaDeUltimo);

		lblUltimoPago = new JLabel("");
		lblUltimoPago.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblUltimoPago.setBounds(752, 51, 135, 28);
		lblUltimoPago.setBorder(border);
		MainPanel.add(lblUltimoPago);

		lblProbmedicos = new JLabel("ProbMedicos");
		lblProbmedicos.setBackground(Color.WHITE);
		lblProbmedicos.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblProbmedicos.setBounds(943, 334, 113, 28);
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
		ProbMedicos.setBounds(833, 364, 223, 111);
		ProbMedicos.setBorder(border);
		MainPanel.add(ProbMedicos);

		JButton btnElIminarCliente = new JButton("Eliminar Cliente");
		btnElIminarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {// elimina el cliente seleccionado
					if (JOptionPane.showConfirmDialog(null, "¿Seguro que quiere borrar este cliente?", "ADVERTENCIA",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						principal.lista.eleminarClientes(NumTely);
						JOptionPane.showMessageDialog(null, "Cliente borrado con Exito", "Exito",
								JOptionPane.DEFAULT_OPTION);
						ProbMedicos.setText(null);

						// Actualiza la tabla
						actualizar();
						// Guarda el documento
						principal.save();
					} else {
						System.out.println("That was a close one");
					}

				} catch (NullPointerException ex) {
					JOptionPane.showMessageDialog(null, "Error: Selecciona a una persona con el mouse", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Error: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnElIminarCliente.setForeground(Color.BLACK);
		btnElIminarCliente.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnElIminarCliente.setBackground(Color.WHITE);
		btnElIminarCliente.setBounds(753, 92, 180, 33);
		MainPanel.add(btnElIminarCliente);

		JScrollPane scrollPaneClientes = new JScrollPane();
		scrollPaneClientes.setBorder(border);
		tabledatos = new JTable() {
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);

				if (!isRowSelected(row)) {// no se como funciona este if, pero funciona
					// verifica que el table tenga mas o igual a 0 datos
					if (tabledatos.getColumnCount() >= 0) {

						long numTelz = (long) getModel().getValueAt(row,
								0);/* Obtiene el numero telefonico del cliente en el renglon */
						int posz = principal.lista.buscarPosCliente(
								numTelz);/* Obtiene la posicion de ese cliente en la lista de clientes */
						int posUltEnt = principal.lista.clientes.get(posz)
								.getUltimaEntrada();/* Obtiene la posicion de la ultima entrada de el cliente */

						// Si no tiene entradas, no hace nada
						if (posUltEnt == -1) {
						} else {

							// Obtiene la fecha de la ultima entrada
							LocalDate UltimaEntrada = LocalDate
									.parse(principal.lista.clientes.get(posz).getEntradas().get(posUltEnt).getFecha());

							// Obtiene el mes anterior en base del dia actual
							LocalDate LastMonth = LocalDate.now().minusMonths(1);

							// Si la ultima entrada es antes del mes anterior, cambia el row a cierto color
							if (UltimaEntrada.isBefore(LastMonth)) {
								c.setBackground(Color.RED);

								// Si no, lo deja en blanc
							} else {
								c.setBackground(Color.WHITE);
							}
						}
					}
				}

				return c;
			}
		};
		tabledatos.setFont(new Font("Tahoma", Font.PLAIN, textSize));
		tabledatos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					// String Array de Problemas medicas
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

						// Tabla de Entradas
						int renglon = 0;
						String[] encabezado = { "Fecha", "Hora" };
						Object datos[][];
						if (principal.lista.clientes.get(posx).getEntradas() == null) {// si no tiene, no pone nada
							datos = new Object[100][100];
							datos[0][0] = null;
							datos[0][1] = null;
						} else {// Si si, enseña el mas reciente primero
							datos = new Object[principal.lista.clientes.get(posx).getEntradas().size()][];
							for (int i = principal.lista.clientes.get(posx).getEntradas().size() - 1; i >= 0; i--) {
								datos[renglon] = new Object[2];
								datos[renglon][0] = principal.lista.clientes.get(posx).getEntradas().get(i)
										.getStringFecha();
								datos[renglon][1] = principal.lista.clientes.get(posx).getEntradas().get(i)
										.getStringHora();
								renglon++;
							}
						}

						DefaultTableModel modelo = new DefaultTableModel(datos, encabezado);
						tabledatosEntrada.setModel(modelo);
						scrollpaneEntradas.setViewportView(tabledatosEntrada);

						// Pagos
						if (pago() == null) {
							lblDiasFaltantes.setText("");
							lblUltimoPago.setText("");
						} else if (pago().diasFaltantes() < 5) {// Si ya casi es el fin de su mensualidad, avisa
							JOptionPane.showMessageDialog(null, "Ya casi se vence la mensualidad", "Aviso",
									JOptionPane.INFORMATION_MESSAGE);
							lblDiasFaltantes.setText("" + pago().diasFaltantes());// Dias Faltantes
							lblUltimoPago.setText("" + pago().getPago());// Ultimo Pago
						} else {
							lblDiasFaltantes.setText("" + pago().diasFaltantes());// Dias Faltantes
							lblUltimoPago.setText("" + pago().getPago());// Ultimo Pago
						}

						// Ocupacion
						Ocupaciontxt.setText("" + Ocupacion());
					}
				} catch (HeadlessException e1) {
					JOptionPane.showMessageDialog(null, "Error: " + e1, "ERROR", JOptionPane.ERROR_MESSAGE);
				}

			}

			private Object Ocupacion() {
				return principal.lista.clientes.get(posx).getOcupacion();
			}

			private PagoCliente pago() {
				return principal.lista.clientes.get(posx).getPago();
			}
		});
		scrollPaneClientes.setViewportView(tabledatos);

		// ScrollPaneClientes
		scrollPaneClientes.setBounds(12, 159, 781, 316);
		scrollPaneClientes.getViewport().setBackground(Color.WHITE);
		MainPanel.add(scrollPaneClientes);

		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(MostrarClientes.class.getResource("/Logos/RedCircle.jpg")));
		lblBackground.setBounds(12, 0, 931, 933);
		MainPanel.add(lblBackground);
		actualizar();
	}

	private void actualizar() {

		try {
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

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

}
