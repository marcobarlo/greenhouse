package packagediagramdesktopcomponent.Business_Logic;

import java.util.List;
import org.orm.PersistentException;

public class ControllerFacade {

	/**
	 * 
	 * @param nome
	 * @param sezione
	 * @param posizione
	 * @param fila
	 */
	public static List<ColtivazioneBusiness> ricercaColtivazione(String nome, int sezione, int posizione, int fila) {
		return ControllerColtivazioni.ricercaColtivazione(nome, sezione, posizione, fila);
}

	/**
	 * 
	 * @param coltivaz
	 * @param temp
	 * @param irradianza
	 * @param umdita
	 */
	public static boolean modificaAmbiente(int id, Float temperatura, Float umidita, Float irradianza) {
			return ControllerParametriAmbientali.modificaAmbiente(id, temperatura, umidita, irradianza);
	}

	/**
	 * 
	 * @param idColtivazione
	 * @throws PersistentException 
	 */
	public static DettagliBusiness getDettagliColtivazione(int idColtivazione) throws PersistentException {
			return ControllerColtivazioni.getDettagliColtivazione(idColtivazione);
	}

	public static void modificaAmbienteAttuale(int id, float temperatura, float umidita, float irradianza) {
		ControllerParametriAmbientali.modificaAmbienteAttuale(id, temperatura, umidita, irradianza);
		
	}
	
	public static DettagliBusiness getParametriTarget(int idAmbiente)
	{
		return ControllerParametriAmbientali.getParametriTarget(idAmbiente);
	}

}