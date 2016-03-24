package Desktop;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;







import Entidades.Usuario;
import Negocio.Controlador;
import Negocio.Opcion;
import Negocio.Opcion.eleccionMenu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.GridBagLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;

public class PrincipalDesktop extends JFrame {

	private JPanel contentPane;
	private Controlador cont;
	public int valorLayo=0;
	public static Opcion.eleccionMenu opc;
	private JMenu mnExamenesIngreso;
	private JMenu mnExamenes;
	private JMenu mnArchivo;
	private JMenuBar menuBar;
	private Usuario usu;
	private JMenuItem mnuCargarAlumnos;
	private JMenuItem mntmListarAlumnos;

	

	 
	public PrincipalDesktop(Controlador contr,Usuario usua) throws Exception {
		setResizable(false);
		usu=usua;
		cont=contr;
		opc=eleccionMenu.VACIO;
		setTitle("Bienvenidos Instituto Olga Cossettini");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 650);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panelPpal = new JPanel();
		contentPane.add(panelPpal);
	
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		menuBar.add( Box.createHorizontalStrut( 10 ) );  //this will add a 10 pixel space
		
		mnExamenesIngreso= new JMenu("Examenes Ingreso");
		menuBar.add(mnExamenesIngreso);
		menuBar.add( Box.createHorizontalStrut( 10 ) );  //this will add a 10 pixel space
		
		JMenu mnAlumnos = new JMenu("Alumnos");
		mnExamenesIngreso.add(mnAlumnos);
		
		JMenuItem mnCargarSigae = new JMenuItem("Cargar SIGAE");
		mnCargarSigae.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelCargaAlumnos panelTA= new PanelCargaAlumnos(cont, panelPpal);
				panelPpal.add(panelTA,"Panel carga alumnos");
				CardLayout cl = (CardLayout)(panelPpal.getLayout());
			      cl.show(panelPpal, "Panel carga alumnos");			  
			}
		});
		mnAlumnos.add(mnCargarSigae);
		
		JMenuItem mnCargarNotas = new JMenuItem("Cargar Notas");
		mnCargarNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valorLayo=1;
				opc=eleccionMenu.VERNOTA;
				PanelCargaNotas panelCargar;
				try {
					panelCargar = new PanelCargaNotas(cont,panelPpal,1);
					panelPpal.add(panelCargar,"Panel carga notas");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				CardLayout cl = (CardLayout)(panelPpal.getLayout());
			      cl.show(panelPpal, "Panel carga notas");
			      
			      
			}
		});
		mnAlumnos.add(mnCargarNotas);
		
		JMenuItem mnVerNotas = new JMenuItem("Ver Notas");
		mnVerNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelVerNotas panelVerNotas= new PanelVerNotas(cont,panelPpal);
				panelPpal.add(panelVerNotas,"Panel ver notas");
				CardLayout cl = (CardLayout)(panelPpal.getLayout());
			      cl.show(panelPpal, "Panel ver notas");
			   
			}
		});
		mnAlumnos.add(mnVerNotas);
		
		JMenu mnProfesores = new JMenu("Profesores");
		mnExamenesIngreso.add(mnProfesores);
		
		JMenuItem mnAgregarProfesores = new JMenuItem("Agregar");
		mnAgregarProfesores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProfesorDesktop prof = new ProfesorDesktop(cont);
				prof.setVisible(true);
				prof.setLocationRelativeTo(null);//la centra
			    prof.setMinimumSize(new Dimension(500,300));
			  
			}
		});
		
		mnProfesores.add(mnAgregarProfesores);
		
		JMenu mnExamenes = new JMenu("Examenes");
		mnExamenesIngreso.add(mnExamenes);
		
		JMenuItem mnAgregarExamen = new JMenuItem("Agregar Examen");
		mnAgregarExamen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ExamenDesktop exam = new ExamenDesktop(cont);
				exam.setVisible(true);
				exam.setLocationRelativeTo(null);//la centra
				exam.setMinimumSize(new Dimension(500,300));
			}
		});
		mnExamenes.add(mnAgregarExamen);
		
		JMenuItem mnAlumnosEnCondiciones = new JMenuItem("Alumnos en Condiciones");
		mnAlumnosEnCondiciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelListarAlumnos panelGE= new PanelListarAlumnos(cont,panelPpal);
				panelPpal.add(panelGE,"Panel lista alumnos");
				CardLayout cl = (CardLayout)(panelPpal.getLayout());
			      cl.show(panelPpal, "Panel lista alumnos");
				valorLayo=1;
			}
		});
		mnExamenes.add(mnAlumnosEnCondiciones);
		
		JMenuItem mnGenerarExamen = new JMenuItem("Generar Examen");
		mnGenerarExamen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			PanelGenerarExamen panelGenerar= new PanelGenerarExamen(cont,panelPpal);
			panelPpal.add(panelGenerar,"Panel genera examen");
			CardLayout cl = (CardLayout)(panelPpal.getLayout());
		      cl.show(panelPpal, "Panel genera examen");
			}
		});
		mnExamenes.add(mnGenerarExamen);
		//define panel	
		
		JPanel panelCargarAlumnos= new JPanel(new GridLayout());
		JLabel lblHola= new JLabel();
		lblHola.setText("Soy el panel que carga los alumnos");
		panelCargarAlumnos.add(lblHola);
		JPanel panelListarAlumnos= new JPanel( new GridLayout());
			
		panelPpal.setLayout(new CardLayout(0, 0));
		//Pon los paneles en el panel con el CardLayout

		JPanel panelNulo= new JPanel();
		panelPpal.add(panelNulo,"Panel nulo");
		
		
		/*mntmListarAlumnos = new JMenuItem("Listar Alumnos");
		mntmListarAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout)(panelPpal.getLayout());
			      cl.show(panelPpal, "Panel que lista alumnos");
			 
			}
		});
		mnArchivo.add(mntmListarAlumnos);*/
		
		JMenuItem mnuAcercaDe = new JMenuItem("Acerca de...");
		/*mnuAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});*/
		mnArchivo.add(mnuAcercaDe);
		
		JMenuItem mnuCerrar = new JMenuItem("Cerrar");
		mnuCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mnArchivo.add(mnuCerrar);
		
		menuBar.add( Box.createHorizontalStrut( 10 ) );
		JMenu mnCursos = new JMenu("Cursos");
		menuBar.add(mnCursos);
		menuBar.add( Box.createHorizontalStrut( 10 ) );
		JMenu mntmCooperadora = new JMenu("Cooperadora");
		menuBar.add(mntmCooperadora);
		
		validarUsuario();
	}

	private void validarUsuario() {
		// TODO Auto-generated method stub
		if(usu.getTipo_Usuario()==2){
			this.mnExamenes.setVisible(false);
			this.mnExamenesIngreso.setVisible(false);
			this.mntmListarAlumnos.setVisible(false);
			this.mnuCargarAlumnos.setVisible(false);
		}		
	}
}
