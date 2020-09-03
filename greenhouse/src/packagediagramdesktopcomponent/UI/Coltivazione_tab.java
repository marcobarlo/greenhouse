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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 681, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		this.setResizable(false);
		
		JLabel lblTipo = new JLabel("Tipo: ");
		lblTipo.setBounds(34, 103, 329, 14);
		contentPane.add(lblTipo);

		JLabel lblSezione = new JLabel("Sezione: ");
		lblSezione.setBounds(34, 193, 380, 14);
		contentPane.add(lblSezione);

		JLabel lblRiga = new JLabel("Riga: ");
		lblRiga.setBounds(34, 63, 329, 14);
		contentPane.add(lblRiga);

		JLabel lblPosizioneNellaRiga = new JLabel("Posizione: ");
		lblPosizioneNellaRiga.setBounds(34, 148, 309, 14);
		contentPane.add(lblPosizioneNellaRiga);

		JLabel lblDescrizione = new JLabel("Descrizione: ");
		lblDescrizione.setBounds(32, 228, 576, 33);
		contentPane.add(lblDescrizione);

		JLabel lblTemp = new JLabel("Temperatura: ");
		lblTemp.setBounds(462, 283, 163, 14);
		contentPane.add(lblTemp);

		JLabel lblUmidita = new JLabel("Umidità: ");
		lblUmidita.setBounds(34, 283, 172, 14);
		contentPane.add(lblUmidita);

		JLabel lblluce = new JLabel("Irradianza: ");
		lblluce.setBounds(272, 283, 142, 14);
		contentPane.add(lblluce);
		
		JLabel dettagli = new JLabel("Dettagli Coltivazione");
		dettagli.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dettagli.setHorizontalAlignment(SwingConstants.TRAILING);
		dettagli.setBounds(248, 25, 187, 25);
		contentPane.add(dettagli);
		
		
		JLabel errorLabel = new JLabel("<html>Oops! Si è verificato un errore<br>si prega chiudere la finestra<br>");
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		errorLabel.setBounds(183, 121, 345, 125);
		contentPane.add(errorLabel);
		
		JButton modificaAmbientebutton = new JButton("Modifica Parametri Ambientali");
		modificaAmbientebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					List<Integer> colts = new ArrayList<Integer>();
					colts.add( colt.getID_coltivazione());
					ModificaAmbienteTab mod = new ModificaAmbienteTab(colts);
					mod.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		modificaAmbientebutton.setHorizontalAlignment(SwingConstants.RIGHT);
		modificaAmbientebutton.setBounds(248, 343, 187, 32);
		contentPane.add(modificaAmbientebutton);
		errorLabel.setVisible(false);
		
		DettagliBusiness dett= ControllerFacade.getDettagliColtivazione(colt.getID_coltivazione());
		if (dett == null) 
		{
			errorLabel.setVisible(true);
		}
		else
		{
			lblTipo.setText("Tipo: "+colt.getTipo());
			lblSezione.setText("Sezione: "+colt.getSezione());
			lblRiga.setText("Fila: "+colt.getFila());
			lblPosizioneNellaRiga.setText("Posizione: "+colt.getPosizione());
			lblDescrizione.setText("<html>Descrizione: "+dett.getDescrizione());
			lblTemp.setText("Temperatura: "+dett.getTemperatura_target());
			lblUmidita.setText("Umidità: "+dett.getUmidita_target());
			lblluce.setText("Irradianza: "+dett.getIrradianza_target());
		}
	}
} 