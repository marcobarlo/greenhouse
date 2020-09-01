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
		if (sezione != -1)
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
	private static void ricercaHelper(String tipo, int posizione, int fila, Set<ColtivazioneBusiness> coltbus,
			Sezione sez) 
	{
		//get aree coltivate
		Set<AreaColtivata> aree_colt = sez.getAreeColtivate(posizione, fila);
		//per ogni area coltivata prendi la coltivazione
		
		for(AreaColtivata a : aree_colt) 
		{
			Coltivazione c = a.getColtivazione();
			//un'area coltivata non necessariamente ha una coltivazione posta
			if (c != null)
			{
				//se l'utente ha ricercato per tipo filtro anche per tale campo, altrimenti aggiungo la coltivazione a prescindere
				if (tipo != null) 
				{
					String t = c.getTipo();
					if (t.equals(tipo)) 
					{
						//crea l'oggetto Coltivazione_Business
						ColtivazioneBusiness cb = new ColtivazioneBusiness(c.getID(),sez.getID(),a.getFila(),a.getPosizione(),c.getTipo(),c.getStato(),c.getData_prossima_operazione());
						coltbus.add(cb);
					}
				}
				else
				{
					ColtivazioneBusiness cb = new ColtivazioneBusiness(c.getID(),sez.getID(),a.getFila(),a.getPosizione(),c.getTipo(),c.getStato(),c.getData_prossima_operazione());
					coltbus.add(cb);
				}
				
			}
		}
	}

}