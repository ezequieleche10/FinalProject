package Desktop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTable;

import Entidades.Ejercicio;
import Entidades.Profesor;
import Negocio.Controlador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class EjerciciosDesktop extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtCantItems;
	private JTextField txtPorcentaje;
	private JTable tablaEjercicios;
	private ArrayList<Ejercicio> le;
	private JTextArea txtDescripcion;
	private Controlador contr;
	private JLabel lblNombre;
	private JLabel lblCantidadItems;
	private JLabel lblPorcentaje;
	private JLabel lblDescripcion;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public EjerciciosDesktop(Controlador cont, int cod_examen, JLabel estadoEjercicio) {
		contr=cont;
		le = new ArrayList<Ejercicio>();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 1;
		contentPane.add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 1;
		contentPane.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		lblDescripcion = new JLabel("Descripci\u00F3n");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 3;
		gbc_lblDescripcion.gridy = 1;
		contentPane.add(lblDescripcion, gbc_lblDescripcion);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 4;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		txtDescripcion = new JTextArea();
		scrollPane.setViewportView(txtDescripcion);
		
		lblCantidadItems = new JLabel("Cantidad Items");
		GridBagConstraints gbc_lblCantidadItems = new GridBagConstraints();
		gbc_lblCantidadItems.anchor = GridBagConstraints.EAST;
		gbc_lblCantidadItems.insets = new Insets(0, 0, 5, 5);
		gbc_lblCantidadItems.gridx = 1;
		gbc_lblCantidadItems.gridy = 2;
		contentPane.add(lblCantidadItems, gbc_lblCantidadItems);
		
		txtCantItems = new JTextField();
		GridBagConstraints gbc_txtCantItems = new GridBagConstraints();
		gbc_txtCantItems.insets = new Insets(0, 0, 5, 5);
		gbc_txtCantItems.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCantItems.gridx = 2;
		gbc_txtCantItems.gridy = 2;
		contentPane.add(txtCantItems, gbc_txtCantItems);
		txtCantItems.setColumns(10);
		
		lblPorcentaje = new JLabel("Porcentaje");
		GridBagConstraints gbc_lblPorcentaje = new GridBagConstraints();
		gbc_lblPorcentaje.anchor = GridBagConstraints.EAST;
		gbc_lblPorcentaje.insets = new Insets(0, 0, 5, 5);
		gbc_lblPorcentaje.gridx = 1;
		gbc_lblPorcentaje.gridy = 3;
		contentPane.add(lblPorcentaje, gbc_lblPorcentaje);
		
		txtPorcentaje = new JTextField();
		GridBagConstraints gbc_txtPorcentaje = new GridBagConstraints();
		gbc_txtPorcentaje.insets = new Insets(0, 0, 5, 5);
		gbc_txtPorcentaje.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPorcentaje.gridx = 2;
		gbc_txtPorcentaje.gridy = 3;
		contentPane.add(txtPorcentaje, gbc_txtPorcentaje);
		txtPorcentaje.setColumns(10);
		
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCantidadItems.setForeground(Color.BLACK);
				lblDescripcion.setForeground(Color.BLACK);
				lblNombre.setForeground(Color.BLACK);
				lblPorcentaje.setForeground(Color.BLACK);
				
				if (Integer.parseInt(txtPorcentaje.getText().toString())>100 || Integer.parseInt(txtPorcentaje.getText().toString())<1)
				{
					JOptionPane.showMessageDialog(null, "El valor del Porcentaje no corresponde con el rango aceptado", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
				if(validar())
				{
				Ejercicio ej = new Ejercicio(txtNombre.getText().toString(), txtDescripcion.getText().toString(), Integer.parseInt(txtCantItems.getText().toString()), Integer.parseInt(txtPorcentaje.getText().toString()));
				le.add(ej);
		        cargarTabla(le);
		        limpiarCampos();
				}
				}
				
			}
		});
		GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
		gbc_btnAgregar.gridwidth = 2;
		gbc_btnAgregar.anchor = GridBagConstraints.EAST;
		gbc_btnAgregar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAgregar.gridx = 6;
		gbc_btnAgregar.gridy = 4;
		contentPane.add(btnAgregar, gbc_btnAgregar);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridheight = 3;
		gbc_scrollPane_1.gridwidth = 7;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 5;
		contentPane.add(scrollPane_1, gbc_scrollPane_1);
		
		tablaEjercicios = new JTable();
		scrollPane_1.setViewportView(tablaEjercicios);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 6;
		gbc_btnCancelar.gridy = 8;
		contentPane.add(btnCancelar, gbc_btnCancelar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				TableModel te=	tablaEjercicios.getModel();
				int cols = te.getColumnCount(); 
				int filas = te.getRowCount();
				int valor = 0;
				int tot = 0;
				ArrayList<Ejercicio> ejercicios= new ArrayList<Ejercicio>();
				for(int i=0; i<filas; i++) {
					tot = tot + Integer.parseInt(te.getValueAt(i,3).toString());
					}
				if (tot==100)
				{
					for(int i=0; i<filas; i++) {
					Ejercicio eje = new Ejercicio();
				for(int j=0; j<cols; j++){ 
					switch(j){
				case 0: eje.setNombre(te.getValueAt(i,j).toString());break;
				case 1: eje.setDescripcion(te.getValueAt(i,j).toString());break;
				case 2: eje.setCant_items(Integer.parseInt(te.getValueAt(i,j).toString())); break;
				case 3: eje.setPorcentaje(Integer.parseInt(te.getValueAt(i,j).toString()));break;
				
				
					}
					
				}
				ejercicios.add(eje);
				}
				try {
					//llamar al controlador para que agregue el arraylist de ejercicios
					contr.agregarEjercicios(ejercicios, cod_examen);
					estadoEjercicio.setText("Ejercicios cargados");
					estadoEjercicio.setForeground(Color.BLACK);
					dispose();
				  
				} catch (Exception el) {
					
					el.printStackTrace();
				}
			}
		
		
		else
			{
			JOptionPane.showMessageDialog(null, "La sumatoria de los porcentajes de la totalidad de los ejericios no es 100%", "Error", JOptionPane.ERROR_MESSAGE);
			}
				}});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 7;
		gbc_btnGuardar.gridy = 8;
		contentPane.add(btnGuardar, gbc_btnGuardar);
	}
	
	public void cargarTabla(ArrayList<Ejercicio> le){
		XTableModelEjercicios modelo= new XTableModelEjercicios();
		modelo.setDatasource(le);
		tablaEjercicios.getTableHeader().setReorderingAllowed(false);
		tablaEjercicios.setModel(modelo);
		
		
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
		if (txtDescripcion.getText().toString().equals(""))
		{	//mensaje+="Debe generar comision \n";
			lblDescripcion.setForeground(Color.RED);
			e=false;
		}
		if (txtCantItems.getText().toString().equals(""))
		{	//mensaje+="Debe generar comision \n";
			lblCantidadItems.setForeground(Color.RED);
			e=false;
		}
		if (txtPorcentaje.getText().toString().equals(""))
		{	//mensaje+="Debe generar comision \n";
			lblPorcentaje.setForeground(Color.RED);
			e=false;
		}
		return e;
	}
	
	public void limpiarCampos()
	{
		txtNombre.setText("");
		txtDescripcion.setText("");
		txtCantItems.setText("");
		txtPorcentaje.setText("");
	}

}
