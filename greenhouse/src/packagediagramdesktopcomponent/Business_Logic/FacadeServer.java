package packagediagramdesktopcomponent.Business_Logic;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

//import org.orm.PersistentException;

public interface FacadeServer extends Remote {

	public List<ColtivazioneBusiness> ricercaColtivazione(String nome, int sezione, int posizione, int fila) throws RemoteException;

	public boolean modificaAmbiente(int id, Float temperatura, Float umidita, Float irradianza) throws RemoteException;

	public DettagliBusiness getDettagliColtivazione(int idColtivazione) throws RemoteException;

	public void modificaAmbienteAttuale(int id, float temperatura, float umidita, float irradianza)throws RemoteException;
	
	public DettagliBusiness getParametriAmbiente(int idAmbiente) throws RemoteException;

	public void sendClosedMex(int idAmbiente, int sez) throws RemoteException;
	
	public void sendAllarme(int code,int idAmbiente) throws RemoteException;
	
	public void sendAllarme(int code,int idAmbiente, float delta) throws RemoteException;
	
	public String login(String mail, String pass) throws RemoteException;
	
	public String getSessionRole() throws RemoteException;

	public void logOut() throws RemoteException;

}
