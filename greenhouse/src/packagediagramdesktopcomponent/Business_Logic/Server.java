package packagediagramdesktopcomponent.Business_Logic;

import java.io.File;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.orm.PersistentException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import packagediagramdesktopcomponent.Configurazione;
import packagediagramdesktopcomponent.Connection.Connection;

public class Server implements FacadeServer {

	public static Registry registry = null;
	private static Server esempioImpl;
	public static Server getInstance() {return esempioImpl;}
	public static void main(String args[]) {

		
		
		try {
			/*
			 * nota
			 * 
			 * il registry si dovrebbe avviare tramite rmiregistry.exe
			 * nella cartella bin del jdk o jre
			 * 
			 * per farlo le classi devono essere nel CLASSPATH del registry
			 * 
			 * poiche' bisogna impostarlo a mano, lo creo qui in modo che
			 * sicuramente e' impostato
			 * 
			 * vedi
			 * http://stackoverflow.com/questions/14071885/java-rmi-unmarshalexception-error-unmarshalling-arguments-nested-exception-is
			 */
			registry = LocateRegistry.createRegistry(1099);
			
			esempioImpl = new Server();
			FacadeServer esempioStub = (FacadeServer) UnicastRemoteObject.exportObject(esempioImpl, 0);
			Registry registry = LocateRegistry.getRegistry();
			registry.rebind("esempio", esempioStub);
			System.out.println("Server ready");
			

				
				//read config file
				NodeList nList = null;
				String host=null;
				String clientID=null;
				Document doc=readConfig();
				host =doc.getElementsByTagName("brokerHost").item(0).getTextContent();
				nList = doc.getElementsByTagName("device");	
				clientID = doc.getElementsByTagName("clientID").item(0).getTextContent();
				//startup the connection with broker
				Connection conn = Connection.getInstance();
				conn.startup(host, clientID);
				
				//send config packets
				sendConfig(nList, conn);
				
				
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<ColtivazioneBusiness> ricercaColtivazione(String nome, int sezione, int posizione, int fila) {
		return ControllerColtivazioni.ricercaColtivazione(nome, sezione, posizione, fila);
}

	public boolean modificaAmbiente(int id, Float temperatura, Float umidita, Float irradianza) {
			return ControllerParametriAmbientali.modificaAmbiente(id, temperatura, umidita, irradianza);
	}

	public DettagliBusiness getDettagliColtivazione(int idColtivazione){
			return ControllerColtivazioni.getDettagliColtivazione(idColtivazione);
	}

	public void modificaAmbienteAttuale(int id, float temperatura, float umidita, float irradianza) {
		ControllerParametriAmbientali.modificaAmbienteAttuale(id, temperatura, umidita, irradianza);
		
	}
	
	public DettagliBusiness getParametriAmbiente(int idAmbiente)
	{
		return ControllerParametriAmbientali.getParametriAmbiente(idAmbiente);
	}

	public void sendClosedMex(int idAmbiente, int sez)
	{
		ControllerParametriAmbientali.sendClosedMex(idAmbiente,sez);
	}
	
	public void sendAllarme(int code,int idAmbiente)
	{
		ControllerParametriAmbientali.sendAllarme(code,idAmbiente);
	}
	public void sendAllarme(int code,int idAmbiente, float delta)
	{
		ControllerParametriAmbientali.sendAllarme(code,idAmbiente,delta);
	}
	public String login(String mail, String pass)
	{
		return ControllerUtenti.login(mail,pass);
	}
	public String getSessionRole()
	{
		return ControllerUtenti.getSessionRole();
	}

	public void logOut() {
		ControllerUtenti.logOut();
	}

	private static Document readConfig()
	{
		try {
			File fXmlFile = new File("config.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			return doc;
	    	} 
		catch (Exception e) 
	    {e.printStackTrace();
	    System.out.println("Errore nella lettura del file di configurazione!");
	    return null;}
	}
	private static void sendConfig(NodeList nList,Connection conn)
	{
		for (int i = 0; i < nList.getLength(); i++) 
		{
			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) 
			{
				Element eElement = (Element) nNode;
				int id=0,sez=0;
				
				id=  parseInt(eElement, "ID");
				sez= parseInt(eElement, "sezione");
				
				String mac =eElement.getElementsByTagName("mac").item(0).getTextContent();
				mac=mac.replaceAll(":", "").replaceAll("-", "");
				
				//System.out.println("Main : ID : " + id + "- mac :"+ mac);
				Configurazione c = new Configurazione(id, mac, sez);
				conn.sendSetUp(c);
			}
		}
	}
	private static Integer parseInt(Element eElement, String name) {
		try {return Integer.parseInt(eElement.getElementsByTagName(name).item(0).getTextContent().replaceAll(" ", ""));}
		catch(NumberFormatException e)
		{e.printStackTrace(); System.out.println("File di configurazione errato!!!!"); return null;}
	}

}

/* TODO: 
deregistrare il server alla chiusura ... ps come si chiude il server??
gestire la chiusura dell' interfaccia e gestire meglio le eccezioni nella classe controllerfacade
gestire il client quando il server è giu
gestire meglio la chiamata al singleton del server...assicurarsi che sia già assegnato
gestire ack connection e conflitti sulla connection
*/