package packagediagramdesktopcomponent.model;

import java.util.*;

import org.orm.PersistentException;

public class Serra {

	public List<Sezione> sezioni;
	Elenco_coltivazioni elenco_coltivazioni;
	private static Serra instance = null;

	private Serra() {
		Sezione sez[];
		SezioneCriteria sezcrit;
		try 
		{
			sezcrit = new SezioneCriteria();
			sez = sezcrit.listSezione();
			sezioni = Arrays.asList(sez);
		} 
		catch (PersistentException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static Serra getInstance() {
		if (instance == null)
			instance = new Serra();
		return instance;
	}
	
	public Sezione getSezione(int sezione) {
			return sezioni.get(sezione);
	}

	public Elenco_coltivazioni getElencoColtivazioni() {
		return elenco_coltivazioni;
	}

	public Sezione getSezioneByID(int sezioneID) {
		for(Sezione s: sezioni)
		{
			if(s.getID()==sezioneID)
			{
				return s;
			}
		}
		return null;
	}
}