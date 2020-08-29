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
			package_diagram_desktop_component.model.Sezione package_diagram_desktop_componentModelSezione = package_diagram_desktop_component.model.SezioneDAO.loadSezioneByQuery(null, null);
			// Delete the persistent object
			package_diagram_desktop_component.model.SezioneDAO.delete(package_diagram_desktop_componentModelSezione);
			package_diagram_desktop_component.model.Area_Coltivata package_diagram_desktop_componentModelArea_Coltivata = package_diagram_desktop_component.model.Area_ColtivataDAO.loadArea_ColtivataByQuery(null, null);
			// Delete the persistent object
			package_diagram_desktop_component.model.Area_ColtivataDAO.delete(package_diagram_desktop_componentModelArea_Coltivata);
			package_diagram_desktop_component.model.Coltivazione package_diagram_desktop_componentModelColtivazione = package_diagram_desktop_component.model.ColtivazioneDAO.loadColtivazioneByQuery(null, null);
			// Delete the persistent object
			package_diagram_desktop_component.model.ColtivazioneDAO.delete(package_diagram_desktop_componentModelColtivazione);
			package_diagram_desktop_component.model.Ambiente package_diagram_desktop_componentModelAmbiente = package_diagram_desktop_component.model.AmbienteDAO.loadAmbienteByQuery(null, null);
			// Delete the persistent object
			package_diagram_desktop_component.model.AmbienteDAO.delete(package_diagram_desktop_componentModelAmbiente);
			package_diagram_desktop_component.model.Impiegato package_diagram_desktop_componentModelImpiegato = package_diagram_desktop_component.model.ImpiegatoDAO.loadImpiegatoByQuery(null, null);
			// Delete the persistent object
			package_diagram_desktop_component.model.ImpiegatoDAO.delete(package_diagram_desktop_componentModelImpiegato);
			package_diagram_desktop_component.model.Descrizione_Coltivazione package_diagram_desktop_componentModelDescrizione_Coltivazione = package_diagram_desktop_component.model.Descrizione_ColtivazioneDAO.loadDescrizione_ColtivazioneByQuery(null, null);
			// Delete the persistent object
			package_diagram_desktop_component.model.Descrizione_ColtivazioneDAO.delete(package_diagram_desktop_componentModelDescrizione_Coltivazione);
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
