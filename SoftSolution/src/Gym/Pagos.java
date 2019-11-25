package Gym;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class Pagos extends JPanel {
	public JTextField NumTeltxt;
	private JTextField Tipotxt;
	private JTextField Mesestxt;
	public GymBreak principal;
	public JPanel panel;

	public Pagos(GymBreak padre) {
		principal = padre;
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		setBackground(Color.WHITE);
		setLayout(null);

		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(Color.WHITE);
		MainPanel.setBounds(0, 0, 1068, 488);
		add(MainPanel);
		MainPanel.setLayout(null);

		JLabel label = new JLabel("Numero Telefonico");
		label.setFont(new Font("Tahoma", Font.PLAIN, 28));
		label.setBounds(12, 13, 246, 33);
		MainPanel.add(label);

		NumTeltxt = new JTextField();
		NumTeltxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || (ke.getKeyCode() == KeyEvent.VK_BACK_SPACE)
						|| (ke.getKeyCode() == KeyEvent.VK_DELETE)) {
					NumTeltxt.setEditable(true);
				} else {
					NumTeltxt.setEditable(false);

				}
			}
		});
		NumTeltxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		NumTeltxt.setColumns(10);
		NumTeltxt.setBounds(259, 19, 404, 33);
		NumTeltxt.setDocument(new JTextLimit(10));
		MainPanel.add(NumTeltxt);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setOpaque(false);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos", TitledBorder.LEADING,
				TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 20), Color.BLACK)); // El borde chido
		panel.setBounds(12, 101, 527, 374);
		MainPanel.add(panel);

		JLabel Nombrelbl = new JLabel("Nombre");
		Nombrelbl.setFont(new Font("Tahoma", Font.PLAIN, 33));
		Nombrelbl.setBounds(12, 24, 133, 38);
		panel.add(Nombrelbl);

		JLabel Apellidolbl = new JLabel("Apellido(s)");
		Apellidolbl.setFont(new Font("Tahoma", Font.PLAIN, 33));
		Apellidolbl.setBounds(12, 75, 184, 41);
		panel.add(Apellidolbl);

		JLabel Nombretxt = new JLabel("");
		Nombretxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Nombretxt.setBorder(border);
		Nombretxt.setBounds(196, 24, 277, 38);
		panel.add(Nombretxt);

		JLabel Apellidotxt = new JLabel("");
		Apellidotxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Apellidotxt.setBorder(border);
		Apellidotxt.setBounds(196, 78, 277, 38);
		panel.add(Apellidotxt);

		JLabel lblTipoDePago = new JLabel("Tipo de Pago");
		lblTipoDePago.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblTipoDePago.setBounds(566, 124, 194, 38);
		MainPanel.add(lblTipoDePago);

		JLabel lblMeses = new JLabel("Mensualidades");
		lblMeses.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblMeses.setBounds(566, 250, 271, 38);
		MainPanel.add(lblMeses);

		Tipotxt = new JTextField();
		Tipotxt.setBorder(border);
		Tipotxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Tipotxt.setColumns(10);
		Tipotxt.setBounds(772, 129, 284, 33);
		Tipotxt.setDocument(new JTextLimit(30));
		MainPanel.add(Tipotxt);

		Mesestxt = new JTextField();
		Mesestxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || (ke.getKeyCode() == KeyEvent.VK_BACK_SPACE)
						|| (ke.getKeyCode() == KeyEvent.VK_DELETE)) {
					Mesestxt.setEditable(true);
				} else {
					Mesestxt.setEditable(false);

				}
			}
		});
		Mesestxt.setBorder(border);
		Mesestxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Mesestxt.setColumns(10);
		Mesestxt.setBounds(926, 259, 130, 33);
		Mesestxt.setDocument(new JTextLimit(5));
		MainPanel.add(Mesestxt);

		JLabel lblDiaDeHoy = new JLabel("Dia de Hoy");
		lblDiaDeHoy.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblDiaDeHoy.setBounds(566, 187, 194, 38);
		MainPanel.add(lblDiaDeHoy);

		JLabel Diatxt = new JLabel("" + LocalDate.now());
		Diatxt.setBorder(border);
		Diatxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Diatxt.setBounds(772, 187, 284, 38);
		MainPanel.add(Diatxt);

		JButton btnDarAlta = new JButton("Dar de Alta");
		btnDarAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					// Obtiene la posicion del cliente en base de su numero de telefono
					long telNumx = Long.parseLong(NumTeltxt.getText());
					int posx = principal.lista.buscarPosCliente(telNumx);
					System.out.println(posx);// Debug

					// Obtiene los datos ya en los cuadros
					String tipoPagox = Tipotxt.getText();
					int mesesx = Integer.parseInt(Mesestxt.getText());

					// Obtiene el dia de hoy y crea un objeto de pago, el dia de hoy y la
					// mensualidad
					LocalDate date = LocalDate.now();
					PagoCliente pagox = new PagoCliente(date, mesesx);

					// Añade el pago al cliente
					getCliente(posx).setFormaPago(tipoPagox);
					getCliente(posx).setPago(pagox);

					// Guarda el archivo
					principal.save();

					// Clears text
					cleartxt();
				} catch (NumberFormatException | IOException e1) {
					JOptionPane.showMessageDialog(null, "Error: " + e1, "ERROR", JOptionPane.ERROR_MESSAGE);
				}

			}

			private void cleartxt() {// simplemente borra las cajas
				Apellidotxt.setText(null);
				Nombretxt.setText(null);
				Mesestxt.setText(null);
				NumTeltxt.setText(null);
				Tipotxt.setText(null);

			}

			private Clientes getCliente(int posx) {// Para no escribir tanto codigo
				return principal.lista.clientes.get(posx);
			}
		});
		btnDarAlta.setBounds(904, 436, 152, 39);
		MainPanel.add(btnDarAlta);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					// Obtiene datos
					long telNumx = Long.parseLong(NumTeltxt.getText());
					int posx = principal.lista.buscarPosCliente(telNumx);
					System.out.println(posx);

					// Da el nombre y apellido del cliente
					Nombretxt.setText("" + getCliente(posx).getNombre());
					Apellidotxt.setText("" + getCliente(posx).getApellido());

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
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setBounds(12, 55, 123, 33);
		MainPanel.add(btnBuscar);

		JLabel BackGround = new JLabel("");
		BackGround.setBounds(-187, 175, 1863, 844);
		MainPanel.add(BackGround);
		BackGround.setIcon(new ImageIcon(
				Pagos.class.getResource("/Logos/gallery-red-and-white-backgrounds-drawing-art-gallery.jpg")));

	}
}
