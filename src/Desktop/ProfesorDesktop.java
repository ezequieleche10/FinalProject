package Desktop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Panel;

import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JButton;

import Negocio.Controlador;
import Negocio.Opcion.eleccionMenu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProfesorDesktop extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtFecha_Nac;
	private JTextField txtUsuario;
	private JTextField txtClave;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblFechaDeNacimiento;
	private JLabel lblUsuario;
	private JLabel lblClave;
	private JLabel lblRepetirClave;
	private JTextField txtRepetirClave;
//	private Controlador cont;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ProfesorDesktop(Controlador cont) {
		setResizable(false);
	
		setTitle("Profesores");
		//al cancelar o cerrar con la x , solo se cierra el JFrame
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos del profesor", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{98, 79, 88, 87, 90, 81, 0};
		gbl_panel.rowHeights = new int[]{0, 14, 24, 0, 23, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.1, 0.0, 0.1, 1.0, 0.3, 0.3, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		contentPane.add(panel);
		
		lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		panel.add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.gridwidth = 2;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 1;
		gbc_txtNombre.gridy = 1;
		panel.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		
		lblUsuario = new JLabel("Usuario:");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 3;
		gbc_lblUsuario.gridy = 1;
		panel.add(lblUsuario, gbc_lblUsuario);
		
		txtUsuario = new JTextField();
		GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
		gbc_txtUsuario.gridwidth = 2;
		gbc_txtUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_txtUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsuario.gridx = 4;
		gbc_txtUsuario.gridy = 1;
		panel.add(txtUsuario, gbc_txtUsuario);
		txtUsuario.setColumns(10);
		
		lblApellido = new JLabel("Apellido:");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.anchor = GridBagConstraints.EAST;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 0;
		gbc_lblApellido.gridy = 3;
		panel.add(lblApellido, gbc_lblApellido);
		
		txtApellido = new JTextField();
		GridBagConstraints gbc_txtApellido = new GridBagConstraints();
		gbc_txtApellido.gridwidth = 2;
		gbc_txtApellido.insets = new Insets(0, 0, 5, 5);
		gbc_txtApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellido.gridx = 1;
		gbc_txtApellido.gridy = 3;
		panel.add(txtApellido, gbc_txtApellido);
		txtApellido.setColumns(10);
		
		lblClave = new JLabel("Clave:");
		GridBagConstraints gbc_lblClave = new GridBagConstraints();
		gbc_lblClave.anchor = GridBagConstraints.EAST;
		gbc_lblClave.insets = new Insets(0, 0, 5, 5);
		gbc_lblClave.gridx = 3;
		gbc_lblClave.gridy = 3;
		panel.add(lblClave, gbc_lblClave);
		
		txtClave = new JPasswordField();
		GridBagConstraints gbc_txtClave = new GridBagConstraints();
		gbc_txtClave.gridwidth = 2;
		gbc_txtClave.insets = new Insets(0, 0, 5, 0);
		gbc_txtClave.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtClave.gridx = 4;
		gbc_txtClave.gridy = 3;
		panel.add(txtClave, gbc_txtClave);
		txtClave.setColumns(10);
		
		lblFechaDeNacimiento = new JLabel("Fecha de Nac.:");
		GridBagConstraints gbc_lblFechaDeNacimiento = new GridBagConstraints();
		gbc_lblFechaDeNacimiento.anchor = GridBagConstraints.EAST;
		gbc_lblFechaDeNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeNacimiento.gridx = 0;
		gbc_lblFechaDeNacimiento.gridy = 5;
		panel.add(lblFechaDeNacimiento, gbc_lblFechaDeNacimiento);
		
		txtFecha_Nac = new JTextField();
		GridBagConstraints gbc_txtFecha_Nac = new GridBagConstraints();
		gbc_txtFecha_Nac.gridwidth = 2;
		gbc_txtFecha_Nac.insets = new Insets(0, 0, 5, 5);
		gbc_txtFecha_Nac.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFecha_Nac.gridx = 1;
		gbc_txtFecha_Nac.gridy = 5;
		panel.add(txtFecha_Nac, gbc_txtFecha_Nac);
		txtFecha_Nac.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		lblRepetirClave = new JLabel("Repetir Clave:");
		GridBagConstraints gbc_lblRepetirClave = new GridBagConstraints();
		gbc_lblRepetirClave.anchor = GridBagConstraints.EAST;
		gbc_lblRepetirClave.insets = new Insets(0, 0, 5, 5);
		gbc_lblRepetirClave.gridx = 3;
		gbc_lblRepetirClave.gridy = 5;
		panel.add(lblRepetirClave, gbc_lblRepetirClave);
		
		txtRepetirClave = new JPasswordField();
		GridBagConstraints gbc_txtRepetirClave = new GridBagConstraints();
		gbc_txtRepetirClave.gridwidth = 2;
		gbc_txtRepetirClave.insets = new Insets(0, 0, 5, 0);
		gbc_txtRepetirClave.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRepetirClave.gridx = 4;
		gbc_txtRepetirClave.gridy = 5;
		panel.add(txtRepetirClave, gbc_txtRepetirClave);
		txtRepetirClave.setColumns(10);
		
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 4;
		gbc_btnCancelar.gridy = 6;
		panel.add(btnCancelar, gbc_btnCancelar);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(validar() )
				{
					if(txtClave.getText().equals(txtRepetirClave.getText()))
					{
						try {
								cont.agregarProfesor(txtNombre.getText(),txtApellido.getText(),txtFecha_Nac.getText(),txtUsuario.getText(),txtClave.getText());
								dispose();
							}
						catch (Exception e) 
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					}
					else
						JOptionPane.showMessageDialog(null, "Las claves ingresadas no son correctas");
				}
			}
	
		});
		GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
		gbc_btnAgregar.gridx = 5;
		gbc_btnAgregar.gridy = 6;
		panel.add(btnAgregar, gbc_btnAgregar);
		
		
	
	}
	public boolean validar()
	{
		boolean e = true;
		if (txtNombre.getText().toString().equals(""))
				//mensaje+="Debe cargar ejercicios \n";
		{
			lblNombre.setForeground(Color.RED);
			e=false;
		}
		if (txtApellido.getText().toString().equals(""))
		{	//mensaje+="Debe generar comision \n";
			lblApellido.setForeground(Color.RED);
			e=false;
		}
		if(txtFecha_Nac.getText().toString().equals(""))
		{	//mensaje+="Debe cargar la lista de alumnos \n";
			lblFechaDeNacimiento.setForeground(Color.RED);
			e=false;
		}
		if(txtUsuario.getText().toString().equals(""))
		{	//mensaje+="Debe cargar la lista de alumnos \n";
			lblUsuario.setForeground(Color.RED);
			e=false;
		}
		if(txtClave.getText().toString().equals(""))
		{	//mensaje+="Debe cargar la lista de alumnos \n";
			lblClave.setForeground(Color.RED);
			e=false;
		}
		if(txtRepetirClave.getText().toString().equals(""))
		{	//mensaje+="Debe cargar la lista de alumnos \n";
			lblRepetirClave.setForeground(Color.RED);
			e=false;
		}
		return e;
	}
	
}
