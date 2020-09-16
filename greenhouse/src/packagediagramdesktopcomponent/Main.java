package packagediagramdesktopcomponent;

import packagediagramdesktopcomponent.Business_Logic.FacadeServer;
import packagediagramdesktopcomponent.UI.ControllerFacade;
import packagediagramdesktopcomponent.UI.Main_Frame;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Main {

	public static void main(String[] args) 
	{
		/*try {
			Process process = new ProcessBuilder("D:\\Programmi\\mosquitto\\mosquitto.exe", "-v").start();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		String hostRMI = "localhost";
		if(args.length > 0)
			hostRMI = args[0];
		
		try
		{
			Registry registry = LocateRegistry.getRegistry(hostRMI);
			FacadeServer stub = (FacadeServer) registry.lookup("esempio");
			
			//System.out.println("5+3=" + stub.add(5, 3));
			
			//OggettoDaPassare o = stub.copia(new OggettoDaPassare("ciao"));
			//System.out.println(o.contenuto);
			ControllerFacade.setReference(stub);
		}
		catch(Exception e) { e.printStackTrace(); }

		
		//start UI
		try{
			Main_Frame frame = new Main_Frame();
			frame.setVisible(true);
		} catch (Exception e)
		{e.printStackTrace();}
	}
	
/*		public static void shutdown()
	{
		Connection.getInstance().shutdown();
	}
	
	*/
}
