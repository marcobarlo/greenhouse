package packagediagramdesktopcomponent.Business_Logic;

import org.orm.PersistentException;

import packagediagramdesktopcomponent.model.Coltivazione;

public class ControllerParametriAmbientali {

	/**
	 * 
	 * @param coltivaz
	 * @param temp
	 * @param irradianza
	 * @param umdita
	 */
	public static boolean modificaAmbiente(int id, Float temperatura, Float umidita, Float irradianza) {
		Coltivazione c;
		try {
			c = Coltivazione.getColtivazioneByORMID(id);
			return c.modificaAmbiente(temperatura, umidita, irradianza);
		} catch (PersistentException e) {
			return false;
		}
	}

}