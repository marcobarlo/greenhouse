package nulla_piu_assoluto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.awt.event.ActionEvent;

import package_diagram_desktop_component.Business_Logic;


public class Research_Tab extends JFrame {

	private JPanel contentPane;
	private JTextField rigaTextField;
	private JTextField tipoTextField;
	private JTextField sezioneTextField;
	private JTextField posizioneTextField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Research_Tab frame = new Research_Tab();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	private int getInt(String text)
	{
		if( !text.equals(""))
		{
			return -1;
		}
		else
		{
			int number;
			try {number=Integer.parseInt(text);}
			catch(NumberFormatException e)
			{number = -1;}
			return number;
		}
	}
	public Research_Tab() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("tipo");
		lblNewLabel.setBounds(34, 22, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblSezione = new JLabel("sezione");
		lblSezione.setBounds(252, 22, 46, 14);
		contentPane.add(lblSezione);
		
		JLabel lblRiga = new JLabel("riga");
		lblRiga.setBounds(34, 55, 46, 14);
		contentPane.add(lblRiga);
		
		JLabel lblPosizioneNellaRiga = new JLabel("posizione nella riga");
		lblPosizioneNellaRiga.setBounds(194, 55, 105, 14);
		contentPane.add(lblPosizioneNellaRiga);
		
		rigaTextField = new JTextField();
		rigaTextField.setBounds(80, 52, 86, 20);
		contentPane.add(rigaTextField);
		rigaTextField.setColumns(10);
		
		tipoTextField = new JTextField();
		tipoTextField.setBounds(80, 19, 86, 20);
		contentPane.add(tipoTextField);
		tipoTextField.setColumns(10);
		
		sezioneTextField = new JTextField();
		sezioneTextField.setBounds(294, 19, 86, 20);
		contentPane.add(sezioneTextField);
		sezioneTextField.setColumns(10);
		
		posizioneTextField = new JTextField();
		posizioneTextField.setBounds(294, 52, 86, 20);
		contentPane.add(posizioneTextField);
		posizioneTextField.setColumns(10);
		
		JButton btnNewButton = new JButton("Ricerca coltivazione");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tipo, pos,sez,row;
				int posizione,sezione,fila;
				tipo = tipoTextField.getText();
				pos=posizioneTextField.getText();
				posizione=getInt(pos);
				sezione=getInt(sez);
				fila=getInt(row);
				//Set<Coltivazione_Business> colts= new HashSet<Coltivazione_Business>();
				//colts=Controller_Facade.ricercaColtivazione(tipo, sezione,posizione,fila);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				for(Coltivazione_Business c: colts)
				{
					model.insertRow(model.getRowCount(), new Object[] {c.ID_coltivazione.toString(),c.data_prossima_op.toString(), c.fila.toString(),
					c.posizione.toString(), c.tipo.toString(), c.stato.toString(),c.sezione.toString()});
				}
			}
		});
		btnNewButton.setBounds(152, 80, 146, 14);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 130, 414, 109);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Sezione", "Fila", "Posizione", "Tipo", "Stato", "Data Prossima Op"
			}
		));
	}
}
