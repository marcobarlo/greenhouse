package packagediagramdesktopcomponent.UI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.orm.PersistentException;

import packagediagramdesktopcomponent.Business_Logic.*;
import packagediagramdesktopcomponent.Connection.MexAggiornaParametri;

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
	private JLabel lblIrrAttuale;
	private JLabel lblUmiAttuale;
	private JLabel lblTempAttuale;
	private DettagliBusiness dett;
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

		JLabel lblUmidita = new JLabel("Umidit�: ");
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
		
		
		JLabel errorLabel = new JLabel("<html>Oops! Si � verificato un errore<br>si prega chiudere la finestra<br>");
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
		modificaAmbientebutton.setBounds(200, 351, 249, 32);
		contentPane.add(modificaAmbientebutton);
		
		lblUmiAttuale = new JLabel("Umidit\u00E0 attuale: In attesa...");
		lblUmiAttuale.setBounds(34, 326, 172, 14);
		contentPane.add(lblUmiAttuale);
		
		lblIrrAttuale = new JLabel("Irradianza Attuale: In attesa...");
		lblIrrAttuale.setBounds(272, 326, 163, 14);
		contentPane.add(lblIrrAttuale);
		
		lblTempAttuale = new JLabel("Temperatura Attuale: In attesa...");
		lblTempAttuale.setBounds(462, 326, 163, 14);
		contentPane.add(lblTempAttuale);
		errorLabel.setVisible(false);
		
		dett= ControllerFacade.getDettagliColtivazione(colt.getID_coltivazione());
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
			lblUmidita.setText("Umidit�: "+dett.getUmidita_target());
			lblluce.setText("Irradianza: "+dett.getIrradianza_target());
		}
		
		EventBus.getDefault().register(this);
		
		this.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent e) 
		    {
				EventBus.getDefault().unregister(this);
				ControllerFacade.sendClosedMex(dett.getIdAmbiente(), colt.getSezione());
				System.out.println("Mi deregistro");
		        e.getWindow().dispose();
		    }
		});
		
	}
	
	@Subscribe(threadMode = ThreadMode.BACKGROUND)
	public void onEvent(MexAggiornaParametri event)
	{
		if(event.getId()== dett.getIdAmbiente())
		{
			this.lblTempAttuale.setText("Temperatura attuale: "+event.getTemp());
			this.lblUmiAttuale.setText("Umidit� attuale: "+event.getUmi());
			this.lblIrrAttuale.setText("Irradianza attuale: "+event.getIrr());
		}
	}
} 