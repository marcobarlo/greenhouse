package packagediagramdesktopcomponent.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Main_Frame extends JFrame {

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
					Main_Frame frame = new Main_Frame(new Thread());
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
	public Main_Frame(Thread t) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		this.setExtendedState( this.getExtendedState()|JFrame.MAXIMIZED_BOTH );
		setLayout(null);
		
		JButton searchButton = new JButton("Cerca una coltivazione");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ricercaColtivazione();
			}
		});
		searchButton.setBounds(34, 27, 163, 23);
		add(searchButton);
		
		
		this.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent e) 
		    {
		        e.getWindow().dispose();
		        t.interrupt();
		        System.out.println("Shutting down Mainframe...");
		    }
		});
		
	}

}
