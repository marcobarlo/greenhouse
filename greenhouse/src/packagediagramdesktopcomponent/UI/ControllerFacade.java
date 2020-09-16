package packagediagramdesktopcomponent.UI;

import java.rmi.RemoteException;
import java.util.List;
import org.orm.PersistentException;

import packagediagramdesktopcomponent.Business_Logic.ColtivazioneBusiness;
import packagediagramdesktopcomponent.Business_Logic.DettagliBusiness;
import packagediagramdesktopcomponent.Business_Logic.FacadeServer;

public class ControllerFacade {
	private static FacadeServer stub;
	public static void setReference(FacadeServer stubval)
	{
		stub=stubval;
	}
	
	public static List<ColtivazioneBusiness> ricercaColtivazione(String nome, int sezione, int posizione, int fila) {
		try {
			return stub.ricercaColtivazione(nome, sezione, posizione, fila);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
}

	public static boolean modificaAmbiente(int id, Float temperatura, Float umidita, Float irradianza) {
			try {
				return stub.modificaAmbiente(id, temperatura, umidita, irradianza);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
	}

	public static DettagliBusiness getDettagliColtivazione(int idColtivazione) throws PersistentException {
			try {
				return stub.getDettagliColtivazione(idColtivazione);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	}

	public static void modificaAmbienteAttuale(int id, float temperatura, float umidita, float irradianza) {
		try {
			stub.modificaAmbienteAttuale(id, temperatura, umidita, irradianza);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static DettagliBusiness getParametriAmbiente(int idAmbiente)
	{
		try {
			return stub.getParametriAmbiente(idAmbiente);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static void sendClosedMex(int idAmbiente, int sez)
	{
		try {
			stub.sendClosedMex(idAmbiente,sez);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void sendAllarme(int code,int idAmbiente)
	{
		try {
			stub.sendAllarme(code,idAmbiente);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void sendAllarme(int code,int idAmbiente, float delta)
	{
		try {
			stub.sendAllarme(code,idAmbiente,delta);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String login(String mail, String pass)
	{
		try {
			return stub.login(mail,pass);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public static String getSessionRole()
	{
		try {
			return stub.getSessionRole();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static void logOut() {
		try {
			stub.logOut();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}