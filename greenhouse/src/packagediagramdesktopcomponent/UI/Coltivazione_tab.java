package packagediagramdesktopcomponent.UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.orm.PersistentException;

import packagediagramdesktopcomponent.Business_Logic.*;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class Coltivazione_tab extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Coltivazione_tab frame = new Coltivazione_tab(new ColtivazioneBusiness());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws PersistentException 
	 */
	public Coltivazione_tab(ColtivazioneBusiness colt) throws PersistentException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);

		JLabel lblTipo = new JLabel("Tipo: ");
		lblTipo.setBounds(34, 62, 105, 14);
		contentPane.add(lblTipo);

		JLabel lblSezione = new JLabel("Sezione: ");
		lblSezione.setBounds(34, 109, 70, 14);
		contentPane.add(lblSezione);

		JLabel lblRiga = new JLabel("Riga: ");
		lblRiga.setBounds(34, 36, 119, 14);
		contentPane.add(lblRiga);

		JLabel lblPosizioneNellaRiga = new JLabel("Posizione: ");
		lblPosizioneNellaRiga.setBounds(34, 87, 105, 14);
		contentPane.add(lblPosizioneNellaRiga);

		JLabel lblDescrizione = new JLabel("Descrizione: ");
		lblDescrizione.setBounds(34, 134, 319, 14);
		contentPane.add(lblDescrizione);

		JLabel lblTemp = new JLabel("Temperatura: ");
		lblTemp.setBounds(272, 177, 119, 14);
		contentPane.add(lblTemp);

		JLabel lblUmidita = new JLabel("Umidità: ");
		lblUmidita.setBounds(34, 177, 92, 14);
		contentPane.add(lblUmidita);

		JLabel lblluce = new JLabel("Irradianza: ");
		lblluce.setBounds(155, 177, 88, 14);
		contentPane.add(lblluce);
		
		JLabel dettagli = new JLabel("Dettagli Coltivazione");
		dettagli.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dettagli.setHorizontalAlignment(SwingConstants.TRAILING);
		dettagli.setBounds(137, 11, 187, 25);
		contentPane.add(dettagli);
		
		
		JLabel errorLabel = new JLabel("<html>Oops! Si è verificato un errore<br>si prega di chiudere la finestra<br>");
		errorLabel.setBackground(SystemColor.window);
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		errorLabel.setBounds(46, 62, 345, 125);
		contentPane.add(errorLabel);
		errorLabel.setVisible(false);
		
		DettagliBusiness dett= ControllerFacade.getDettagliColtivazione(colt.getID_coltivazione());
		if (dett == null) 
		{
			//TODO : getdettaglicoltivazione può ritornare un nullo se la query non è andata a buon fine	
			contentPane.removeAll();
			contentPane.add(errorLabel);
			errorLabel.setVisible(true);
		}
		else
		{
		lblTipo.setText("Tipo: "+colt.getTipo());
		lblSezione.setText("Sezione: "+colt.getSezione());
		lblRiga.setText("Fila: "+colt.getFila());
		lblPosizioneNellaRiga.setText("Posizione: "+colt.getPosizione());
		lblDescrizione.setText("Descrizione: "+dett.getDescrizione());
		lblTemp.setText("Temperatura: "+dett.getTemperatura_target());
		lblUmidita.setText("Umidità: "+dett.getUmidita_target());
		lblluce.setText("Irradianza: "+dett.getIrradianza_target());
		}
	}
} 