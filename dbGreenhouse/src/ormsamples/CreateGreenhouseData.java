/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class CreateGreenhouseData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession().beginTransaction();
		try {
			package_diagram_desktop_component.model.Sezione package_diagram_desktop_componentModelSezione = package_diagram_desktop_component.model.SezioneDAO.createSezione();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : aree, identificativo, ID
			package_diagram_desktop_component.model.SezioneDAO.save(package_diagram_desktop_componentModelSezione);
			package_diagram_desktop_component.model.Area_Coltivata package_diagram_desktop_componentModelArea_Coltivata = package_diagram_desktop_component.model.Area_ColtivataDAO.createArea_Coltivata();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : ambiente, estensione, posizione, fila, ID, sezione
			package_diagram_desktop_component.model.Area_ColtivataDAO.save(package_diagram_desktop_componentModelArea_Coltivata);
			package_diagram_desktop_component.model.Coltivazione package_diagram_desktop_componentModelColtivazione = package_diagram_desktop_component.model.ColtivazioneDAO.createColtivazione();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : impiegato, ID, descrizione
			package_diagram_desktop_component.model.ColtivazioneDAO.save(package_diagram_desktop_componentModelColtivazione);
			package_diagram_desktop_component.model.Ambiente package_diagram_desktop_componentModelAmbiente = package_diagram_desktop_component.model.AmbienteDAO.createAmbiente();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : ID
			package_diagram_desktop_component.model.AmbienteDAO.save(package_diagram_desktop_componentModelAmbiente);
			package_diagram_desktop_component.model.Impiegato package_diagram_desktop_componentModelImpiegato = package_diagram_desktop_component.model.ImpiegatoDAO.createImpiegato();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : ID
			package_diagram_desktop_component.model.ImpiegatoDAO.save(package_diagram_desktop_componentModelImpiegato);
			package_diagram_desktop_component.model.Descrizione_Coltivazione package_diagram_desktop_componentModelDescrizione_Coltivazione = package_diagram_desktop_component.model.Descrizione_ColtivazioneDAO.createDescrizione_Coltivazione();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : coltivazioni, ID
			package_diagram_desktop_component.model.Descrizione_ColtivazioneDAO.save(package_diagram_desktop_componentModelDescrizione_Coltivazione);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateGreenhouseData createGreenhouseData = new CreateGreenhouseData();
			try {
				createGreenhouseData.createTestData();
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
