package packagediagramdesktopcomponent.UI;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;
import java.awt.event.ActionEvent;

import packagediagramdesktopcomponent.Business_Logic.*;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;


public class Research_Tab extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField rigaTextField;
	private JTextField tipoTextField;
	private JTextField sezioneTextField;
	private JTextField posizioneTextField;
	private JTable table;
	private ArrayList<ColtivazioneBusiness> colts= new ArrayList<ColtivazioneBusiness>();
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
		if(text.equals(""))
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("tipo");
		lblNewLabel.setBounds(15, 22, 70, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblSezione = new JLabel("sezione");
		lblSezione.setBounds(198, 22, 90, 14);
		contentPane.add(lblSezione);
		
		JLabel lblRiga = new JLabel("fila");
		lblRiga.setBounds(15, 56, 70, 14);
		contentPane.add(lblRiga);
		
		JLabel lblPosizioneNellaRiga = new JLabel("posizione nella riga");
		lblPosizioneNellaRiga.setBounds(198, 56, 90, 14);
		contentPane.add(lblPosizioneNellaRiga);
		
		rigaTextField = new JTextField();
		rigaTextField.setBounds(85, 53, 86, 20);
		contentPane.add(rigaTextField);
		rigaTextField.setColumns(10);
		
		tipoTextField = new JTextField();
		tipoTextField.setBounds(85, 19, 86, 20);
		contentPane.add(tipoTextField);
		tipoTextField.setColumns(10);
		
		sezioneTextField = new JTextField();
		sezioneTextField.setBounds(294, 19, 86, 20);
		contentPane.add(sezioneTextField);
		sezioneTextField.setColumns(10);
		
		posizioneTextField = new JTextField();
		posizioneTextField.setBounds(294, 53, 86, 20);
		contentPane.add(posizioneTextField);
		posizioneTextField.setColumns(10);
		
		JLabel errorlbl = new JLabel("Errore");
		errorlbl.setBounds(15, 104, 409, 14);
		contentPane.add(errorlbl);
		errorlbl.setVisible(false);

		JButton btnNewButton = new JButton("Ricerca coltivazione");
		btnNewButton.setBounds(181, 79, 127, 14);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tipo, pos,sez,row;
				int posizione,sezione,fila;
				tipo = tipoTextField.getText();
				pos=posizioneTextField.getText();
				sez=sezioneTextField.getText();
				row=rigaTextField.getText();
				errorlbl.setVisible(false);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int n_rows=model.getRowCount();
				for(int i=0; i<n_rows; i++)
				{
					model.removeRow(0);
				}
				if(tipo.equals("") && sez.equals(""))
				{
					errorlbl.setVisible(true);
					errorlbl.setText("Inserisci almeno uno dei campi tra sezione e tipo!!");
				}
				else if( (!pos.equals("")) && row.equals(""))
				{
					errorlbl.setVisible(true);
					errorlbl.setText("Se inserisci la posizione nella fila devi inserirla!!");
				}
				else
				{
					posizione=getInt(pos);
					sezione=getInt(sez);
					fila=getInt(row);
					if(tipo.equals(""))
						tipo=null;
					Set<ColtivazioneBusiness> set=ControllerFacade.ricercaColtivazione(tipo, sezione,posizione,fila);
					colts= new ArrayList<ColtivazioneBusiness>(set);
					for(ColtivazioneBusiness c: colts)
					{
						model.insertRow(model.getRowCount(), new Object[] {String.valueOf(c.getID_coltivazione()),String.valueOf(c.getSezione()), String.valueOf(c.getFila()),
								String.valueOf(c.getPosizione()), String.valueOf(c.getTipo()),String.valueOf(c.getStato()),String.valueOf(c.getData_prossima_op())});
					}
				}
			}
		});
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 129, 409, 131);
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
		
		JButton mostra = new JButton("Mostra dettagli");
		mostra.setBounds(181, 237, 105, 23);
		mostra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row=table.getSelectedRow();
				if(row != -1)
				{
					
					try {
						Coltivazione_tab frame2 = new Coltivazione_tab(colts.get(row));
						frame2.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
		});
		contentPane.add(mostra);
		

		
		mostra.setVisible(false);
		  
		ListSelectionModel cellSelectionModel = table.getSelectionModel();
		  
		cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
		public void valueChanged(ListSelectionEvent e) {
		mostra.setVisible(true);}
		});

	
	}
}