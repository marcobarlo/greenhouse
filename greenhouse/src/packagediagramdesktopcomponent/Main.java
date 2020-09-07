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
	   //conn.startup();
	   
		//read config file
	   try {
			File fXmlFile = new File("config.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
		
			//optional, but recommended
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();
		
			//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		
			NodeList nList = doc.getElementsByTagName("device");
		
			//System.out.println("----------------------------");
			
			for (int i = 0; i < nList.getLength(); i++) 
			{
				Node nNode = nList.item(i);
		
				//System.out.println("\nCurrent Element :" + nNode.getNodeName());
		
				if (nNode.getNodeType() == Node.ELEMENT_NODE) 
				{
		
					Element eElement = (Element) nNode;
					int id=0;
					try {id= Integer.parseInt(eElement.getElementsByTagName("ID").item(0).getTextContent().replaceAll(" ", ""));}
					catch(NumberFormatException e)
					{e.printStackTrace();}
					String mac =eElement.getElementsByTagName("mac").item(0).getTextContent();
					System.out.println("ID : " + id);
					System.out.println("mac : " + mac);
					//mettere qui l'invio del pacchetto con id e mac
					//conn.sendStartup(id, mac);
				}
			}
	    } catch (Exception e) 
	    {e.printStackTrace();}
	   
		//start UI
		
		Runnable r =conn;
		Thread t=new Thread(r);
		try {
			Main_Frame frame = new Main_Frame(t);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
