/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateGreenhouseData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = packagediagramdesktopcomponent.model.GreenhousePersistentManager.instance().getSession().beginTransaction();
		try {
			packagediagramdesktopcomponent.model.Sezione lpackagediagramdesktopcomponentModelSezione = packagediagramdesktopcomponent.model.Sezione.loadSezioneByQuery(null, null);
			// Update the properties of the persistent object
			lpackagediagramdesktopcomponentModelSezione.save();
			packagediagramdesktopcomponent.model.AreaColtivata lpackagediagramdesktopcomponentModelAreaColtivata = packagediagramdesktopcomponent.model.AreaColtivata.loadAreaColtivataByQuery(null, null);
			// Update the properties of the persistent object
			lpackagediagramdesktopcomponentModelAreaColtivata.save();
			packagediagramdesktopcomponent.model.Coltivazione lpackagediagramdesktopcomponentModelColtivazione = packagediagramdesktopcomponent.model.Coltivazione.loadColtivazioneByQuery(null, null);
			// Update the properties of the persistent object
			lpackagediagramdesktopcomponentModelColtivazione.save();
			packagediagramdesktopcomponent.model.DescrizioneColtivazione lpackagediagramdesktopcomponentModelDescrizioneColtivazione = packagediagramdesktopcomponent.model.DescrizioneColtivazione.loadDescrizioneColtivazioneByQuery(null, null);
			// Update the properties of the persistent object
			lpackagediagramdesktopcomponentModelDescrizioneColtivazione.save();
			packagediagramdesktopcomponent.model.Impiegato lpackagediagramdesktopcomponentModelImpiegato = packagediagramdesktopcomponent.model.Impiegato.loadImpiegatoByQuery(null, null);
			// Update the properties of the persistent object
			lpackagediagramdesktopcomponentModelImpiegato.save();
			packagediagramdesktopcomponent.model.Ambiente lpackagediagramdesktopcomponentModelAmbiente = packagediagramdesktopcomponent.model.Ambiente.loadAmbienteByQuery(null, null);
			// Update the properties of the persistent object
			lpackagediagramdesktopcomponentModelAmbiente.save();
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Sezione by SezioneCriteria");
		packagediagramdesktopcomponent.model.SezioneCriteria lpackagediagramdesktopcomponentModelSezioneCriteria = new packagediagramdesktopcomponent.model.SezioneCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lpackagediagramdesktopcomponentModelSezioneCriteria.ID.eq();
		System.out.println(lpackagediagramdesktopcomponentModelSezioneCriteria.uniqueSezione());
		
		System.out.println("Retrieving AreaColtivata by AreaColtivataCriteria");
		packagediagramdesktopcomponent.model.AreaColtivataCriteria lpackagediagramdesktopcomponentModelAreaColtivataCriteria = new packagediagramdesktopcomponent.model.AreaColtivataCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lpackagediagramdesktopcomponentModelAreaColtivataCriteria.ID.eq();
		System.out.println(lpackagediagramdesktopcomponentModelAreaColtivataCriteria.uniqueAreaColtivata());
		
		System.out.println("Retrieving Coltivazione by ColtivazioneCriteria");
		packagediagramdesktopcomponent.model.ColtivazioneCriteria lpackagediagramdesktopcomponentModelColtivazioneCriteria = new packagediagramdesktopcomponent.model.ColtivazioneCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lpackagediagramdesktopcomponentModelColtivazioneCriteria.ID.eq();
		System.out.println(lpackagediagramdesktopcomponentModelColtivazioneCriteria.uniqueColtivazione());
		
		System.out.println("Retrieving DescrizioneColtivazione by DescrizioneColtivazioneCriteria");
		packagediagramdesktopcomponent.model.DescrizioneColtivazioneCriteria lpackagediagramdesktopcomponentModelDescrizioneColtivazioneCriteria = new packagediagramdesktopcomponent.model.DescrizioneColtivazioneCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lpackagediagramdesktopcomponentModelDescrizioneColtivazioneCriteria.ID.eq();
		System.out.println(lpackagediagramdesktopcomponentModelDescrizioneColtivazioneCriteria.uniqueDescrizioneColtivazione());
		
		System.out.println("Retrieving Impiegato by ImpiegatoCriteria");
		packagediagramdesktopcomponent.model.ImpiegatoCriteria lpackagediagramdesktopcomponentModelImpiegatoCriteria = new packagediagramdesktopcomponent.model.ImpiegatoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lpackagediagramdesktopcomponentModelImpiegatoCriteria.ID.eq();
		System.out.println(lpackagediagramdesktopcomponentModelImpiegatoCriteria.uniqueImpiegato());
		
		System.out.println("Retrieving Ambiente by AmbienteCriteria");
		packagediagramdesktopcomponent.model.AmbienteCriteria lpackagediagramdesktopcomponentModelAmbienteCriteria = new packagediagramdesktopcomponent.model.AmbienteCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lpackagediagramdesktopcomponentModelAmbienteCriteria.ID.eq();
		System.out.println(lpackagediagramdesktopcomponentModelAmbienteCriteria.uniqueAmbiente());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateGreenhouseData retrieveAndUpdateGreenhouseData = new RetrieveAndUpdateGreenhouseData();
			try {
				retrieveAndUpdateGreenhouseData.retrieveAndUpdateTestData();
				//retrieveAndUpdateGreenhouseData.retrieveByCriteria();
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
