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
			packagediagramdesktopcomponent.model.Sezione lpackageDiagramDesktopComponentModelSezione = packagediagramdesktopcomponent.model.Sezione.loadSezioneByQuery(null, null);
			// Update the properties of the persistent object
			lpackageDiagramDesktopComponentModelSezione.save();
			packagediagramdesktopcomponent.model.AreaColtivata lpackageDiagramDesktopComponentModelAreaColtivata = packagediagramdesktopcomponent.model.AreaColtivata.loadAreaColtivataByQuery(null, null);
			// Update the properties of the persistent object
			lpackageDiagramDesktopComponentModelAreaColtivata.save();
			packagediagramdesktopcomponent.model.Coltivazione lpackageDiagramDesktopComponentModelColtivazione = packagediagramdesktopcomponent.model.Coltivazione.loadColtivazioneByQuery(null, null);
			// Update the properties of the persistent object
			lpackageDiagramDesktopComponentModelColtivazione.save();
			packagediagramdesktopcomponent.model.Ambiente lpackageDiagramDesktopComponentModelAmbiente = packagediagramdesktopcomponent.model.Ambiente.loadAmbienteByQuery(null, null);
			// Update the properties of the persistent object
			lpackageDiagramDesktopComponentModelAmbiente.save();
			packagediagramdesktopcomponent.model.Impiegato lpackageDiagramDesktopComponentModelImpiegato = packagediagramdesktopcomponent.model.Impiegato.loadImpiegatoByQuery(null, null);
			// Update the properties of the persistent object
			lpackageDiagramDesktopComponentModelImpiegato.save();
			packagediagramdesktopcomponent.model.DescrizioneColtivazione lpackageDiagramDesktopComponentModelDescrizioneColtivazione = packagediagramdesktopcomponent.model.DescrizioneColtivazione.loadDescrizioneColtivazioneByQuery(null, null);
			// Update the properties of the persistent object
			lpackageDiagramDesktopComponentModelDescrizioneColtivazione.save();
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Sezione by SezioneCriteria");
		packagediagramdesktopcomponent.model.SezioneCriteria lpackageDiagramDesktopComponentModelSezioneCriteria = new packagediagramdesktopcomponent.model.SezioneCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lpackageDiagramDesktopComponentModelSezioneCriteria.ID.eq();
		System.out.println(lpackageDiagramDesktopComponentModelSezioneCriteria.uniqueSezione());
		
		System.out.println("Retrieving AreaColtivata by AreaColtivataCriteria");
		packagediagramdesktopcomponent.model.AreaColtivataCriteria lpackageDiagramDesktopComponentModelAreaColtivataCriteria = new packagediagramdesktopcomponent.model.AreaColtivataCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lpackageDiagramDesktopComponentModelAreaColtivataCriteria.ID.eq();
		System.out.println(lpackageDiagramDesktopComponentModelAreaColtivataCriteria.uniqueAreaColtivata());
		
		System.out.println("Retrieving Coltivazione by ColtivazioneCriteria");
		packagediagramdesktopcomponent.model.ColtivazioneCriteria lpackageDiagramDesktopComponentModelColtivazioneCriteria = new packagediagramdesktopcomponent.model.ColtivazioneCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lpackageDiagramDesktopComponentModelColtivazioneCriteria.ID.eq();
		System.out.println(lpackageDiagramDesktopComponentModelColtivazioneCriteria.uniqueColtivazione());
		
		System.out.println("Retrieving Ambiente by AmbienteCriteria");
		packagediagramdesktopcomponent.model.AmbienteCriteria lpackageDiagramDesktopComponentModelAmbienteCriteria = new packagediagramdesktopcomponent.model.AmbienteCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lpackageDiagramDesktopComponentModelAmbienteCriteria.ID.eq();
		System.out.println(lpackageDiagramDesktopComponentModelAmbienteCriteria.uniqueAmbiente());
		
		System.out.println("Retrieving Impiegato by ImpiegatoCriteria");
		packagediagramdesktopcomponent.model.ImpiegatoCriteria lpackageDiagramDesktopComponentModelImpiegatoCriteria = new packagediagramdesktopcomponent.model.ImpiegatoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lpackageDiagramDesktopComponentModelImpiegatoCriteria.ID.eq();
		System.out.println(lpackageDiagramDesktopComponentModelImpiegatoCriteria.uniqueImpiegato());
		
		System.out.println("Retrieving DescrizioneColtivazione by DescrizioneColtivazioneCriteria");
		packagediagramdesktopcomponent.model.DescrizioneColtivazioneCriteria lpackageDiagramDesktopComponentModelDescrizioneColtivazioneCriteria = new packagediagramdesktopcomponent.model.DescrizioneColtivazioneCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lpackageDiagramDesktopComponentModelDescrizioneColtivazioneCriteria.ID.eq();
		System.out.println(lpackageDiagramDesktopComponentModelDescrizioneColtivazioneCriteria.uniqueDescrizioneColtivazione());
		
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
