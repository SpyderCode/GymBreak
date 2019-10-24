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
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Cursor;
import javax.swing.JLayeredPane;
import java.awt.Toolkit;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GymBreak {
	FileInputStream fis;
	// inicializa la lista de clientes
	ListaClientes lista = new ListaClientes();
	JFrame frmGymBreak;
	int mouseX, mouseY;
	// Se ponen los JPanels aqui para que pueda ser accessibles en todo el programa
	MostrarClientes MostrarClientesJPanel;
	AñadirCliente AñadirClienteJPanel;
	ModificarCliente ModificarClienteJPanel;
	RegistrarEntrada RegistrarEntradaJPanel;
	Pagos PagosJPanel;
	JLabel lblTitulo;

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
		ModificarClienteJPanel = new ModificarCliente(G);
		RegistrarEntradaJPanel = new RegistrarEntrada(G);
		PagosJPanel = new Pagos(G);

		// Las propiedades del Main JFrame
		frmGymBreak = new JFrame();
		frmGymBreak.setResizable(true);
		frmGymBreak.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frmGymBreak.setIconImage(
				Toolkit.getDefaultToolkit().getImage(GymBreak.class.getResource("/Logos/barbell_64px.png")));
		frmGymBreak.setUndecorated(true);
		frmGymBreak.getContentPane().setBackground(Color.WHITE);
		frmGymBreak.setTitle("Gym Break");
		frmGymBreak.setBounds(100, 100, PanelWidth, PanelHeight);
		frmGymBreak.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGymBreak.getContentPane().setLayout(null);

		// El titulo
		lblTitulo = new JLabel("Elige un Boton\r\n");
		lblTitulo.setFont(new Font("Swis721 Hv BT", Font.ITALIC, 97));
		lblTitulo.setBounds(24, 13, 1125, 143);

		// El boton "X" para poder cerrar el programa sin usar el layout que nos da Java
		JButton btnExit = new JButton("");
		btnExit.setBounds(PanelWidth - 50, 0, 54, 40);
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
		SideMenu.setBounds(0, 0, 320, PanelHeight);
		frmGymBreak.getContentPane().add(SideMenu);
		SideMenu.setLayout(null);

		// El boton para añadir clientes
		JButton btnAñadir = new JButton("A\u00F1adir Cliente");
		btnAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				aplicarVentana(AñadirClienteJPanel, "Añadir Cliente");

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

			}
		});
		btnPagos.setBackground(Color.WHITE);
		btnPagos.setIcon(new ImageIcon(GymBreak.class.getResource("/Logos/icons8_money_32px.png")));
		btnPagos.setIconTextGap(70);
		btnPagos.setHorizontalAlignment(SwingConstants.LEFT);
		btnPagos.setFont(new Font("Swis721 Hv BT", Font.PLAIN, 21));
		btnPagos.setBounds(0, 342, 320, 86);
		SideMenu.add(btnPagos);

		// El boton que enseña los clientes
		JButton btnClientes = new JButton(" Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				aplicarVentana(MostrarClientesJPanel, "Clientes");

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
		btnAbout.setBounds(0, PanelHeight - 26, 97, 25);
		SideMenu.add(btnAbout);

		JButton btnRegistrar = new JButton(" Registrar Entrada");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				aplicarVentana(RegistrarEntradaJPanel, "Registro de Entrada");
			}
		});
		btnRegistrar.setIcon(new ImageIcon(GymBreak.class.getResource("/Logos/icons8_clipboard_26px.png")));
		btnRegistrar.setIconTextGap(70);
		btnRegistrar.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegistrar.setFont(new Font("Swis721 Hv BT", Font.PLAIN, 21));
		btnRegistrar.setBackground(Color.WHITE);
		btnRegistrar.setBounds(0, 265, 320, 79);
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
		lblLogoChicoBajo.setBounds(111, 551, 99, 192);
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
		DragThingy.setBounds(-320, 0, PanelWidth, 65);
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
		// Elimina los otros JPanel
		eleminarall();

//		int PanelWidth=1453;
//		int PanelHeight=805;
//		lblTest.setBounds(320, 257, 1137, 548);

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
		System.out.println("Exito Aplicar Ventana");

	}

	protected void eleminarall() {// El metodo para eleminar todos los JPanels
		frmGymBreak.remove(MostrarClientesJPanel);
		frmGymBreak.remove(AñadirClienteJPanel);
		frmGymBreak.remove(ModificarClienteJPanel);
		frmGymBreak.remove(PagosJPanel);
		frmGymBreak.remove(RegistrarEntradaJPanel);
		//

	}

	public void save() throws IOException {// Metodo para guardar el ArrayList a un documento .CSV
		// saveExcel();
		saveNormal();

	}

	private void saveNormal() {
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		try {
			fout = new FileOutputStream(System.getProperty("user.home") + "\\Documents" + "\\GymBreakDB\\");
			oos = new ObjectOutputStream(fout);

			for (Clientes c : lista.clientes) {
				oos.writeObject(c);
			}
//			oos.writeObject(lista);
			oos.close();
			fout.close();
			JOptionPane.showMessageDialog(null, "Archivo Guardado con Exito", "Exito", JOptionPane.DEFAULT_OPTION);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void saveExcel() throws IOException {
		BufferedWriter writer = new BufferedWriter(
				// Se obtiene el lugar a donde se guardara
				new FileWriter(System.getProperty("user.home") + "\\Documents" + "\\GymBreakDB\\"));
		// La manera en la que se van a guardar:
		// Nombre,Apellido,sexo,edad,numeroTel,direccion,detallesMedicos,Entradas,Pagos
		// Escribe los datos de cada cliente en la lista en el documento
		for (Clientes c : lista.clientes) {
			writer.write(c.toString());
		}
		// Cierra el Writer
		writer.close();

		// Si todo funciona
		JOptionPane.showMessageDialog(null, "Archivo Guardado con Exito", "Exito", JOptionPane.DEFAULT_OPTION);
	}

	public void load() throws IOException {// Metodo para abrir el archivo .CSV
		// Scanner scan = new Scanner(
//					// Obtiene el archivo de su ubicacion
//					new File(System.getProperty("user.home") + "\\Documents" + "\\GymBreakDB.csv\\"));
////			loadExcel(scan);

			loadNormal();
//		} catch (FileNotFoundException e) {
//
//			// Si no se encuentra el archivo, enseña este mensaje
//			JOptionPane.showMessageDialog(null, "Error al abrir base de datos:\n" + "\nSe creara un"
//					+ "nuevo archivo 'GymBreakDB' en tu carpeta de Documentos");
//
//			// Crea el archivo sin datos
//			try {
//				save();
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}

	}

	private void loadNormal() {
		try {
			fis = new FileInputStream(System.getProperty("user.home") + "\\Documents" + "\\GymBreakDB\\");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Clientes c;
			while (true) {
				c=(Clientes) ois.readObject();
				lista.clientes.add(c);
			}
			
		
		}catch (EOFException ex) {
			try {
				fis.close();
				JOptionPane.showMessageDialog(null, "Datos Cargados con Exito");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void loadExcel(Scanner scan) {
		while (scan.hasNextLine()) {// Mientras haya lineas, lee
			PagoCliente pago = null;
			// Primero se escanea la linea del archivo
			String line = scan.nextLine();

			String[] lineArray = line.split(",");// Todo lo demas

			/*
			 * Como los datos de Detalles Medicos,pagos y Entradas estan en una sola celda
			 * en eclipse Aqui se crea ArrayList cortando los datos con el _
			 */
			String sMedico[] = lineArray[6].split("_");// Detalles Medicos
			String eEntradas[] = lineArray[7].split("_");// Entradas
			String[] dPago = new String[2]; // Pago

			// Checa a ver si hay datos o no en la celda de pagos
			if (lineArray[8].equals("_")) {// Si no, no hace nada y pagos queda como null
			} else {
				dPago = lineArray[8].split("_");
				// Para colocar el pago en su lugar de una manera mas facil
				pago = new PagoCliente(LocalDate.parse(dPago[0]), Integer.parseInt(dPago[1]));
			}

			// Coloca los arreglos a su ArrayList
			ArrayList<String> detallesMedicos = new ArrayList<>(Arrays.asList(sMedico));
//				ArrayList<String> entradas = new ArrayList<>(Arrays.asList(eEntradas));

			// Crea el cliente
			Clientes clientex = new Clientes(lineArray[0], lineArray[1], lineArray[2].charAt(0),
					Integer.parseInt(lineArray[3]), Long.parseLong(lineArray[4]), lineArray[5], detallesMedicos, null);
			// Le añade el pago
			clientex.setPago(pago);
			System.out.println(eEntradas.length);
			if (lineArray[7].equals("_")) {
			} else {
				for (int i = 0; i < eEntradas.length; i += 2) {
					String fecha = "" + eEntradas[i];
					LocalTime hora = LocalTime.parse(eEntradas[i + 1]);

					Entradas x = new Entradas(fecha, hora);
					clientex.altaEntrada(x);
				}
			}

			// Añade el cliente a la lista
			lista.clientes.add(clientex);

		}
	}
}