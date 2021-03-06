package Desktop;

import javax.swing.JPanel;

import java.awt.GridLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import Entidades.Alumno;
import Negocio.Controlador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

public class PanelCargaAlumnos extends JPanel {
	private JTable table;
	private JTextField txtExaminar;
	private JButton btnAgregarAlumnos;
	private JButton btnProcesar;
	private JButton btnCancelar;

	/**
	 * Create the panel.
	 */
	public PanelCargaAlumnos(Controlador cont ,JPanel panel) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 607, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 336, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
	

		
		JLabel lblRuta = new JLabel("Ruta:");
		GridBagConstraints gbc_lblRuta = new GridBagConstraints();
		gbc_lblRuta.anchor = GridBagConstraints.EAST;
		gbc_lblRuta.insets = new Insets(0, 0, 5, 5);
		gbc_lblRuta.gridx = 1;
		gbc_lblRuta.gridy = 1;
		add(lblRuta, gbc_lblRuta);
		
		txtExaminar = new JTextField();
		GridBagConstraints gbc_txtExaminar = new GridBagConstraints();
		gbc_txtExaminar.insets = new Insets(0, 0, 5, 5);
		gbc_txtExaminar.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtExaminar.gridx = 2;
		gbc_txtExaminar.gridy = 1;
		add(txtExaminar, gbc_txtExaminar);
		txtExaminar.setColumns(10);
		
		JButton btnExaminarArchivo = new JButton("Examinar archivo");
		btnExaminarArchivo.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("XLS files", "xls");
				chooser.setFileFilter(filter);
				
				int returnVal = chooser.showOpenDialog(getComponentPopupMenu());
					if(returnVal == JFileChooser.APPROVE_OPTION) {
				         txtExaminar.setText(chooser.getSelectedFile().getPath());
				         if (!txtExaminar.getText().isEmpty())
				         {
				         btnProcesar.setVisible(true);
				         }
					      
					}
			}
		});
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 3;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		GridBagConstraints gbc_btnExaminarArchivo = new GridBagConstraints();
		gbc_btnExaminarArchivo.gridwidth = 2;
		gbc_btnExaminarArchivo.insets = new Insets(0, 0, 5, 5);
		gbc_btnExaminarArchivo.gridx = 3;
		gbc_btnExaminarArchivo.gridy = 1;
		add(btnExaminarArchivo, gbc_btnExaminarArchivo);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.setVisible(false);
	
		btnProcesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReadExcel leeArchivo= new ReadExcel();
				leeArchivo.setInputFile(txtExaminar.getText());
				try {
					ArrayList<Alumno> alumnosEnTabla=new ArrayList<Alumno>(); 
					alumnosEnTabla=leeArchivo.read();
					cargarTabla(alumnosEnTabla);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnProcesar = new GridBagConstraints();
		gbc_btnProcesar.gridwidth = 3;
		gbc_btnProcesar.insets = new Insets(0, 0, 5, 0);
		gbc_btnProcesar.gridx = 5;
		gbc_btnProcesar.gridy = 1;
		add(btnProcesar, gbc_btnProcesar);
		
		btnAgregarAlumnos = new JButton("Agregar alumnos");
		btnAgregarAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String mensaje;
			TableModel tm=	table.getModel();
			int cols = tm.getColumnCount(); 
			int filas = tm.getRowCount();
			ArrayList<Alumno> alums = new ArrayList<Alumno>();
			for(int i=0; i<filas; i++) { 
				Alumno alum = new Alumno();
			for(int j=0; j<cols; j++){ 
				switch(j){
			case 0: alum.setDni(Integer.parseInt(tm.getValueAt(i,j).toString()));break;
			case 1: alum.setApellido(tm.getValueAt(i,j).toString());break;
			case 2: alum.setNombre(tm.getValueAt(i,j).toString()); break;
			case 3: alum.setMail(tm.getValueAt(i,j).toString()); break;
			case 4: alum.setIngreso_directo(tm.getValueAt(i,j).toString());break;
			case 5: alum.setTurno_eleccion(tm.getValueAt(i,j).toString());break;
			case 6: alum.setNombre_Carrera(tm.getValueAt(i, j).toString());break;
				}
			}
			alums.add(alum);
			}
			try {
				if(validarDatos(alums))
				{
					if (validarDni(alums))
					{
						int carga = cont.agregarAlumnos(alums);
						if (carga == 1)
						{
							mensaje = "Los alumnos se agregaron satisfactoriamente!";
						}
						if (carga == 2)
						{
							mensaje = "Alguno de los alumnos que intenta cargar ya se encuentra registrado!";
						}
						else
						{
							mensaje = "Hubo un problema en la carga de alumnos!";
						}
						JOptionPane.showMessageDialog(null, mensaje);
		       			removeAll();
		       			repaint();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Alguno de los DNI ingresados est� no posee la longitud adecuada (8 numeros)");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Alguno de los campos ingresados est� incompleto");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			CardLayout cl = (CardLayout)(panel.getLayout());
		      cl.show(panel, "Panel por defecto");
		}});
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panel.getLayout());
				cl.show(panel, "Panel nulo");
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 4;
		gbc_btnCancelar.gridy = 4;
		add(btnCancelar, gbc_btnCancelar);
		
		GridBagConstraints gbc_btnAgregarAlumnos = new GridBagConstraints();
		gbc_btnAgregarAlumnos.gridwidth = 3;
		gbc_btnAgregarAlumnos.gridx = 5;
		gbc_btnAgregarAlumnos.gridy = 4;
		add(btnAgregarAlumnos, gbc_btnAgregarAlumnos);
		btnAgregarAlumnos.setEnabled(false);
		
		

	}
	public void cargarTabla(ArrayList<Alumno> alumnos){
		XTableModelAlumnos modelo= new XTableModelAlumnos();
		modelo.setDatasource(alumnos);
		table.getTableHeader().setReorderingAllowed(false);
		table.setModel(modelo);
		btnAgregarAlumnos.setEnabled(true);
	}
	
	public boolean validarDatos(ArrayList<Alumno> alumnos){
		boolean rta = true;
		for (int i =0; i<alumnos.size(); i++)
        {
            int dni = alumnos.get(i).getDni();
            String nombre = alumnos.get(i).getNombre();
            String apellido = alumnos.get(i).getApellido();
            String mail = alumnos.get(i).getMail();
            String ingDire = alumnos.get(i).getIngreso_directo();
            String turnElec = alumnos.get(i).getTurno_eleccion();
            String carrera = alumnos.get(i).getNombre_Carrera();
            String stringDni =  String.valueOf(dni);
            //definir datos obligatorios
            if (stringDni.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || mail.isEmpty() || ingDire.isEmpty() || turnElec.isEmpty() || carrera.isEmpty())
            {
            	rta = false;
            }
        }
		return rta;
	}
	
	public boolean validarDni(ArrayList<Alumno> alumnos)
	{
		boolean rta = true;
		for (int i=0; i<alumnos.size(); i++)
		{
			int dni = alumnos.get(i).getDni();
			String stringDni = String.valueOf(dni);
			if (stringDni.length() != 8)
			{
				rta = false;
			}
		}
		return rta;
	}
	

}
