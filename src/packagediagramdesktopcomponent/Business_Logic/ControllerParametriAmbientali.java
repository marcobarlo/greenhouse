package packagediagramdesktopcomponent.Business_Logic;

import packagediagramdesktopcomponent.Connection.*;

import org.orm.PersistentException;

import packagediagramdesktopcomponent.model.Ambiente;
import packagediagramdesktopcomponent.model.Coltivazione;

public class ControllerParametriAmbientali {

	/**
	 * 
	 * @param coltivaz
	 * @param temp
	 * @param irradianza
	 * @param umdita
	 */
	public static boolean modificaAmbiente(int id, Float temperatura, Float umidita, Float irradianza) {
		Coltivazione c;
		
		try {			
			if(temperatura == null || umidita == null || irradianza == null)
			{
				DettagliBusiness dbus = ControllerColtivazioni.getDettagliColtivazione(id);
				if(temperatura == null)
					temperatura = dbus.getTemperatura_target();
				if(umidita == null)
					umidita = dbus.getUmidita_target();
				if(irradianza == null)
					irradianza = dbus.getIrradianza_target();
			}
			c = Coltivazione.getColtivazioneByORMID(id);
			int sez= c.getSezione();
			Connection conn = Connection.getInstance();
			if(conn.modificaAmbiente(c.getIDAmbiente(), temperatura, umidita, irradianza,sez)) 
			{
				return c.modificaAmbiente(temperatura, umidita, irradianza);
			}
			else return false;
			
		} catch (PersistentException e) {
			return false;
		}
	}

	public static void modificaAmbienteAttuale(int id, float temperatura, float umidita, float irradianza) {
		Ambiente amb;
		try {
			amb = Ambiente.getAmbienteByORMID(id);
			if(amb !=null)
				amb.modificaAmbienteAttuale(temperatura, umidita, irradianza);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public static DettagliBusiness getParametriTarget(int idAmbiente)
	{
		DettagliBusiness b;
		try {
			Ambiente a= Ambiente.getAmbienteByORMID(idAmbiente);
			if(a != null)
			{
				b=new DettagliBusiness(null, a.getTemperaturaTarget(),a.getUmiditaSuoloTarget(), a.getIrradianzaTarget(),a.getID());
				return b;
			}else
				return null;
		} catch (PersistentException e) {
			e.printStackTrace();	
			return null;
		}
	}
	
	public static void sendClosedMex(int idAmbiente, int sez)
	{
		Connection conn= Connection.getInstance();
		if(!conn.sendStop(idAmbiente, sez))
			System.out.println("Errore nell'invio del messaggio di stop!!");
	}

}