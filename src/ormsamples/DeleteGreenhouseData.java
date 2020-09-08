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
			packagediagramdesktopcomponent.model.Sezione lpackageDiagramDesktopComponentModelSezione = packagediagramdesktopcomponent.model.Sezione.loadSezioneByQuery(null, null);
			lpackageDiagramDesktopComponentModelSezione.delete();
			packagediagramdesktopcomponent.model.AreaColtivata lpackageDiagramDesktopComponentModelAreaColtivata = packagediagramdesktopcomponent.model.AreaColtivata.loadAreaColtivataByQuery(null, null);
			lpackageDiagramDesktopComponentModelAreaColtivata.delete();
			packagediagramdesktopcomponent.model.Coltivazione lpackageDiagramDesktopComponentModelColtivazione = packagediagramdesktopcomponent.model.Coltivazione.loadColtivazioneByQuery(null, null);
			lpackageDiagramDesktopComponentModelColtivazione.delete();
			packagediagramdesktopcomponent.model.Ambiente lpackageDiagramDesktopComponentModelAmbiente = packagediagramdesktopcomponent.model.Ambiente.loadAmbienteByQuery(null, null);
			lpackageDiagramDesktopComponentModelAmbiente.delete();
			packagediagramdesktopcomponent.model.Impiegato lpackageDiagramDesktopComponentModelImpiegato = packagediagramdesktopcomponent.model.Impiegato.loadImpiegatoByQuery(null, null);
			lpackageDiagramDesktopComponentModelImpiegato.delete();
			packagediagramdesktopcomponent.model.DescrizioneColtivazione lpackageDiagramDesktopComponentModelDescrizioneColtivazione = packagediagramdesktopcomponent.model.DescrizioneColtivazione.loadDescrizioneColtivazioneByQuery(null, null);
			lpackageDiagramDesktopComponentModelDescrizioneColtivazione.delete();
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
