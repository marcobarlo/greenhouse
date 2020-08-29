package Package_diagram_desktop_component.Business_Logic;

import Package_diagram_desktop_component.Model.*;

import java.util.*;

public class Controller_coltivazioni {

	/**
	 * 
	 * @param nome
	 * @param sezione
	 * @param posizione
	 * @param fila
	 */
	public static List<Coltivazione_Business> ricercaColtivazione(String tipo, int sezione, int posizione, int fila) {
		// TODO - implement Controller_coltivazioni.ricercaColtivazione
		
		if (sezione != -1)
		{
			Serra s = Serra.getInstance();
			List <Coltivazione> colt = new ArrayList<Coltivazione>();
			colt = s.ricercaColtivazioni(tipo, sezione, posizione, fila);
			List<Coltivazione_Business> bus_colt = new ArrayList<Coltivazione_Business>();
			for(Coltivazione c : colt) 
			{
				Coltivazione_Business temp = new Coltivazione_Business(c);
				bus_colt.add(temp);
			}
			return bus_colt;
		}
			
		
		throw new UnsupportedOperationException();
	}

}