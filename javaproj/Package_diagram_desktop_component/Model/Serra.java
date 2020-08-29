package Package_diagram_desktop_component.Model;

import java.util.*;

public class Serra {

	List<Sezione> sezioni;
	Elenco_coltivazioni elenco_coltivazioni;
	private static Serra instance = null;

	public static Serra getInstance() {
		if (instance == null)
			instance = new Serra();
		return instance;
	}
	
	/**
	 * 
	 * @param nome
	 * @param sezione
	 */
	public List<Coltivazione> ricercaColtivazioni(String tipo, int sezione, int posizione, int fila) {
		// TODO - implement Serra.ricercaColtivazioni
		Sezione sez = new Sezione();
		sez = getSezione(sezione);
		List<Coltivazione> colt = new ArrayList<Coltivazione>();
		colt = sez.ricercaColtivazione(tipo,sezione,posizione);
		return colt;
		
		//throw new UnsupportedOperationException();
	}

	
	
	/**
	 * 
	 * @param sezione
	 */
	public Sezione getSezione(int sezione) {
		// TODO - implement Serra.getSezione
		throw new UnsupportedOperationException();
	}

	public Elenco_coltivazioni getElencoColtivazioni() {
		// TODO - implement Serra.getElencoColtivazioni
		throw new UnsupportedOperationException();
	}
	
	private Serra() {
		
	}

}