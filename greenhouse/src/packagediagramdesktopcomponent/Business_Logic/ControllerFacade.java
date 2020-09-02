package packagediagramdesktopcomponent.Business_Logic;

import java.util.Set;

import org.orm.PersistentException;

public class ControllerFacade {

	/**
	 * 
	 * @param nome
	 * @param sezione
	 * @param posizione
	 * @param fila
	 */
	public static Set<ColtivazioneBusiness> ricercaColtivazione(String nome, int sezione, int posizione, int fila) {
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

}