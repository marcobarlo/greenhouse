/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateGreenhouseData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession().beginTransaction();
		try {
			package_diagram_desktop_component.model.Sezione package_diagram_desktop_componentModelSezione = package_diagram_desktop_component.model.SezioneDAO.loadSezioneByQuery(null, null);
			// Update the properties of the persistent object
			package_diagram_desktop_component.model.SezioneDAO.save(package_diagram_desktop_componentModelSezione);
			package_diagram_desktop_component.model.Area_Coltivata package_diagram_desktop_componentModelArea_Coltivata = package_diagram_desktop_component.model.Area_ColtivataDAO.loadArea_ColtivataByQuery(null, null);
			// Update the properties of the persistent object
			package_diagram_desktop_component.model.Area_ColtivataDAO.save(package_diagram_desktop_componentModelArea_Coltivata);
			package_diagram_desktop_component.model.Coltivazione package_diagram_desktop_componentModelColtivazione = package_diagram_desktop_component.model.ColtivazioneDAO.loadColtivazioneByQuery(null, null);
			// Update the properties of the persistent object
			package_diagram_desktop_component.model.ColtivazioneDAO.save(package_diagram_desktop_componentModelColtivazione);
			package_diagram_desktop_component.model.Ambiente package_diagram_desktop_componentModelAmbiente = package_diagram_desktop_component.model.AmbienteDAO.loadAmbienteByQuery(null, null);
			// Update the properties of the persistent object
			package_diagram_desktop_component.model.AmbienteDAO.save(package_diagram_desktop_componentModelAmbiente);
			package_diagram_desktop_component.model.Impiegato package_diagram_desktop_componentModelImpiegato = package_diagram_desktop_component.model.ImpiegatoDAO.loadImpiegatoByQuery(null, null);
			// Update the properties of the persistent object
			package_diagram_desktop_component.model.ImpiegatoDAO.save(package_diagram_desktop_componentModelImpiegato);
			package_diagram_desktop_component.model.Descrizione_Coltivazione package_diagram_desktop_componentModelDescrizione_Coltivazione = package_diagram_desktop_component.model.Descrizione_ColtivazioneDAO.loadDescrizione_ColtivazioneByQuery(null, null);
			// Update the properties of the persistent object
			package_diagram_desktop_component.model.Descrizione_ColtivazioneDAO.save(package_diagram_desktop_componentModelDescrizione_Coltivazione);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Sezione by SezioneCriteria");
		package_diagram_desktop_component.model.SezioneCriteria package_diagram_desktop_componentModelSezioneCriteria = new package_diagram_desktop_component.model.SezioneCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//package_diagram_desktop_componentModelSezioneCriteria.attribute.eq();
		System.out.println(package_diagram_desktop_componentModelSezioneCriteria.uniqueSezione());
		
		System.out.println("Retrieving Area_Coltivata by Area_ColtivataCriteria");
		package_diagram_desktop_component.model.Area_ColtivataCriteria package_diagram_desktop_componentModelArea_ColtivataCriteria = new package_diagram_desktop_component.model.Area_ColtivataCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//package_diagram_desktop_componentModelArea_ColtivataCriteria.attribute.eq();
		System.out.println(package_diagram_desktop_componentModelArea_ColtivataCriteria.uniqueArea_Coltivata());
		
		System.out.println("Retrieving Coltivazione by ColtivazioneCriteria");
		package_diagram_desktop_component.model.ColtivazioneCriteria package_diagram_desktop_componentModelColtivazioneCriteria = new package_diagram_desktop_component.model.ColtivazioneCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//package_diagram_desktop_componentModelColtivazioneCriteria.attribute.eq();
		System.out.println(package_diagram_desktop_componentModelColtivazioneCriteria.uniqueColtivazione());
		
		System.out.println("Retrieving Ambiente by AmbienteCriteria");
		package_diagram_desktop_component.model.AmbienteCriteria package_diagram_desktop_componentModelAmbienteCriteria = new package_diagram_desktop_component.model.AmbienteCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//package_diagram_desktop_componentModelAmbienteCriteria.attribute.eq();
		System.out.println(package_diagram_desktop_componentModelAmbienteCriteria.uniqueAmbiente());
		
		System.out.println("Retrieving Impiegato by ImpiegatoCriteria");
		package_diagram_desktop_component.model.ImpiegatoCriteria package_diagram_desktop_componentModelImpiegatoCriteria = new package_diagram_desktop_component.model.ImpiegatoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//package_diagram_desktop_componentModelImpiegatoCriteria.attribute.eq();
		System.out.println(package_diagram_desktop_componentModelImpiegatoCriteria.uniqueImpiegato());
		
		System.out.println("Retrieving Descrizione_Coltivazione by Descrizione_ColtivazioneCriteria");
		package_diagram_desktop_component.model.Descrizione_ColtivazioneCriteria package_diagram_desktop_componentModelDescrizione_ColtivazioneCriteria = new package_diagram_desktop_component.model.Descrizione_ColtivazioneCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//package_diagram_desktop_componentModelDescrizione_ColtivazioneCriteria.attribute.eq();
		System.out.println(package_diagram_desktop_componentModelDescrizione_ColtivazioneCriteria.uniqueDescrizione_Coltivazione());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateGreenhouseData retrieveAndUpdateGreenhouseData = new RetrieveAndUpdateGreenhouseData();
			try {
				retrieveAndUpdateGreenhouseData.retrieveAndUpdateTestData();
				//retrieveAndUpdateGreenhouseData.retrieveByCriteria();
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
