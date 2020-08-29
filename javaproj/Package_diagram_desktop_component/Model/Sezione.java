package Package_diagram_desktop_component.Model;

import java.util.*;

public class Sezione {

	List<Area_Coltivata> aree;
	private int identificativo;

	public int getIdentificativo() {
		return identificativo;
	}


	public void setIdentificativo(int identificativo) {
		this.identificativo = identificativo;
	}


	/**
	 * 
	 * @param nome
	 */
	public List<Coltivazione> ricercaColtivazione(String tipo, int posizione, int fila) {
		// TODO - implement Sezione.ricercaColtivazione
		List<Coltivazione> colt = new ArrayList<Coltivazione>();
		for(Area_Coltivata temp : aree) 
		{
			if ( temp.getTipoColtivazione().equals(tipo))
				if(temp.getFila() == fila)
					if(temp.getPosizione() == posizione)
						colt.add(temp.coltivazione);
		}
		return colt;
		
		//throw new UnsupportedOperationException();
	}

}