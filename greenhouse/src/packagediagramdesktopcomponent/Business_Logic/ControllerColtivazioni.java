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
		//old
		/*if (sezione != -1)
		{
			Sezione sez = s.getSezioneByID(sezione);
			if(sez != null)
			{
				ricercaHelper(tipo, posizione, fila, coltbus, sez);			
			}
		}
		else 
		{
			for(Sezione sez:s.sezioni)
				ricercaHelper(tipo, posizione, fila, coltbus, sez);
		}*/
		for(Coltivazione c : colts) 
		{
			AreaColtivata a = c.getAreaColtivata();
			ColtivazioneBusiness cb = new ColtivazioneBusiness(c.getID(),a.getSezione().getID(),
					a.getFila(),a.getPosizione(),c.getTipo(),c.getStato(),c.getData_prossima_operazione());
			coltbus.add(cb);
		}
		
		return coltbus;
			
		
		//throw new UnsupportedOperationException();
	}
	
	public static DettagliBusiness getDettagliColtivazione(int id)
	{
		Coltivazione colt;
		try {
			colt = Coltivazione.getColtivazioneByORMID(id);
			DescrizioneColtivazione descr = colt.getDescrizione();
			AreaColtivata ar = colt.getArea();
			Ambiente amb = ar.getAmbiente();
			DettagliBusiness b = new DettagliBusiness(descr.getDescrizione(),amb.getTemperaturaTarget(),amb.getUmiditaSuoloTarget(),amb.getIrradianzaTarget());
			//if(colt.getTipo().equals("pomodori"))
			return b;
			//else return null;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		}	
	}

}