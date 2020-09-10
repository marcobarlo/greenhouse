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
		packagediagramdesktopcomponent.model.Sezione[] packageDiagramDesktopComponentModelSeziones = packagediagramdesktopcomponent.model.Sezione.listSezioneByQuery(null, null);
		int length = Math.min(packageDiagramDesktopComponentModelSeziones.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(packageDiagramDesktopComponentModelSeziones[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing AreaColtivata...");
		packagediagramdesktopcomponent.model.AreaColtivata[] packageDiagramDesktopComponentModelAreaColtivatas = packagediagramdesktopcomponent.model.AreaColtivata.listAreaColtivataByQuery(null, null);
		length = Math.min(packageDiagramDesktopComponentModelAreaColtivatas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(packageDiagramDesktopComponentModelAreaColtivatas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Coltivazione...");
		packagediagramdesktopcomponent.model.Coltivazione[] packageDiagramDesktopComponentModelColtivaziones = packagediagramdesktopcomponent.model.Coltivazione.listColtivazioneByQuery(null, null);
		length = Math.min(packageDiagramDesktopComponentModelColtivaziones.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(packageDiagramDesktopComponentModelColtivaziones[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Ambiente...");
		packagediagramdesktopcomponent.model.Ambiente[] packageDiagramDesktopComponentModelAmbientes = packagediagramdesktopcomponent.model.Ambiente.listAmbienteByQuery(null, null);
		length = Math.min(packageDiagramDesktopComponentModelAmbientes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(packageDiagramDesktopComponentModelAmbientes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Impiegato...");
		packagediagramdesktopcomponent.model.Impiegato[] packageDiagramDesktopComponentModelImpiegatos = packagediagramdesktopcomponent.model.Impiegato.listImpiegatoByQuery(null, null);
		length = Math.min(packageDiagramDesktopComponentModelImpiegatos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(packageDiagramDesktopComponentModelImpiegatos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing DescrizioneColtivazione...");
		packagediagramdesktopcomponent.model.DescrizioneColtivazione[] packageDiagramDesktopComponentModelDescrizioneColtivaziones = packagediagramdesktopcomponent.model.DescrizioneColtivazione.listDescrizioneColtivazioneByQuery(null, null);
		length = Math.min(packageDiagramDesktopComponentModelDescrizioneColtivaziones.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(packageDiagramDesktopComponentModelDescrizioneColtivaziones[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Sezione by Criteria...");
		packagediagramdesktopcomponent.model.SezioneCriteria lpackageDiagramDesktopComponentModelSezioneCriteria = new packagediagramdesktopcomponent.model.SezioneCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lpackageDiagramDesktopComponentModelSezioneCriteria.ID.eq();
		lpackageDiagramDesktopComponentModelSezioneCriteria.setMaxResults(ROW_COUNT);
		packagediagramdesktopcomponent.model.Sezione[] packageDiagramDesktopComponentModelSeziones = lpackageDiagramDesktopComponentModelSezioneCriteria.listSezione();
		int length =packageDiagramDesktopComponentModelSeziones== null ? 0 : Math.min(packageDiagramDesktopComponentModelSeziones.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(packageDiagramDesktopComponentModelSeziones[i]);
		}
		System.out.println(length + " Sezione record(s) retrieved."); 
		
		System.out.println("Listing AreaColtivata by Criteria...");
		packagediagramdesktopcomponent.model.AreaColtivataCriteria lpackageDiagramDesktopComponentModelAreaColtivataCriteria = new packagediagramdesktopcomponent.model.AreaColtivataCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lpackageDiagramDesktopComponentModelAreaColtivataCriteria.ID.eq();
		lpackageDiagramDesktopComponentModelAreaColtivataCriteria.setMaxResults(ROW_COUNT);
		packagediagramdesktopcomponent.model.AreaColtivata[] packageDiagramDesktopComponentModelAreaColtivatas = lpackageDiagramDesktopComponentModelAreaColtivataCriteria.listAreaColtivata();
		length =packageDiagramDesktopComponentModelAreaColtivatas== null ? 0 : Math.min(packageDiagramDesktopComponentModelAreaColtivatas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(packageDiagramDesktopComponentModelAreaColtivatas[i]);
		}
		System.out.println(length + " AreaColtivata record(s) retrieved."); 
		
		System.out.println("Listing Coltivazione by Criteria...");
		packagediagramdesktopcomponent.model.ColtivazioneCriteria lpackageDiagramDesktopComponentModelColtivazioneCriteria = new packagediagramdesktopcomponent.model.ColtivazioneCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lpackageDiagramDesktopComponentModelColtivazioneCriteria.ID.eq();
		lpackageDiagramDesktopComponentModelColtivazioneCriteria.setMaxResults(ROW_COUNT);
		packagediagramdesktopcomponent.model.Coltivazione[] packageDiagramDesktopComponentModelColtivaziones = lpackageDiagramDesktopComponentModelColtivazioneCriteria.listColtivazione();
		length =packageDiagramDesktopComponentModelColtivaziones== null ? 0 : Math.min(packageDiagramDesktopComponentModelColtivaziones.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(packageDiagramDesktopComponentModelColtivaziones[i]);
		}
		System.out.println(length + " Coltivazione record(s) retrieved."); 
		
		System.out.println("Listing Ambiente by Criteria...");
		packagediagramdesktopcomponent.model.AmbienteCriteria lpackageDiagramDesktopComponentModelAmbienteCriteria = new packagediagramdesktopcomponent.model.AmbienteCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lpackageDiagramDesktopComponentModelAmbienteCriteria.ID.eq();
		lpackageDiagramDesktopComponentModelAmbienteCriteria.setMaxResults(ROW_COUNT);
		packagediagramdesktopcomponent.model.Ambiente[] packageDiagramDesktopComponentModelAmbientes = lpackageDiagramDesktopComponentModelAmbienteCriteria.listAmbiente();
		length =packageDiagramDesktopComponentModelAmbientes== null ? 0 : Math.min(packageDiagramDesktopComponentModelAmbientes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(packageDiagramDesktopComponentModelAmbientes[i]);
		}
		System.out.println(length + " Ambiente record(s) retrieved."); 
		
		System.out.println("Listing Impiegato by Criteria...");
		packagediagramdesktopcomponent.model.ImpiegatoCriteria lpackageDiagramDesktopComponentModelImpiegatoCriteria = new packagediagramdesktopcomponent.model.ImpiegatoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lpackageDiagramDesktopComponentModelImpiegatoCriteria.ID.eq();
		lpackageDiagramDesktopComponentModelImpiegatoCriteria.setMaxResults(ROW_COUNT);
		packagediagramdesktopcomponent.model.Impiegato[] packageDiagramDesktopComponentModelImpiegatos = lpackageDiagramDesktopComponentModelImpiegatoCriteria.listImpiegato();
		length =packageDiagramDesktopComponentModelImpiegatos== null ? 0 : Math.min(packageDiagramDesktopComponentModelImpiegatos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(packageDiagramDesktopComponentModelImpiegatos[i]);
		}
		System.out.println(length + " Impiegato record(s) retrieved."); 
		
		System.out.println("Listing DescrizioneColtivazione by Criteria...");
		packagediagramdesktopcomponent.model.DescrizioneColtivazioneCriteria lpackageDiagramDesktopComponentModelDescrizioneColtivazioneCriteria = new packagediagramdesktopcomponent.model.DescrizioneColtivazioneCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lpackageDiagramDesktopComponentModelDescrizioneColtivazioneCriteria.ID.eq();
		lpackageDiagramDesktopComponentModelDescrizioneColtivazioneCriteria.setMaxResults(ROW_COUNT);
		packagediagramdesktopcomponent.model.DescrizioneColtivazione[] packageDiagramDesktopComponentModelDescrizioneColtivaziones = lpackageDiagramDesktopComponentModelDescrizioneColtivazioneCriteria.listDescrizioneColtivazione();
		length =packageDiagramDesktopComponentModelDescrizioneColtivaziones== null ? 0 : Math.min(packageDiagramDesktopComponentModelDescrizioneColtivaziones.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(packageDiagramDesktopComponentModelDescrizioneColtivaziones[i]);
		}
		System.out.println(length + " DescrizioneColtivazione record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListGreenhouseData listGreenhouseData = new ListGreenhouseData();
			try {
				listGreenhouseData.listTestData();
				//listGreenhouseData.listByCriteria();
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
