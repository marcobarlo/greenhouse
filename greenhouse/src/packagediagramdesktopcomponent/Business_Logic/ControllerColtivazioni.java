package packagediagramdesktopcomponent.Business_Logic;

import java.util.*;

import org.orm.PersistentException;

import packagediagramdesktopcomponent.model.*;


public class ControllerColtivazioni {

	/**
	 * 
	 * @param nome
	 * @param sezione
	 * @param posizione
	 * @param fila
	 */
	public static Set<ColtivazioneBusiness> ricercaColtivazione(String tipo, int sezione, int posizione, int fila) 
	{
		Set<ColtivazioneBusiness> coltbus = new HashSet<ColtivazioneBusiness>();
		Serra s = Serra.getInstance();
		//new
		Set<Coltivazione> colts;
		colts =	s.ricercaColtivazione(tipo,sezione,posizione, fila);
	
		for(Coltivazione c : colts) 
		{
			ColtivazioneBusiness cb = new ColtivazioneBusiness(c.getID(),c.getSezione(),
					c.getFila(),c.getPosizione(),c.getTipo(),c.getStato(),c.getData_prossima_operazione());
			coltbus.add(cb);
		}
		
		return coltbus;
			
	}
	
	public static DettagliBusiness getDettagliColtivazione(int id)
	{
		Coltivazione colt;
		try {
			colt = Coltivazione.getColtivazioneByORMID(id);
			DettagliBusiness b = new DettagliBusiness(colt.getDescrizione(),colt.getTemperaturaTarget(),colt.getUmiditaTarget(),colt.getIrradianzaTarget());
			return b;
		} catch (PersistentException e) {
			return null;
		}	
	}

}