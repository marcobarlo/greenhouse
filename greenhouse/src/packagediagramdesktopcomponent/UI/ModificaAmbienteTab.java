package packagediagramdesktopcomponent.UI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import packagediagramdesktopcomponent.Business_Logic.ControllerFacade;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ModificaAmbienteTab extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					List<Integer> a = new ArrayList<Integer>();
					ModificaAmbienteTab frame = new ModificaAmbienteTab(a);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	    //Create and set up the window.
	    private JTextField umiTxt;
	    private JTextField tempTxt;
	    private JTextField irrTxt;

	/**
	 * Create the frame.
	 */
	private boolean validaValori(JLabel lblError,Float temp, Float umi,  Float irr)
	{
		if(temp!=null && (temp < -10 || temp >60))
		{
			lblError.setText("La temeperatura � fuori dal range, reinserisci un valore tra -10 e 60");
			lblError.setVisible(true);
			return false;
		}
		else if(umi!=null && (umi < 0 || umi >100))
		{
			lblError.setText("L'umidit� � fuori dal range, reinserisci un valore tra 0 e 100");
			lblError.setVisible(true);
			return false;
		}
		else if(irr!=null && (irr<25000 || irr>100000))
		{
			lblError.setText("L'irradianza � fuori dal range, reinserisci un valore tra 25000 e 100000");
			lblError.setVisible(true);
			return false;
		}
		return true;
	}
	
	private Float getFloat(String text)
	{
			Float number;
			try {number=Float.parseFloat(text);}
			catch(NumberFormatException e)
			{number = (Float) null;}
			return number;
	}
	public ModificaAmbienteTab(List<Integer> IDColtivazioni) {
	    //Display the window.
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setResizable(false);
		
		JLabel lblUmi = new JLabel("Umidit\u00E0: ");
		lblUmi.setBounds(53, 49, 80, 13);
		contentPane.add(lblUmi);
		
		JLabel lblTemp = new JLabel("Temperatura: ");
		lblTemp.setBounds(53, 104, 80, 13);
		contentPane.add(lblTemp);
		
		JLabel lblLux = new JLabel("Irradianza: ");
		lblLux.setBounds(53, 164, 80, 13);
		contentPane.add(lblLux);
		
		umiTxt = new JTextField();
		umiTxt.setBounds(188, 46, 96, 19);
		contentPane.add(umiTxt);
		umiTxt.setColumns(10);
		
		tempTxt = new JTextField();
		tempTxt.setColumns(10);
		tempTxt.setBounds(188, 101, 96, 19);
		contentPane.add(tempTxt);
		
		irrTxt = new JTextField();
		irrTxt.setColumns(10);
		irrTxt.setBounds(188, 161, 96, 19);
		contentPane.add(irrTxt);
		
		
		JLabel lblError = new JLabel("New label");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setBounds(48, 10, 378, 29);
		contentPane.add(lblError);
		lblError.setVisible(false);
		
		JButton modifyButt = new JButton("Modifica Parametri");
		modifyButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Float temp,umi,irr;
				List<Boolean> retval = new ArrayList<Boolean>();
				lblError.setVisible(false);
			
				
				temp=getFloat(tempTxt.getText());
				umi=getFloat(umiTxt.getText());
				irr=getFloat(irrTxt.getText());
				if(!(temp==null && umi==null && irr==null))
				{
					if(validaValori(lblError, temp,umi,irr))
					{
						//dialog box
						int dialogRes=JOptionPane.showConfirmDialog(null, "Sei sicuro di voler aggiornare i parametri?", "Attenzione!", JOptionPane.OK_CANCEL_OPTION);
						if(dialogRes==JOptionPane.OK_OPTION)
						{
							for(int IDColtivazione : IDColtivazioni)
							{
								retval.add(ControllerFacade.modificaAmbiente(IDColtivazione, temp, umi, irr));
							}
							
							if(!retval.contains(false))
							{
								lblError.setText("Modifica avvenuta con successo!");
								lblError.setVisible(true);
							}
							else
							{
								String error = new String("Problemi nel salvataggio dei parametri per le coltivazioni con ID:");
								for(int i = 0; i < IDColtivazioni.size(); i++) 
								{
									if(retval.get(i)==false)
										error = error + IDColtivazioni.get(i) + " ";
								}
								lblError.setText(error);
								lblError.setVisible(true);
							}	
							
						}
					}
				}
				else
				{
					lblError.setText("Non hai inserito alcun parametro, tutto invariato!");
					lblError.setVisible(true);
				}
			}
		});
		modifyButt.setBounds(171, 218, 143, 21);
		contentPane.add(modifyButt);

	}
}