package Gym;
//Diseñado por Ricardo Echaniz

import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Cursor;
import javax.swing.JLayeredPane;
import java.awt.Toolkit;

public class GymBreak {
	//inicializa la lista de clientes
	ListaClientes lista = new ListaClientes();
	JFrame frmGymBreak;
	int mouseX, mouseY;
	// Se ponen los JPanels aqui para que pueda ser accessibles en todo el programa
	MostrarClientes MostrarClientesJPanel;
	AñadirCliente AñadirClienteJPanel;
	ModificarCliente ModificarClienteJPanel;
	RegistrarEntrada RegistrarEntradaJPanel;

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
		load();
		// Se inicializan los JPanels
		MostrarClientesJPanel = new MostrarClientes(G);
		AñadirClienteJPanel = new AñadirCliente(G);
		ModificarClienteJPanel = new ModificarCliente(G);
		RegistrarEntradaJPanel = new RegistrarEntrada(G);

		// Las propiedades del Main JFrame
		frmGymBreak = new JFrame();
		frmGymBreak.setIconImage(
				Toolkit.getDefaultToolkit().getImage(GymBreak.class.getResource("/Logos/barbell_64px.png")));
		frmGymBreak.setUndecorated(true);
		frmGymBreak.getContentPane().setBackground(Color.WHITE);
		frmGymBreak.setTitle("Gym Break");
		frmGymBreak.setBounds(100, 100, 1253, 705);
		frmGymBreak.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGymBreak.getContentPane().setLayout(null);

		// El titulo
		JLabel lblTitulo = new JLabel("Elige un Boton\r\n");
		lblTitulo.setFont(new Font("Swis721 Hv BT", Font.ITALIC, 97));
		lblTitulo.setBounds(24, 13, 807, 143);

		// El boton "X" para poder cerrar el programa sin usar el layout que nos da Java
		JButton btnExit = new JButton("");
		btnExit.setBounds(1199, 0, 54, 40);
		frmGymBreak.getContentPane().add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setContentAreaFilled(false);
		btnExit.setBorderPainted(false);
		btnExit.setIcon(new ImageIcon(GymBreak.class.getResource("/Logos/icons8_delete_sign_32px.png")));

		// El menu de alado
		JPanel SideMenu = new JPanel();
		SideMenu.setBackground(Color.BLACK);
		SideMenu.setBounds(0, 0, 320, 705);
		frmGymBreak.getContentPane().add(SideMenu);
		SideMenu.setLayout(null);

		// El boton para añadir clientes
		JButton btnAñadir = new JButton("A\u00F1adir Cliente");
		btnAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Primero borra cualquier JPanel que podria estar ahi
				eleminarall();
				// Luego coloca el nuevo JPanel con su tamaño
				AñadirClienteJPanel.setSize(933, 448);
				AñadirClienteJPanel.setLocation(320, 257);

				// Cambia el titulo
				lblTitulo.setText("Añadir Cliente");
				// Luego lo enseña en el programa
				frmGymBreak.getContentPane().add(AñadirClienteJPanel, BorderLayout.CENTER);
				frmGymBreak.revalidate();
				frmGymBreak.repaint();
				// Debug
				System.out.println("All fine here GymBreak-btnAñadir");
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
		btnAñadir.setBounds(0, 187, 320, 63);
		SideMenu.add(btnAñadir);

		// El boton para modificar el cliente
		JButton btnModificar = new JButton("Modificar Cliente");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// elimina todos los JPanel
				eleminarall();

				// Luego coloca el nuevo JPanel con su tamaño
				ModificarClienteJPanel.setSize(933, 448);
				ModificarClienteJPanel.setLocation(320, 257);
				lblTitulo.setText("Modificar Cliente");

				// Lo enseña en el programa
				frmGymBreak.getContentPane().add(ModificarClienteJPanel, BorderLayout.CENTER);
				frmGymBreak.revalidate();
				frmGymBreak.repaint();
				// Debug
				System.out.println("All fine here GymBreak-btnModificar");
			}
		});
		btnModificar.setBackground(Color.WHITE);
		btnModificar.setIcon(new ImageIcon(GymBreak.class.getResource("/Logos/icons8_edit_user_male_32px.png")));
		btnModificar.setIconTextGap(70);
		btnModificar.setHorizontalAlignment(SwingConstants.LEFT);
		btnModificar.setFont(new Font("Swis721 Hv BT", Font.PLAIN, 21));
		btnModificar.setBounds(0, 247, 320, 63);
		SideMenu.add(btnModificar);

		// El boton para los pagos
		JButton btnPagos = new JButton("Pagos");
		btnPagos.setBackground(Color.WHITE);
		btnPagos.setIcon(new ImageIcon(GymBreak.class.getResource("/Logos/icons8_money_32px.png")));
		btnPagos.setIconTextGap(70);
		btnPagos.setHorizontalAlignment(SwingConstants.LEFT);
		btnPagos.setFont(new Font("Swis721 Hv BT", Font.PLAIN, 21));
		btnPagos.setBounds(0, 365, 320, 63);
		SideMenu.add(btnPagos);

		// El boton que enseña los clientes
		JButton btnClientes = new JButton(" Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Elimina los otros JPanel
				eleminarall();

				// Luego coloca el nuevo JPanel con su tamaño
				MostrarClientesJPanel.setSize(933, 448);
				MostrarClientesJPanel.setLocation(320, 257);
				// Cambia el titulo
				lblTitulo.setText("Clientes");
				// Lo enseña en el programa
				frmGymBreak.getContentPane().add(MostrarClientesJPanel, BorderLayout.CENTER);
				frmGymBreak.revalidate();
				frmGymBreak.repaint();
				// Debug
				System.out.println("All fine here GymBreak-btnClientes");

			}
		});
		btnClientes.setBackground(Color.WHITE);
		btnClientes.setIcon(new ImageIcon(GymBreak.class.getResource("/Logos/icons8_list_26px.png")));
		btnClientes.setIconTextGap(70);
		btnClientes.setHorizontalAlignment(SwingConstants.LEFT);
		btnClientes.setFont(new Font("Swis721 Hv BT", Font.PLAIN, 21));
		btnClientes.setBounds(0, 424, 320, 63);
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
		btnAbout.setBounds(0, 680, 97, 25);
		SideMenu.add(btnAbout);

		JButton btnRegistrar = new JButton(" Registrar Entrada");
		btnRegistrar.setIcon(new ImageIcon(GymBreak.class.getResource("/Logos/icons8_clipboard_26px.png")));
		btnRegistrar.setIconTextGap(70);
		btnRegistrar.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegistrar.setFont(new Font("Swis721 Hv BT", Font.PLAIN, 21));
		btnRegistrar.setBackground(Color.WHITE);
		btnRegistrar.setBounds(0, 304, 320, 63);
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
		lblLogoChicoBajo.setBounds(109, 500, 99, 192);
		SideMenu.add(lblLogoChicoBajo);

		// La barra roja en medio
		JPanel BarPanel = new JPanel();
		BarPanel.setBackground(new Color(178, 34, 34));
		BarPanel.setBounds(320, 64, 933, 194);
		frmGymBreak.getContentPane().add(BarPanel);
		BarPanel.setLayout(null);
		BarPanel.add(lblTitulo);

		// La barra gris hasta arriba
		JPanel TopBar = new JPanel();
		TopBar.setBackground(new Color(60, 60, 60));
		TopBar.setBounds(320, 0, 933, 65);
		frmGymBreak.getContentPane().add(TopBar);
		TopBar.setLayout(null);

		/*
		 * DragThingy es un JLabel que permite arrastrar la ventana, sin esto no se
		 * podria mover la ventana
		 */
		JLabel DragThingy = new JLabel("");
		DragThingy.setBounds(-320, 0, 1253, 65);
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

	protected void eleminarall() {// El metodo para eleminar todos los JPanels
		frmGymBreak.remove(MostrarClientesJPanel);
		frmGymBreak.remove(AñadirClienteJPanel);
		frmGymBreak.remove(ModificarClienteJPanel);

	}

	public void save() {// Metodo para guardar el ArrayList a un documento .CSV

		try {
			BufferedWriter writer = new BufferedWriter(
					// Se obtiene el lugar a donde se guardara
					new FileWriter(System.getProperty("user.home") + "\\Documents" + "\\GymBreakDB.csv\\"));
			// La manera en la que se van a guardar:
			// Nombre,Apellido,sexo,edad,numeroTel,direccion,detallesMedicos,Entradas

			// Escribe los datos de cada cliente en la lista en el documento
			for (Clientes c : lista.clientes) {
				writer.write(c.toString());
			}
			// Cierra el Writer
			writer.close();

			// Si todo funciona
			JOptionPane.showMessageDialog(null, "Archivo Guardado con Exito", "Exito", JOptionPane.DEFAULT_OPTION);

		} catch (IOException e) {
			// Si algo va mal
			JOptionPane.showMessageDialog(null, "Error al guardar archivo" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void load() {// Metodo para abrir el archivo .CSV
		try {
			Scanner scan = new Scanner(
					// Obtiene el archivo de su ubicacion
					new File(System.getProperty("user.home") + "\\Documents" + "\\GymBreakDB.csv\\"));
			// Formato
			// Nombre,Apellido,sexo,edad,numeroTel,direccion,detallesMedicos,Entradas

			// Lee cada linea del archivo
			while (scan.hasNextLine()) {// Mientras haya lineas, lee

				// Primero se escanea la linea del archivo
				String line = scan.nextLine();

				String[] lineArray = line.split(",");// Todo lo demas

				/*
				 * Como los datos de Detalles Medicos y Entradas estan en una sola celda en
				 * eclipse Aqui se crea ArrayList cortando los datos con el _
				 */
				String s[] = lineArray[6].split("_");// Detalles Medicos
				String e[] = lineArray[7].split("_");// Entradas

				// Coloca los arreglos a su ArrayList
				ArrayList<String> detallesMedicos = new ArrayList<>(Arrays.asList(s));
				ArrayList<String> entradas = new ArrayList<>(Arrays.asList(e));

				// Añade el cliente a la lista
				lista.clientes.add(
						new Clientes(lineArray[0], lineArray[1], lineArray[2].charAt(0), Integer.parseInt(lineArray[3]),
								Long.parseLong(lineArray[4]), lineArray[5], detallesMedicos, entradas));

			}

		} catch (FileNotFoundException e) {
			//Si no se encuentra el archivo, enseña este mensaje
			JOptionPane.showMessageDialog(null, "Error al abrir base de datos:\n" + "\nSe creara un"
					+ "nuevo archivo 'GymBreakDB' en tu carpeta de Documentos");
			//Crea el archivo sin datos
			save();
		}

	}
}