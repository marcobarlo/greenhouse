package packagediagramdesktopcomponent.Business_Logic;

import java.util.*;

import org.orm.PersistentException;

import packagediagramdesktopcomponent.Connection.Connection;
import packagediagramdesktopcomponent.model.*;


public class ControllerColtivazioni {

	/**
	 * 
	 * @param nome
	 * @param sezione
	 * @param posizione
	 * @param fila
	 */
	protected static List<ColtivazioneBusiness> ricercaColtivazione(String tipo, int sezione, int posizione, int fila) 
	{
		List<ColtivazioneBusiness> coltbus = new ArrayList<ColtivazioneBusiness>();
		Serra s = Serra.getInstance();
		//new
		List<Integer> coltsID;
		coltsID =	s.ricercaColtivazione(tipo,sezione,posizione, fila);
		for(Integer id : coltsID) 
		{
			Coltivazione c;
			
			try {c = Coltivazione.getColtivazioneByORMID(id);}
			catch (PersistentException e) {continue;}
			
			ColtivazioneBusiness cb = new ColtivazioneBusiness(c.getID(),c.getSezione(),
					c.getFila(),c.getPosizione(),c.getTipo(),c.getStato(),c.getData_prossima_operazione());
			coltbus.add(cb);
		}
		
		return coltbus;
			
	}
	
	protected static DettagliBusiness getDettagliColtivazione(int id)
	{
		Coltivazione colt;
		try {
			colt = Coltivazione.getColtivazioneByORMID(id);
			int sez= colt.getSezione();
			int amb = colt.getIDAmbiente();
			Connection conn = Connection.getInstance();
			conn.richiediParametriAmbientali(amb,sez);
			
			DettagliBusiness b = new DettagliBusiness(colt.getDescrizione(),colt.getTemperaturaTarget(),colt.getUmiditaTarget(),colt.getIrradianzaTarget(),amb);
			return b;
		} catch (PersistentException e) {
			return null;
		}	
	}

}