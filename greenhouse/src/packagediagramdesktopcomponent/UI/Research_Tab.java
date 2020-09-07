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
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;

import packagediagramdesktopcomponent.Business_Logic.*;


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
	
	private int getInt(JLabel lblError,String text)
	{
		int number;
		try {number=Integer.parseInt(text);}
		catch(NumberFormatException e)
		{
			number = -1;
			if(!text.equals(""))
			{
				lblError.setText("Errore, sezione, fila e posizione sono numeri positivi!");
				lblError.setVisible(true);
				throw e;
			}
		}
		return number;
	}
	
	private boolean validaValori(JLabel lblError,int sezione, int posizione,  int fila)
	{
		if(sezione==0 || sezione < -1)
		{
			lblError.setText("Errore, inserisci un identificativo di sezione positivo");
			lblError.setVisible(true);
			return false;
		}
		else if(posizione==0 || posizione < -1 )
		{
			lblError.setText("Errore, inserisci una posizione positiva");
			lblError.setVisible(true);
			return false;
		}
		else if(fila==0 || fila < -1 )
		{
			lblError.setText("Errore, inserisci una fila positiva");
			lblError.setVisible(true);
			return false;
		}
		return true;
	}
	
	public Research_Tab() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 559, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setResizable(false);
		
		JLabel lblNewLabel = new JLabel("tipo");
		lblNewLabel.setBounds(34, 22, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblSezione = new JLabel("sezione");
		lblSezione.setBounds(321, 22, 46, 14);
		contentPane.add(lblSezione);
		
		JLabel lblRiga = new JLabel("fila");
		lblRiga.setBounds(34, 55, 46, 14);
		contentPane.add(lblRiga);
		
		JLabel lblPosizioneNellaRiga = new JLabel("posizione nella riga");
		lblPosizioneNellaRiga.setBounds(257, 55, 131, 14);
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
		sezioneTextField.setBounds(388, 19, 86, 20);
		contentPane.add(sezioneTextField);
		sezioneTextField.setColumns(10);
		
		posizioneTextField = new JTextField();
		posizioneTextField.setBounds(388, 52, 86, 20);
		contentPane.add(posizioneTextField);
		posizioneTextField.setColumns(10);
		
		JLabel lblError = new JLabel("Errore");
		lblError.setBounds(20, 124, 501, 14);
		contentPane.add(lblError);
		lblError.setVisible(false);

		JButton btnNewButton = new JButton("Ricerca coltivazione");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tipo, pos,sez,row;
				int posizione,sezione,fila;
				tipo = tipoTextField.getText();
				pos=posizioneTextField.getText();
				sez=sezioneTextField.getText();
				row=rigaTextField.getText();
				lblError.setVisible(false);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int n_rows=model.getRowCount();
				for(int i=0; i<n_rows; i++)
				{
					model.removeRow(0);
				}
				try
				{
					posizione=getInt(lblError,pos);
					sezione=getInt(lblError,sez);
					fila=getInt(lblError,row);
					if (validaValori(lblError, sezione, posizione, fila)) 
					{
						if(tipo.equals("") && (sezione==-1))
						{
							lblError.setVisible(true);
							lblError.setText("Inserisci correttamente almeno uno dei campi tra sezione e tipo!!");
						}
						else if( (posizione!=-1) && (fila==-1))
						{
							lblError.setVisible(true);
							lblError.setText("Se inserisci la posizione devi inserire anche la fila!!");
						}
						else
						{
							if(tipo.equals(""))
								tipo=null;
							colts=(ArrayList<ColtivazioneBusiness>) ControllerFacade.ricercaColtivazione(tipo, sezione,posizione,fila);
							//System.out.println(colts.size());
							for(ColtivazioneBusiness c: colts)
							{
								model.insertRow(model.getRowCount(), new Object[] {String.valueOf(c.getID_coltivazione()),String.valueOf(c.getSezione()), String.valueOf(c.getFila()),
										String.valueOf(c.getPosizione()), String.valueOf(c.getTipo()),String.valueOf(c.getStato()),String.valueOf(c.getData_prossima_op())});
							}
						
						}
					}
				}
				catch(NumberFormatException e){}
			}
		});
		btnNewButton.setBounds(178, 80, 175, 30);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 149, 526, 214);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Sezione", "Fila", "Posizione", "Tipo", "Stato", "Data Prossima Op"
			}
		));
		
		JButton mostra = new JButton("Mostra dettagli");
		mostra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblError.setVisible(false);
				int n_rows=table.getSelectedRows().length;
				if(n_rows>1)
				{
					lblError.setVisible(true);
					lblError.setText("Devi selezionare una sola coltivazione per ottenerne i dettagli!!");
				}
				else
				{
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
			}
		});
		mostra.setBounds(36, 374, 175, 23);
		contentPane.add(mostra);
		
		JButton modificaParamAmb = new JButton("Modifica Parametri Ambientali");
		modificaParamAmb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblError.setVisible(false);
				int rows[] = table.getSelectedRows();
				List<Integer> ids = new ArrayList<Integer>();
				if(rows.length>0) 
				{
					for(int i=0 ; i< rows.length; i++)
						ids.add(colts.get(rows[i]).getID_coltivazione());
					try {
						ModificaAmbienteTab frame2 = new ModificaAmbienteTab(ids);
						frame2.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		modificaParamAmb.setBounds(336, 374, 175, 23);
		contentPane.add(modificaParamAmb);
				
		mostra.setVisible(false);
		modificaParamAmb.setVisible(false); 
		ListSelectionModel cellSelectionModel = table.getSelectionModel();
		  
		cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
		public void valueChanged(ListSelectionEvent e) {
		mostra.setVisible(true);
		modificaParamAmb.setVisible(true); }
		});

	
	}
}