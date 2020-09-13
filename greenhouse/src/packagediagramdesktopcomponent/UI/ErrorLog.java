package packagediagramdesktopcomponent.UI;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class ErrorLog extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static ErrorLog instance;
	private final JScrollPane scrollPane = new JScrollPane();
	private DefaultListModel<String> listModel;
	/**
	 * Create the frame.
	 */
	private JList<String> list;
	private ErrorLog() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 680, 234);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setBounds(0, 0, 664, 195);
		contentPane.add(scrollPane);
		listModel = new DefaultListModel<String>();
		list = new JList<String>(listModel);
		list.setVisibleRowCount(10);
		scrollPane.setViewportView(list);
		this.setTitle("Log degli errori");
	}
	public static ErrorLog getInstance()
	{
		if(instance != null)
			return instance;
		else
			instance=new ErrorLog();
		return instance;
	}
	public void addError(String mex, int idAmbiente, int idSezione, int idColtivazione, String tipo)
	{
		String message = "*** "+mex+ "  -- Ambiente : "+ idAmbiente+
				" -- Sezione: "+idSezione+ " -- Coltivazione: "+idColtivazione+" -- Tipo: "+tipo + " ***";
		listModel.addElement(message);
		list = new JList<String>(listModel);
	}
	public void clean()
	{
		listModel.clear();
	}
}
