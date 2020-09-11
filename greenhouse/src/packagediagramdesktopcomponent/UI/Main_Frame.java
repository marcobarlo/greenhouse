package packagediagramdesktopcomponent.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import packagediagramdesktopcomponent.Main;
import packagediagramdesktopcomponent.Connection.MexAllarme;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class Main_Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMail;
	private JTextField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Frame frame = new Main_Frame();
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
	public void ricercaColtivazione() {
	// TODO - implement Main_Frame.ricercaColtivazione
//		throw new UnsupportedOperationException();
		try {
			Research_Tab frameRes = new Research_Tab();
			frameRes.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Main_Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setSize(contentPane.getMaximumSize());
		setContentPane(contentPane);
		this.setExtendedState( this.getExtendedState()|JFrame.MAXIMIZED_BOTH );
		getContentPane().setLayout(null);
		
		JButton searchButton = new JButton("Cerca una coltivazione");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ricercaColtivazione();
			}
		});
		contentPane.setLayout(null);
		searchButton.setBounds(34, 27, 163, 23);
		getContentPane().add(searchButton);
		
		JLabel lblMail = new JLabel("Email:");
		lblMail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMail.setBounds(232, 190, 109, 28);
		contentPane.add(lblMail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(232, 233, 109, 28);
		contentPane.add(lblPassword);
		
		txtMail = new JTextField();
		txtMail.setBounds(382, 196, 177, 20);
		contentPane.add(txtMail);
		txtMail.setColumns(10);
		
		txtPass = new JTextField();
		txtPass.setBounds(382, 239, 177, 20);
		contentPane.add(txtPass);
		txtPass.setColumns(10);
		
		JLabel lblError = new JLabel("New label");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblError.setBounds(211, 97, 399, 82);
		contentPane.add(lblError);
		lblError.setVisible(false);
		
		JButton btnLogin = new JButton("Log in");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblError.setVisible(false);
				String mail= lblMail.getText();
				String pass= lblPassword.getText();
				if(mail.equals("") || pass.equals(""))
				{
					lblError.setText("Errore! Inserisci i campi mail e password!");
					lblError.setVisible(true);
				}
				else
				{
					//String role=ControllerFacade.login(mail,pass);
					//if(role.equals(""));
					//{}
				}
			}
		});
		btnLogin.setBounds(345, 149, 155, 23);
		contentPane.add(btnLogin);

		
		EventBus.getDefault().register(this);
		
		this.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent e) 
		    {
				lblError.setVisible(false);
		        e.getWindow().dispose();
		        System.out.println("Shutting down Mainframe...");
		        Main.shutdown();
		    }
		});
		
	}
	@Subscribe(threadMode = ThreadMode.BACKGROUND)
	public void onEvent(MexAllarme event)
	{
		JOptionPane optionPane = new JOptionPane(event.getMex() + "\nAmbiente : "+ event.getIdAmbiente()+
				" \nSezione: "+event.getIdSez()+ " \nColtivazione: "+event.getIdColt()+" -"+event.getTipo(), JOptionPane.WARNING_MESSAGE);
		JDialog dialog = optionPane.createDialog(null, event.getMex() + "\nAmbiente : "+ event.getIdAmbiente()+
				" \nSezione: "+event.getIdSez()+ " \nColtivazione: "+event.getIdColt()+" -"+event.getTipo());
		dialog.setModal(false);
		dialog.setTitle("Attenzione! Malfunzionamento!");
		dialog.setVisible(true);
	}
}
