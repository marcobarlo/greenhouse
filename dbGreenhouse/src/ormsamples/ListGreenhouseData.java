/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class ListGreenhouseData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Sezione...");
		package_diagram_desktop_component.model.Sezione[] package_diagram_desktop_componentModelSeziones = package_diagram_desktop_component.model.SezioneDAO.listSezioneByQuery(null, null);
		int length = Math.min(package_diagram_desktop_componentModelSeziones.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(package_diagram_desktop_componentModelSeziones[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Area_Coltivata...");
		package_diagram_desktop_component.model.Area_Coltivata[] package_diagram_desktop_componentModelArea_Coltivatas = package_diagram_desktop_component.model.Area_ColtivataDAO.listArea_ColtivataByQuery(null, null);
		length = Math.min(package_diagram_desktop_componentModelArea_Coltivatas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(package_diagram_desktop_componentModelArea_Coltivatas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Coltivazione...");
		package_diagram_desktop_component.model.Coltivazione[] package_diagram_desktop_componentModelColtivaziones = package_diagram_desktop_component.model.ColtivazioneDAO.listColtivazioneByQuery(null, null);
		length = Math.min(package_diagram_desktop_componentModelColtivaziones.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(package_diagram_desktop_componentModelColtivaziones[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Ambiente...");
		package_diagram_desktop_component.model.Ambiente[] package_diagram_desktop_componentModelAmbientes = package_diagram_desktop_component.model.AmbienteDAO.listAmbienteByQuery(null, null);
		length = Math.min(package_diagram_desktop_componentModelAmbientes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(package_diagram_desktop_componentModelAmbientes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Impiegato...");
		package_diagram_desktop_component.model.Impiegato[] package_diagram_desktop_componentModelImpiegatos = package_diagram_desktop_component.model.ImpiegatoDAO.listImpiegatoByQuery(null, null);
		length = Math.min(package_diagram_desktop_componentModelImpiegatos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(package_diagram_desktop_componentModelImpiegatos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Descrizione_Coltivazione...");
		package_diagram_desktop_component.model.Descrizione_Coltivazione[] package_diagram_desktop_componentModelDescrizione_Coltivaziones = package_diagram_desktop_component.model.Descrizione_ColtivazioneDAO.listDescrizione_ColtivazioneByQuery(null, null);
		length = Math.min(package_diagram_desktop_componentModelDescrizione_Coltivaziones.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(package_diagram_desktop_componentModelDescrizione_Coltivaziones[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Sezione by Criteria...");
		package_diagram_desktop_component.model.SezioneCriteria package_diagram_desktop_componentModelSezioneCriteria = new package_diagram_desktop_component.model.SezioneCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//package_diagram_desktop_componentModelSezioneCriteria.attribute.eq();
		package_diagram_desktop_componentModelSezioneCriteria.setMaxResults(ROW_COUNT);
		package_diagram_desktop_component.model.Sezione[] package_diagram_desktop_componentModelSeziones = package_diagram_desktop_componentModelSezioneCriteria.listSezione();
		int length =package_diagram_desktop_componentModelSeziones== null ? 0 : Math.min(package_diagram_desktop_componentModelSeziones.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(package_diagram_desktop_componentModelSeziones[i]);
		}
		System.out.println(length + " Sezione record(s) retrieved."); 
		
		System.out.println("Listing Area_Coltivata by Criteria...");
		package_diagram_desktop_component.model.Area_ColtivataCriteria package_diagram_desktop_componentModelArea_ColtivataCriteria = new package_diagram_desktop_component.model.Area_ColtivataCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//package_diagram_desktop_componentModelArea_ColtivataCriteria.attribute.eq();
		package_diagram_desktop_componentModelArea_ColtivataCriteria.setMaxResults(ROW_COUNT);
		package_diagram_desktop_component.model.Area_Coltivata[] package_diagram_desktop_componentModelArea_Coltivatas = package_diagram_desktop_componentModelArea_ColtivataCriteria.listArea_Coltivata();
		length =package_diagram_desktop_componentModelArea_Coltivatas== null ? 0 : Math.min(package_diagram_desktop_componentModelArea_Coltivatas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(package_diagram_desktop_componentModelArea_Coltivatas[i]);
		}
		System.out.println(length + " Area_Coltivata record(s) retrieved."); 
		
		System.out.println("Listing Coltivazione by Criteria...");
		package_diagram_desktop_component.model.ColtivazioneCriteria package_diagram_desktop_componentModelColtivazioneCriteria = new package_diagram_desktop_component.model.ColtivazioneCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//package_diagram_desktop_componentModelColtivazioneCriteria.attribute.eq();
		package_diagram_desktop_componentModelColtivazioneCriteria.setMaxResults(ROW_COUNT);
		package_diagram_desktop_component.model.Coltivazione[] package_diagram_desktop_componentModelColtivaziones = package_diagram_desktop_componentModelColtivazioneCriteria.listColtivazione();
		length =package_diagram_desktop_componentModelColtivaziones== null ? 0 : Math.min(package_diagram_desktop_componentModelColtivaziones.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(package_diagram_desktop_componentModelColtivaziones[i]);
		}
		System.out.println(length + " Coltivazione record(s) retrieved."); 
		
		System.out.println("Listing Ambiente by Criteria...");
		package_diagram_desktop_component.model.AmbienteCriteria package_diagram_desktop_componentModelAmbienteCriteria = new package_diagram_desktop_component.model.AmbienteCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//package_diagram_desktop_componentModelAmbienteCriteria.attribute.eq();
		package_diagram_desktop_componentModelAmbienteCriteria.setMaxResults(ROW_COUNT);
		package_diagram_desktop_component.model.Ambiente[] package_diagram_desktop_componentModelAmbientes = package_diagram_desktop_componentModelAmbienteCriteria.listAmbiente();
		length =package_diagram_desktop_componentModelAmbientes== null ? 0 : Math.min(package_diagram_desktop_componentModelAmbientes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(package_diagram_desktop_componentModelAmbientes[i]);
		}
		System.out.println(length + " Ambiente record(s) retrieved."); 
		
		System.out.println("Listing Impiegato by Criteria...");
		package_diagram_desktop_component.model.ImpiegatoCriteria package_diagram_desktop_componentModelImpiegatoCriteria = new package_diagram_desktop_component.model.ImpiegatoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//package_diagram_desktop_componentModelImpiegatoCriteria.attribute.eq();
		package_diagram_desktop_componentModelImpiegatoCriteria.setMaxResults(ROW_COUNT);
		package_diagram_desktop_component.model.Impiegato[] package_diagram_desktop_componentModelImpiegatos = package_diagram_desktop_componentModelImpiegatoCriteria.listImpiegato();
		length =package_diagram_desktop_componentModelImpiegatos== null ? 0 : Math.min(package_diagram_desktop_componentModelImpiegatos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(package_diagram_desktop_componentModelImpiegatos[i]);
		}
		System.out.println(length + " Impiegato record(s) retrieved."); 
		
		System.out.println("Listing Descrizione_Coltivazione by Criteria...");
		package_diagram_desktop_component.model.Descrizione_ColtivazioneCriteria package_diagram_desktop_componentModelDescrizione_ColtivazioneCriteria = new package_diagram_desktop_component.model.Descrizione_ColtivazioneCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//package_diagram_desktop_componentModelDescrizione_ColtivazioneCriteria.attribute.eq();
		package_diagram_desktop_componentModelDescrizione_ColtivazioneCriteria.setMaxResults(ROW_COUNT);
		package_diagram_desktop_component.model.Descrizione_Coltivazione[] package_diagram_desktop_componentModelDescrizione_Coltivaziones = package_diagram_desktop_componentModelDescrizione_ColtivazioneCriteria.listDescrizione_Coltivazione();
		length =package_diagram_desktop_componentModelDescrizione_Coltivaziones== null ? 0 : Math.min(package_diagram_desktop_componentModelDescrizione_Coltivaziones.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(package_diagram_desktop_componentModelDescrizione_Coltivaziones[i]);
		}
		System.out.println(length + " Descrizione_Coltivazione record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListGreenhouseData listGreenhouseData = new ListGreenhouseData();
			try {
				listGreenhouseData.listTestData();
				//listGreenhouseData.listByCriteria();
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
