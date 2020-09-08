package packagediagramdesktopcomponent;

import packagediagramdesktopcomponent.Connection.Connection;
import packagediagramdesktopcomponent.UI.Main_Frame;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;


public class Main {

	public static void main(String[] args) 
	{
		//startup the connection with broker
		Connection conn = Connection.getInstance();
		conn.startup();
   
		//read config file
		NodeList nList = readConfig();
		//send config packets
		sendConfig(nList, conn);
		
		//start UI
		Thread t=conn.getThread();
		try{
			Main_Frame frame = new Main_Frame(t);
			frame.setVisible(true);
		} catch (Exception e)
		{e.printStackTrace();}

	}
	private static NodeList readConfig()
	{
		try {
			File fXmlFile = new File("config.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		
			NodeList nList = doc.getElementsByTagName("device");
			return nList;
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
				int id=0;
				try {id= Integer.parseInt(eElement.getElementsByTagName("ID").item(0).getTextContent().replaceAll(" ", ""));}
				catch(NumberFormatException e)
				{e.printStackTrace(); System.out.println("File di configurazione errato!!!!");}
				String mac =eElement.getElementsByTagName("mac").item(0).getTextContent();
				mac=mac.replaceAll(":", "");
				mac=mac.replaceAll("-", "");	
				System.out.println("Main : ID : " + id + "- mac :"+ mac);
				conn.sendStartup(id, mac);
			}
		}
	}
}
