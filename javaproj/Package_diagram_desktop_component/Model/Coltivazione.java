package Package_diagram_desktop_component.Model;

import java.util.*;

public class Coltivazione {

	ImpiegatiNotifier handler_notifiche;
	Area_Coltivata area;
	Descrizione_Coltivazione descrizione;
	private String stato;
	private Date data_prossima_operazione;

	public Coltivazione() {
		
	}
	
	public void getAreaColtivata() {
		// TODO - implement Coltivazione.getAreaColtivata
		throw new UnsupportedOperationException();
	}

	public void modificaAmbiente() {
		// TODO - implement Coltivazione.modificaAmbiente
		throw new UnsupportedOperationException();
	}

	public String getTipo() {
		// TODO - implement Coltivazione.getTipo
		throw new UnsupportedOperationException();
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public Date getData_prossima_operazione() {
		return data_prossima_operazione;
	}

	public void setData_prossima_operazione(Date data_prossima_operazione) {
		this.data_prossima_operazione = data_prossima_operazione;
	}

}