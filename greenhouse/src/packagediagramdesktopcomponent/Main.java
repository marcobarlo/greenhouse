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
		/*try {
			Process process = new ProcessBuilder("D:\\Programmi\\mosquitto\\mosquitto.exe", "-v").start();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
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
				int id=0,sez=0;
				float sTemp=0, sUmi=0, sIrr =0;
				
				id=  parseInt(eElement, "ID");
				sez= parseInt(eElement, "sezione");
				sTemp = parseFloat(eElement, "sogliaTemp");
				sUmi  = parseFloat(eElement, "sogliaUmi");
				sIrr  = parseFloat(eElement, "sogliaIrr");
				
				String mac =eElement.getElementsByTagName("mac").item(0).getTextContent();
				mac=mac.replaceAll(":", "").replaceAll("-", "");
				
				//System.out.println("Main : ID : " + id + "- mac :"+ mac);
				Configurazione c = new Configurazione(id, mac, sez,  sTemp,  sUmi,  sIrr);
				conn.sendSetUp(c);
			}
		}
	}
	private static Float parseFloat(Element eElement, String name) {
		try {return Float.parseFloat(eElement.getElementsByTagName(name).item(0).getTextContent().replaceAll(" ", ""));}
		catch(NumberFormatException e)
		{e.printStackTrace(); System.out.println("File di configurazione errato!!!!"); return null;}
	}
	private static Integer parseInt(Element eElement, String name) {
		try {return Integer.parseInt(eElement.getElementsByTagName(name).item(0).getTextContent().replaceAll(" ", ""));}
		catch(NumberFormatException e)
		{e.printStackTrace(); System.out.println("File di configurazione errato!!!!"); return null;}
	}
}
