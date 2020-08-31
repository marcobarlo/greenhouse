package interfacce;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import packagediagramdesktopcomponent.Business_Logic.*;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame(ColtivazioneBusiness colt) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(34, 22, 46, 14);
		contentPane.add(lblTipo);
		
		JLabel lblSezione = new JLabel("Sezione");
		lblSezione.setBounds(252, 22, 46, 14);
		contentPane.add(lblSezione);
		
		JLabel lblRiga = new JLabel("Riga");
		lblRiga.setBounds(34, 55, 46, 14);
		contentPane.add(lblRiga);
		
		JLabel lblPosizioneNellaRiga = new JLabel("Posizione");
		lblPosizioneNellaRiga.setBounds(194, 55, 105, 14);
		contentPane.add(lblPosizioneNellaRiga);
		
		JLabel lblDescrizione = new JLabel("Descrizione");
		lblDescrizione.setBounds(34, 55, 46, 14);
		contentPane.add(lblDescrizione);
		
		JLabel lblTemp = new JLabel("Temperatura");
		lblTemp.setBounds(34, 55, 46, 14);
		contentPane.add(lblTemp);
		
		JLabel lblUmidita = new JLabel("Umidità");
		lblUmidita.setBounds(34, 55, 46, 14);
		contentPane.add(lblUmidita);
		
		JLabel lblluce = new JLabel("Irradianza");
		lblluce.setBounds(34, 55, 46, 14);
		contentPane.add(lblluce);
		
		DettagliBusiness dett= ControllerFacade.getDettagliColtivazione(colt.getID_coltivazione());
		
		
	}

}