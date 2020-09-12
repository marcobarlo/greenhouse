package packagediagramdesktopcomponent.UI;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import packagediagramdesktopcomponent.Main;
import packagediagramdesktopcomponent.Business_Logic.ControllerFacade;
import packagediagramdesktopcomponent.Connection.MexAllarme;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Rectangle;
import java.awt.Toolkit;

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

		try {
			Research_Tab frameRes = new Research_Tab();
			frameRes.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Main_Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1439, 889);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setExtendedState( this.getExtendedState()|JFrame.MAXIMIZED_BOTH );
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setSize(contentPane.getMaximumSize());
		contentPane.setBounds(new Rectangle(100, 100, screenSize.width, screenSize.height));
		setContentPane(contentPane);

		Frame frame = this;
		
		getContentPane().setLayout(null);
		
		
		JLabel lblWelcome = new JLabel("New label");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblWelcome.setBounds(422, 371, 502, 28);
		contentPane.add(lblWelcome);
		lblWelcome.setVisible(false);
		
		JLabel lblError = new JLabel("New label");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblError.setBounds(422, 328, 502, 82);
		contentPane.add(lblError);
		lblError.setVisible(false);
		
		JButton searchButton = new JButton("Cerca una coltivazione");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblError.setVisible(false);
				lblWelcome.setVisible(false);
				ricercaColtivazione();
			}
		});
		contentPane.setLayout(null);
		searchButton.setBounds(34, 27, 163, 23);
		getContentPane().add(searchButton);
		
		JLabel lblMail = new JLabel("Email:");
		lblMail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMail.setBounds(433, 191, 109, 28);
		contentPane.add(lblMail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(433, 234, 109, 28);
		contentPane.add(lblPassword);
		
		txtMail = new JTextField();
		txtMail.setBounds(591, 197, 177, 20);
		contentPane.add(txtMail);
		txtMail.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(591, 240, 177, 20);
		contentPane.add(txtPass);
		txtPass.setColumns(10);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblError.setVisible(false);
				lblWelcome.setText("Hai eseguito il log out!");
				lblWelcome.setVisible(true);
				ControllerFacade.logOut();
				btnLogOut.setVisible(false);
				//contentPane.dispatchEvent(new WindowEvent(,WindowEvent.WINDOW_CLOSED));
				Frame[] lf=Frame.getFrames();
				for(Frame f : lf)
				{
					if(!f.equals(frame))
						f.dispose();
				}
			}
		});
		btnLogOut.setBounds(277, 27, 163, 23);
		btnLogOut.setVisible(false);
		contentPane.add(btnLogOut);

		
		JButton btnLogin = new JButton("Log in");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblError.setVisible(false);
				lblWelcome.setVisible(false);
				String mail= txtMail.getText();
				String pass= txtPass.getText();
				if(mail.equals("") || pass.equals(""))
				{
					lblError.setText("Errore! Inserisci i campi mail e password!");
					lblError.setVisible(true);
				}
				else
				{
					String role=ControllerFacade.login(mail,pass);
					if(role!=null)
					{
						lblWelcome.setText("Benvenuto "+role+" "+ mail);
						lblWelcome.setVisible(true);
						btnLogOut.setVisible(true);
					}
					else
					{
						lblError.setText("Email o password errati!");
						lblError.setVisible(true);					
						btnLogOut.setVisible(false);
					}
				}
			}
		});
		btnLogin.setBounds(600, 297, 155, 23);
		contentPane.add(btnLogin);
		
		EventBus.getDefault().register(this);
		
		this.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent e) 
		    {
				lblError.setVisible(false);
				lblWelcome.setVisible(false);
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
