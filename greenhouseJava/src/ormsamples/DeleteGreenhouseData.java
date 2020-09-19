/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class DeleteGreenhouseData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = packagediagramdesktopcomponent.model.GreenhousePersistentManager.instance().getSession().beginTransaction();
		try {
			packagediagramdesktopcomponent.model.Sezione lpackagediagramdesktopcomponentModelSezione = packagediagramdesktopcomponent.model.Sezione.loadSezioneByQuery(null, null);
			lpackagediagramdesktopcomponentModelSezione.delete();
			packagediagramdesktopcomponent.model.AreaColtivata lpackagediagramdesktopcomponentModelAreaColtivata = packagediagramdesktopcomponent.model.AreaColtivata.loadAreaColtivataByQuery(null, null);
			lpackagediagramdesktopcomponentModelAreaColtivata.delete();
			packagediagramdesktopcomponent.model.Coltivazione lpackagediagramdesktopcomponentModelColtivazione = packagediagramdesktopcomponent.model.Coltivazione.loadColtivazioneByQuery(null, null);
			lpackagediagramdesktopcomponentModelColtivazione.delete();
			packagediagramdesktopcomponent.model.DescrizioneColtivazione lpackagediagramdesktopcomponentModelDescrizioneColtivazione = packagediagramdesktopcomponent.model.DescrizioneColtivazione.loadDescrizioneColtivazioneByQuery(null, null);
			lpackagediagramdesktopcomponentModelDescrizioneColtivazione.delete();
			packagediagramdesktopcomponent.model.Impiegato lpackagediagramdesktopcomponentModelImpiegato = packagediagramdesktopcomponent.model.Impiegato.loadImpiegatoByQuery(null, null);
			lpackagediagramdesktopcomponentModelImpiegato.delete();
			packagediagramdesktopcomponent.model.Ambiente lpackagediagramdesktopcomponentModelAmbiente = packagediagramdesktopcomponent.model.Ambiente.loadAmbienteByQuery(null, null);
			lpackagediagramdesktopcomponentModelAmbiente.delete();
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteGreenhouseData deleteGreenhouseData = new DeleteGreenhouseData();
			try {
				deleteGreenhouseData.deleteTestData();
			}
			finally {
				packagediagramdesktopcomponent.model.GreenhousePersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
