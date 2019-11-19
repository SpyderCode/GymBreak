package Gym;
//Creaado Por Ricardo Echaniz

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.MouseMotionAdapter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.Toolkit;

public class GymBreak {
	JFrame frmGymBreak;
	// Para los archivos
	FileInputStream fis;
	// inicializa la lista de clientes
	ListaClientes lista = new ListaClientes();
	// Se ponen los JPanels aqui para que pueda ser accessibles en todo el programa
	MostrarClientes MostrarClientesJPanel;
	AñadirCliente AñadirClienteJPanel;
	RegistrarEntrada RegistrarEntradaJPanel;
	Pagos PagosJPanel;
	JLabel lblTitulo;

	// Enteros globales
	int mouseX, mouseY;
	int PanelWidth = 1453;
	int PanelHeight = 805;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GymBreak window = new GymBreak();
					window.frmGymBreak.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GymBreak() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		GymBreak G = this;
		// Se busca y obtiene datos del archivo "GymBreak.csv"

		try {
			load();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Se inicializan los JPanels
		MostrarClientesJPanel = new MostrarClientes(G);
		AñadirClienteJPanel = new AñadirCliente(G);
		RegistrarEntradaJPanel = new RegistrarEntrada(G);
		PagosJPanel = new Pagos(G);

		// Las propiedades del Main JFrame
		frmGymBreak = new JFrame();
		frmGymBreak.setVisible(true);
		frmGymBreak.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frmGymBreak.setResizable(false);
		frmGymBreak.setIconImage(
				Toolkit.getDefaultToolkit().getImage(GymBreak.class.getResource("/Logos/barbell_64px.png")));
		frmGymBreak.getContentPane().setBackground(Color.WHITE);
		frmGymBreak.setTitle("Gym Break");
		frmGymBreak.setBounds(100, 100, 1394, 782);
		frmGymBreak.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGymBreak.getContentPane().setLayout(null);

		// El titulo
		lblTitulo = new JLabel("Elige un Boton\r\n");
		lblTitulo.setFont(new Font("Swis721 Hv BT", Font.ITALIC, 97));
		lblTitulo.setBounds(24, 13, 1125, 143);

		// El menu de alado
		JPanel SideMenu = new JPanel();
		SideMenu.setBackground(Color.BLACK);
		SideMenu.setBounds(0, 0, 320, 1032);
		frmGymBreak.getContentPane().add(SideMenu);
		SideMenu.setLayout(null);

		// El boton para añadir clientes
		JButton btnAñadir = new JButton("A\u00F1adir Cliente");
		btnAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				aplicarVentana(AñadirClienteJPanel, "Añadir Cliente");
				AñadirClienteJPanel.txtEdad.setEditable(true);
				AñadirClienteJPanel.txtNumTel.setEditable(true);

			}
		});
		// Propiedades del boton
		btnAñadir.setInheritsPopupMenu(true);
		btnAñadir.setBackground(Color.WHITE);
		btnAñadir.setHorizontalAlignment(SwingConstants.LEFT);
		btnAñadir.setIconTextGap(70);
		btnAñadir.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnAñadir.setIcon(new ImageIcon(GymBreak.class.getResource("/Logos/icons8_add_user_male_32px.png")));
		btnAñadir.setFont(new Font("Swis721 Hv BT", Font.PLAIN, 21));
		btnAñadir.setBounds(0, 187, 320, 79);
		SideMenu.add(btnAñadir);

		// El boton para los pagos
		JButton btnPagos = new JButton("Pagos");
		btnPagos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				aplicarVentana(PagosJPanel, "Pagos");
				PagosJPanel.NumTeltxt.setEditable(true);

			}
		});
		btnPagos.setBackground(Color.WHITE);
		btnPagos.setIcon(new ImageIcon(GymBreak.class.getResource("/Logos/icons8_money_32px.png")));
		btnPagos.setIconTextGap(70);
		btnPagos.setHorizontalAlignment(SwingConstants.LEFT);
		btnPagos.setFont(new Font("Swis721 Hv BT", Font.PLAIN, 21));
		btnPagos.setBounds(0, 265, 320, 86);
		SideMenu.add(btnPagos);

		// El boton que enseña los clientes
		JButton btnClientes = new JButton(" Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				aplicarVentana(MostrarClientesJPanel, "Clientes");
				MostrarClientesJPanel.txtNumTel.setEditable(true);

			}
		});
		btnClientes.setBackground(Color.WHITE);
		btnClientes.setIcon(new ImageIcon(GymBreak.class.getResource("/Logos/icons8_list_26px.png")));
		btnClientes.setIconTextGap(70);
		btnClientes.setHorizontalAlignment(SwingConstants.LEFT);
		btnClientes.setFont(new Font("Swis721 Hv BT", Font.PLAIN, 21));
		btnClientes.setBounds(0, 424, 320, 79);
		SideMenu.add(btnClientes);

		// Un muy simple about
		JButton btnAbout = new JButton("About");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JOptionPane.showMessageDialog(null, "Creado por SoftSolutions", "About",
						JOptionPane.INFORMATION_MESSAGE);

			}
		});
		btnAbout.setForeground(Color.WHITE);
		btnAbout.setBackground(Color.WHITE);
		btnAbout.setContentAreaFilled(false);
		btnAbout.setBounds(2, 718, 97, 25);
		SideMenu.add(btnAbout);

		JButton btnRegistrar = new JButton(" Registrar Entrada");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				aplicarVentana(RegistrarEntradaJPanel, "Registro de Entrada");
				RegistrarEntradaJPanel.txtNumTel.setEditable(true);
			}
		});
		btnRegistrar.setIcon(new ImageIcon(GymBreak.class.getResource("/Logos/icons8_clipboard_26px.png")));
		btnRegistrar.setIconTextGap(70);
		btnRegistrar.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegistrar.setFont(new Font("Swis721 Hv BT", Font.PLAIN, 21));
		btnRegistrar.setBackground(Color.WHITE);
		btnRegistrar.setBounds(0, 350, 321, 79);
		SideMenu.add(btnRegistrar);

		// Para el titulo arriba a la izquierdda
		JLabel lblGymBreak = new JLabel("Gym");
		lblGymBreak.setBounds(0, 0, 266, 97);
		SideMenu.add(lblGymBreak);
		lblGymBreak.setForeground(Color.RED);
		lblGymBreak.setBackground(Color.RED);
		lblGymBreak.setFont(new Font("Swis721 Hv BT", Font.PLAIN, 80));

		JLabel lblBreak = new JLabel("Break");
		lblBreak.setForeground(Color.WHITE);
		lblBreak.setFont(new Font("Swis721 Hv BT", Font.PLAIN, 80));
		lblBreak.setBackground(Color.RED);
		lblBreak.setBounds(83, 76, 237, 96);
		SideMenu.add(lblBreak);

		// Coloca el logo chico hasta abajo
		JLabel lblLogoChicoBajo = new JLabel("");
		lblLogoChicoBajo.setIcon(new ImageIcon(GymBreak.class.getResource("/Logos/Logo_chico.jpeg")));
		lblLogoChicoBajo.setBounds(111, 507, 99, 192);
		SideMenu.add(lblLogoChicoBajo);

		// La barra roja en medio
		JPanel BarPanel = new JPanel();
		BarPanel.setBackground(new Color(178, 34, 34));
		BarPanel.setBounds(320, 64, PanelWidth, 194);
		frmGymBreak.getContentPane().add(BarPanel);
		BarPanel.setLayout(null);
		BarPanel.add(lblTitulo);

		// La barra gris hasta arriba
		JPanel TopBar = new JPanel();
		TopBar.setBackground(new Color(60, 60, 60));
		TopBar.setBounds(320, 0, PanelWidth, 65);
		frmGymBreak.getContentPane().add(TopBar);
		TopBar.setLayout(null);

		/*
		 * DragThingy es un JLabel que permite arrastrar la ventana, sin esto no se
		 * podria mover la ventana
		 */

		JLabel DragThingy = new JLabel("");
		DragThingy.setBounds(0, 0, frmGymBreak.getRootPane().getWidth(), 65);
		TopBar.add(DragThingy);
		DragThingy.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// Primero obtiene la informacion de donde le pretaste
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		DragThingy.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent evt) {
				// Luego obtiene a donde se mueve
				int coorX = evt.getXOnScreen();
				int coorY = evt.getYOnScreen();

				// Coloca la ventana en la nueva ubicacion
				frmGymBreak.setLocation(coorX - mouseX, coorY - mouseY);
			}
		});
	}

	/*
	 * Metodos
	 * 
	 * 
	 */
	protected void aplicarVentana(JPanel VentanaJPanel, String titulo) {// Metodo para aplicar ventanas al proyecto
		try {
			// Elimina los otros JPanel
			eleminarall();

			// Luego coloca el nuevo JPanel con su tamaño
			VentanaJPanel.setSize(1137, 548);
			VentanaJPanel.setLocation(320, 257);
			// Cambia el titulo
			lblTitulo.setText(titulo);
			// Lo enseña en el programa
			frmGymBreak.getContentPane().add(VentanaJPanel, BorderLayout.CENTER);
			frmGymBreak.revalidate();
			frmGymBreak.repaint();
			// Debug
			System.out.println("Exito Aplicar Ventana: "+VentanaJPanel);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
		}

	}

	protected void eleminarall() {// El metodo para eleminar todos los JPanels
		frmGymBreak.remove(MostrarClientesJPanel);
		frmGymBreak.remove(AñadirClienteJPanel);
		frmGymBreak.remove(PagosJPanel);
		frmGymBreak.remove(RegistrarEntradaJPanel);

	}

	public void save() throws IOException {// Metodo para guardar el ArrayList a un documento .CSV
		saveNormal();
	}

	private void saveNormal() {
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		try {
			// Obtiene el lugar del archivo
			fout = new FileOutputStream(System.getProperty("user.home") + "\\Documents" + "\\GymBreakDB\\");
			oos = new ObjectOutputStream(fout);

			// Escribe la lista del cliente al archivo
			for (Clientes c : lista.clientes) {
				oos.writeObject(c);
			}
			// Cierra los OutPutStreams
			oos.close();
			fout.close();
			// Si funciona da el mensaje de exito
//			JOptionPane.showMessageDialog(null, "Archivo Guardado con Exito", "Exito", JOptionPane.DEFAULT_OPTION);

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void load() throws IOException {// Metodo para abrir el archivo GymBreakDB
		loadNormal();

	}

	private void loadNormal() {
		try {
			fis = new FileInputStream(System.getProperty("user.home") + "\\Documents" + "\\GymBreakDB\\");// Busca el
																											// archivo
			ObjectInputStream ois = new ObjectInputStream(fis);
			Clientes c;
			// Lee cada cliente
			while (true) {
				c = (Clientes) ois.readObject();
				lista.clientes.add(c);
			}

		} catch (EOFException ex) {// Cuando termina, cierra el InputStream
			try {
				fis.close();
				JOptionPane.showMessageDialog(null, "Datos Cargados con Exito");
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Error: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error: No se ha encontrado la base de datos,\n se creara "
					+ "uno nuevo en tu Documentos", "ERROR", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
		}

	}
}