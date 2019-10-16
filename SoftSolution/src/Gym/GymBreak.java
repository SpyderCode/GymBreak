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
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Cursor;
import javax.swing.JLayeredPane;

public class GymBreak {
	ListaClientes lista= new ListaClientes();
	JFrame frmGymBreak;
	int mouseX,mouseY;
	MostrarClientes MostrarClientesJPanel;
	AñadirCliente AñadirClienteJPanel;

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
		GymBreak G=this;
		MostrarClientesJPanel=new MostrarClientes(G);
		AñadirClienteJPanel=new AñadirCliente(G);
		ModificarCliente ModificarClienteJPanel=new ModificarCliente(G);
		RegistrarEntrada RegistrarEntradaJPanel=new RegistrarEntrada(G);
		
		frmGymBreak = new JFrame();
		frmGymBreak.setUndecorated(true);
		frmGymBreak.getContentPane().setBackground(Color.WHITE);
		frmGymBreak.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				 
			}
		});
		frmGymBreak.setTitle("Gym Break");
		frmGymBreak.setBounds(100, 100, 1253, 705);
		frmGymBreak.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGymBreak.getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Elige un Boton\r\n");
		
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
		
		JPanel SideMenu = new JPanel();
		SideMenu.setBackground(Color.BLACK);
		SideMenu.setBounds(0, 0, 320, 705);
		frmGymBreak.getContentPane().add(SideMenu);
		SideMenu.setLayout(null);
		
		JButton btnAñadir = new JButton("A\u00F1adir Cliente");
		btnAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eleminarall();
				AñadirClienteJPanel.setSize(933, 448);
				AñadirClienteJPanel.setLocation(320, 257);
				
				lblTitulo.setText("Añadir Cliente");
				frmGymBreak.getContentPane().add(AñadirClienteJPanel,BorderLayout.CENTER);
				frmGymBreak.revalidate();
				frmGymBreak.repaint();
				System.out.println("Done");
			}
		});
		btnAñadir.setInheritsPopupMenu(true);
		btnAñadir.setBackground(Color.WHITE);
		btnAñadir.setHorizontalAlignment(SwingConstants.LEFT);
		btnAñadir.setIconTextGap(70);
		btnAñadir.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnAñadir.setIcon(new ImageIcon(GymBreak.class.getResource("/Logos/icons8_add_user_male_32px.png")));
		btnAñadir.setFont(new Font("Swis721 Hv BT", Font.PLAIN, 21));
		btnAñadir.setBounds(0, 187, 320, 63);
		SideMenu.add(btnAñadir);
		
		JButton btnModificar = new JButton("Modificar Cliente");
		btnModificar.setBackground(Color.WHITE);
		btnModificar.setIcon(new ImageIcon(GymBreak.class.getResource("/Logos/icons8_edit_user_male_32px.png")));
		btnModificar.setIconTextGap(70);
		btnModificar.setHorizontalAlignment(SwingConstants.LEFT);
		btnModificar.setFont(new Font("Swis721 Hv BT", Font.PLAIN, 21));
		btnModificar.setBounds(0, 247, 320, 63);
		SideMenu.add(btnModificar);
		
		JButton btnPagos = new JButton("Pagos");
		btnPagos.setBackground(Color.WHITE);
		btnPagos.setIcon(new ImageIcon(GymBreak.class.getResource("/Logos/icons8_money_32px.png")));
		btnPagos.setIconTextGap(70);
		btnPagos.setHorizontalAlignment(SwingConstants.LEFT);
		btnPagos.setFont(new Font("Swis721 Hv BT", Font.PLAIN, 21));
		btnPagos.setBounds(0, 365, 320, 63);
		SideMenu.add(btnPagos);
		
		JButton btnClientes = new JButton(" Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eleminarall();
				MostrarClientesJPanel.setSize(933, 448);
				MostrarClientesJPanel.setLocation(320, 257);
				lblTitulo.setText("Clientes");
				frmGymBreak.getContentPane().add(MostrarClientesJPanel,BorderLayout.CENTER);
				frmGymBreak.revalidate();
				frmGymBreak.repaint();
				System.out.println("Done");
				
			}
		});
		btnClientes.setBackground(Color.WHITE);
		btnClientes.setIcon(new ImageIcon(GymBreak.class.getResource("/Logos/icons8_list_26px.png")));
		btnClientes.setIconTextGap(70);
		btnClientes.setHorizontalAlignment(SwingConstants.LEFT);
		btnClientes.setFont(new Font("Swis721 Hv BT", Font.PLAIN, 21));
		btnClientes.setBounds(0, 424, 320, 63);
		SideMenu.add(btnClientes);
		
		JButton btnAbout = new JButton("About");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Creado por SoftSolutions","About",JOptionPane.INFORMATION_MESSAGE);
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
		
		JLabel lblLogoChicoBajo = new JLabel("");
		lblLogoChicoBajo.setIcon(new ImageIcon(GymBreak.class.getResource("/Logos/Logo_chico.jpeg")));
		lblLogoChicoBajo.setBounds(109, 500, 99, 192);
		SideMenu.add(lblLogoChicoBajo);
		
		JPanel BarPanel = new JPanel();
		BarPanel.setBackground(new Color(178, 34, 34));
		BarPanel.setBounds(320, 64, 933, 194);
		frmGymBreak.getContentPane().add(BarPanel);
		BarPanel.setLayout(null);
		
		
		lblTitulo.setFont(new Font("Swis721 Hv BT", Font.ITALIC, 97));
		lblTitulo.setBounds(24, 13, 807, 143);
		BarPanel.add(lblTitulo);
		
		JPanel TopBar = new JPanel();
		TopBar.setBackground(new Color(60, 60, 60));
		TopBar.setBounds(320, 0, 933, 65);
		frmGymBreak.getContentPane().add(TopBar);
		TopBar.setLayout(null);
		
		
		JLabel DragThingy = new JLabel("");
		DragThingy.setBounds(-320, 0, 1253, 65);
		TopBar.add(DragThingy);
		DragThingy.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX=e.getX();
				mouseY=e.getY();
			}
		});
		DragThingy.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent evt) {
				int coorX=evt.getXOnScreen();
				int coorY=evt.getYOnScreen();
				
				frmGymBreak.setLocation(coorX-mouseX, coorY);
			}
		});
	}

	protected void eleminarall() {
		frmGymBreak.remove(MostrarClientesJPanel);
		frmGymBreak.remove(AñadirClienteJPanel);
		
	}
}
