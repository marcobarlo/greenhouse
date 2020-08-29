/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class DeleteGreenhouseData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession().beginTransaction();
		try {
			package_diagram_desktop_component.model.Sezione package_diagram_desktop_componentModelSezione = package_diagram_desktop_component.model.Sezione.loadSezioneByQuery(null, null);
			package_diagram_desktop_componentModelSezione.delete();
			package_diagram_desktop_component.model.Area_Coltivata package_diagram_desktop_componentModelArea_Coltivata = package_diagram_desktop_component.model.Area_Coltivata.loadArea_ColtivataByQuery(null, null);
			package_diagram_desktop_componentModelArea_Coltivata.delete();
			package_diagram_desktop_component.model.Coltivazione package_diagram_desktop_componentModelColtivazione = package_diagram_desktop_component.model.Coltivazione.loadColtivazioneByQuery(null, null);
			package_diagram_desktop_componentModelColtivazione.delete();
			package_diagram_desktop_component.model.Ambiente package_diagram_desktop_componentModelAmbiente = package_diagram_desktop_component.model.Ambiente.loadAmbienteByQuery(null, null);
			package_diagram_desktop_componentModelAmbiente.delete();
			package_diagram_desktop_component.model.Impiegato package_diagram_desktop_componentModelImpiegato = package_diagram_desktop_component.model.Impiegato.loadImpiegatoByQuery(null, null);
			package_diagram_desktop_componentModelImpiegato.delete();
			package_diagram_desktop_component.model.Descrizione_Coltivazione package_diagram_desktop_componentModelDescrizione_Coltivazione = package_diagram_desktop_component.model.Descrizione_Coltivazione.loadDescrizione_ColtivazioneByQuery(null, null);
			package_diagram_desktop_componentModelDescrizione_Coltivazione.delete();
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
				package_diagram_desktop_component.model.GreenhousePersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
