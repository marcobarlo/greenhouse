package packagediagramdesktopcomponent.Business_Logic;

import packagediagramdesktopcomponent.Connection.*;

import org.orm.PersistentException;

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
			Connection conn = Connection.getInstance();
			if(conn.modificaAmbiente(c.getIDAmbiente(), temperatura, umidita, irradianza)) 
			{
				return c.modificaAmbiente(temperatura, umidita, irradianza);
			}
			else return false;
			
		} catch (PersistentException e) {
			return false;
		}
	}

}