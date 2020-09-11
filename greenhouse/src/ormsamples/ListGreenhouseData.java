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
		packagediagramdesktopcomponent.model.Sezione[] packagediagramdesktopcomponentModelSeziones = packagediagramdesktopcomponent.model.Sezione.listSezioneByQuery(null, null);
		int length = Math.min(packagediagramdesktopcomponentModelSeziones.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(packagediagramdesktopcomponentModelSeziones[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing AreaColtivata...");
		packagediagramdesktopcomponent.model.AreaColtivata[] packagediagramdesktopcomponentModelAreaColtivatas = packagediagramdesktopcomponent.model.AreaColtivata.listAreaColtivataByQuery(null, null);
		length = Math.min(packagediagramdesktopcomponentModelAreaColtivatas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(packagediagramdesktopcomponentModelAreaColtivatas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Coltivazione...");
		packagediagramdesktopcomponent.model.Coltivazione[] packagediagramdesktopcomponentModelColtivaziones = packagediagramdesktopcomponent.model.Coltivazione.listColtivazioneByQuery(null, null);
		length = Math.min(packagediagramdesktopcomponentModelColtivaziones.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(packagediagramdesktopcomponentModelColtivaziones[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing DescrizioneColtivazione...");
		packagediagramdesktopcomponent.model.DescrizioneColtivazione[] packagediagramdesktopcomponentModelDescrizioneColtivaziones = packagediagramdesktopcomponent.model.DescrizioneColtivazione.listDescrizioneColtivazioneByQuery(null, null);
		length = Math.min(packagediagramdesktopcomponentModelDescrizioneColtivaziones.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(packagediagramdesktopcomponentModelDescrizioneColtivaziones[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Impiegato...");
		packagediagramdesktopcomponent.model.Impiegato[] packagediagramdesktopcomponentModelImpiegatos = packagediagramdesktopcomponent.model.Impiegato.listImpiegatoByQuery(null, null);
		length = Math.min(packagediagramdesktopcomponentModelImpiegatos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(packagediagramdesktopcomponentModelImpiegatos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Ambiente...");
		packagediagramdesktopcomponent.model.Ambiente[] packagediagramdesktopcomponentModelAmbientes = packagediagramdesktopcomponent.model.Ambiente.listAmbienteByQuery(null, null);
		length = Math.min(packagediagramdesktopcomponentModelAmbientes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(packagediagramdesktopcomponentModelAmbientes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Sezione by Criteria...");
		packagediagramdesktopcomponent.model.SezioneCriteria lpackagediagramdesktopcomponentModelSezioneCriteria = new packagediagramdesktopcomponent.model.SezioneCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lpackagediagramdesktopcomponentModelSezioneCriteria.ID.eq();
		lpackagediagramdesktopcomponentModelSezioneCriteria.setMaxResults(ROW_COUNT);
		packagediagramdesktopcomponent.model.Sezione[] packagediagramdesktopcomponentModelSeziones = lpackagediagramdesktopcomponentModelSezioneCriteria.listSezione();
		int length =packagediagramdesktopcomponentModelSeziones== null ? 0 : Math.min(packagediagramdesktopcomponentModelSeziones.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(packagediagramdesktopcomponentModelSeziones[i]);
		}
		System.out.println(length + " Sezione record(s) retrieved."); 
		
		System.out.println("Listing AreaColtivata by Criteria...");
		packagediagramdesktopcomponent.model.AreaColtivataCriteria lpackagediagramdesktopcomponentModelAreaColtivataCriteria = new packagediagramdesktopcomponent.model.AreaColtivataCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lpackagediagramdesktopcomponentModelAreaColtivataCriteria.ID.eq();
		lpackagediagramdesktopcomponentModelAreaColtivataCriteria.setMaxResults(ROW_COUNT);
		packagediagramdesktopcomponent.model.AreaColtivata[] packagediagramdesktopcomponentModelAreaColtivatas = lpackagediagramdesktopcomponentModelAreaColtivataCriteria.listAreaColtivata();
		length =packagediagramdesktopcomponentModelAreaColtivatas== null ? 0 : Math.min(packagediagramdesktopcomponentModelAreaColtivatas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(packagediagramdesktopcomponentModelAreaColtivatas[i]);
		}
		System.out.println(length + " AreaColtivata record(s) retrieved."); 
		
		System.out.println("Listing Coltivazione by Criteria...");
		packagediagramdesktopcomponent.model.ColtivazioneCriteria lpackagediagramdesktopcomponentModelColtivazioneCriteria = new packagediagramdesktopcomponent.model.ColtivazioneCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lpackagediagramdesktopcomponentModelColtivazioneCriteria.ID.eq();
		lpackagediagramdesktopcomponentModelColtivazioneCriteria.setMaxResults(ROW_COUNT);
		packagediagramdesktopcomponent.model.Coltivazione[] packagediagramdesktopcomponentModelColtivaziones = lpackagediagramdesktopcomponentModelColtivazioneCriteria.listColtivazione();
		length =packagediagramdesktopcomponentModelColtivaziones== null ? 0 : Math.min(packagediagramdesktopcomponentModelColtivaziones.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(packagediagramdesktopcomponentModelColtivaziones[i]);
		}
		System.out.println(length + " Coltivazione record(s) retrieved."); 
		
		System.out.println("Listing DescrizioneColtivazione by Criteria...");
		packagediagramdesktopcomponent.model.DescrizioneColtivazioneCriteria lpackagediagramdesktopcomponentModelDescrizioneColtivazioneCriteria = new packagediagramdesktopcomponent.model.DescrizioneColtivazioneCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lpackagediagramdesktopcomponentModelDescrizioneColtivazioneCriteria.ID.eq();
		lpackagediagramdesktopcomponentModelDescrizioneColtivazioneCriteria.setMaxResults(ROW_COUNT);
		packagediagramdesktopcomponent.model.DescrizioneColtivazione[] packagediagramdesktopcomponentModelDescrizioneColtivaziones = lpackagediagramdesktopcomponentModelDescrizioneColtivazioneCriteria.listDescrizioneColtivazione();
		length =packagediagramdesktopcomponentModelDescrizioneColtivaziones== null ? 0 : Math.min(packagediagramdesktopcomponentModelDescrizioneColtivaziones.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(packagediagramdesktopcomponentModelDescrizioneColtivaziones[i]);
		}
		System.out.println(length + " DescrizioneColtivazione record(s) retrieved."); 
		
		System.out.println("Listing Impiegato by Criteria...");
		packagediagramdesktopcomponent.model.ImpiegatoCriteria lpackagediagramdesktopcomponentModelImpiegatoCriteria = new packagediagramdesktopcomponent.model.ImpiegatoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lpackagediagramdesktopcomponentModelImpiegatoCriteria.ID.eq();
		lpackagediagramdesktopcomponentModelImpiegatoCriteria.setMaxResults(ROW_COUNT);
		packagediagramdesktopcomponent.model.Impiegato[] packagediagramdesktopcomponentModelImpiegatos = lpackagediagramdesktopcomponentModelImpiegatoCriteria.listImpiegato();
		length =packagediagramdesktopcomponentModelImpiegatos== null ? 0 : Math.min(packagediagramdesktopcomponentModelImpiegatos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(packagediagramdesktopcomponentModelImpiegatos[i]);
		}
		System.out.println(length + " Impiegato record(s) retrieved."); 
		
		System.out.println("Listing Ambiente by Criteria...");
		packagediagramdesktopcomponent.model.AmbienteCriteria lpackagediagramdesktopcomponentModelAmbienteCriteria = new packagediagramdesktopcomponent.model.AmbienteCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lpackagediagramdesktopcomponentModelAmbienteCriteria.ID.eq();
		lpackagediagramdesktopcomponentModelAmbienteCriteria.setMaxResults(ROW_COUNT);
		packagediagramdesktopcomponent.model.Ambiente[] packagediagramdesktopcomponentModelAmbientes = lpackagediagramdesktopcomponentModelAmbienteCriteria.listAmbiente();
		length =packagediagramdesktopcomponentModelAmbientes== null ? 0 : Math.min(packagediagramdesktopcomponentModelAmbientes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(packagediagramdesktopcomponentModelAmbientes[i]);
		}
		System.out.println(length + " Ambiente record(s) retrieved."); 
		
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
