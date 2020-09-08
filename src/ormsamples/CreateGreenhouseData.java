/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import java.util.Date;

import org.orm.*;
import packagediagramdesktopcomponent.model.*;

public class CreateGreenhouseData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = packagediagramdesktopcomponent.model.GreenhousePersistentManager.instance().getSession().beginTransaction();
		try {
//			packagediagramdesktopcomponent.model.Sezione lpackageDiagramDesktopComponentModelSezione = packagediagramdesktopcomponent.model.Sezione.createSezione();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : aree, 
//			lpackageDiagramDesktopComponentModelSezione.save();
//			packagediagramdesktopcomponent.model.AreaColtivata lpackageDiagramDesktopComponentModelAreaColtivata = packagediagramdesktopcomponent.model.AreaColtivata.createAreaColtivata();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : ambiente, sezione, estensione, posizione, fila
//			lpackageDiagramDesktopComponentModelAreaColtivata.save();
//			packagediagramdesktopcomponent.model.Coltivazione lpackageDiagramDesktopComponentModelColtivazione = packagediagramdesktopcomponent.model.Coltivazione.createColtivazione();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : impiegato, descrizione
//			lpackageDiagramDesktopComponentModelColtivazione.save();
//			packagediagramdesktopcomponent.model.Ambiente lpackageDiagramDesktopComponentModelAmbiente = packagediagramdesktopcomponent.model.Ambiente.createAmbiente();
			// Initialize the properties of the persistent object here
//			lpackageDiagramDesktopComponentModelAmbiente.save();
//			packagediagramdesktopcomponent.model.Impiegato lpackageDiagramDesktopComponentModelImpiegato = packagediagramdesktopcomponent.model.Impiegato.createImpiegato();
			// Initialize the properties of the persistent object here
//			lpackageDiagramDesktopComponentModelImpiegato.save();
//			packagediagramdesktopcomponent.model.DescrizioneColtivazione lpackageDiagramDesktopComponentModelDescrizioneColtivazione = packagediagramdesktopcomponent.model.DescrizioneColtivazione.createDescrizioneColtivazione();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : coltivazioni
//			lpackageDiagramDesktopComponentModelDescrizioneColtivazione.save();
			
			Sezione sez1 = Sezione.createSezione();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : aree, 
			AreaColtivata a1 = AreaColtivata.createAreaColtivata();
			a1.setPosizione(1);
			a1.setFila(1);
			a1.setEstensione((float) 32.4);
			a1.setSezione(sez1);
			a1.setTipo_di_terreno("abbastanza fertile");
			
			AreaColtivata a2 = AreaColtivata.createAreaColtivata();
			a2.setPosizione(1);
			a2.setFila(2);
			a2.setEstensione((float) 45.9);
			a2.setSezione(sez1);
			a2.setTipo_di_terreno("poco fertile, buono per i cactus");
			
			Ambiente amb1 = Ambiente.createAmbiente();
			amb1.setIrradianzaTarget((float) 7.8);
			amb1.setTemperaturaTarget((float) 23.3);
			amb1.setUmiditaSuoloTarget(78);
			
			Ambiente amb2 = Ambiente.createAmbiente();
			amb2.setIrradianzaTarget((float) 9.5);
			amb2.setTemperaturaTarget((float) 30.1);
			amb2.setUmiditaSuoloTarget(60);
			
			/*Coltivazione c1 = Coltivazione.createColtivazione();
			c1.setArea(a1);
			c1.setData_prossima_operazione(new Date());
			
			Coltivazione c2 = Coltivazione.createColtivazione();
			c2.setArea(a2);
			//c2.setData_prossima_operazione(new Date());
		*/
			DescrizioneColtivazione d1 = DescrizioneColtivazione.createDescrizioneColtivazione();
			d1.setDescrizione("ci sono dei bei pomodori succosi, qua si fa una grande passata");
			d1.setTipo("pomodori");
			
			DescrizioneColtivazione d2 = DescrizioneColtivazione.createDescrizioneColtivazione();
			d2.setDescrizione("che fico, ho piantato dei fichi");
			d2.setTipo("fichi");
			
			//c1.setDescrizione(d1);
			//c2.setDescrizione(d2);
			
			a1.setAmbiente(amb1);
			//a1.setColtivazione(c1);
			a2.setAmbiente(amb2);
			//a2.setColtivazione(c2);
			
			Impiegato i1 = Impiegato.createImpiegato();
			i1.setEmail("hehehe@lol.sguoz");
			Impiegato i2 = Impiegato.createImpiegato();
			i2.setEmail("ohohoh@asd.rofl");
			
			
			
			sez1.aree.add(a1);
			sez1.aree.add(a2);
			
			
			sez1.save();
			i1.save();
			i2.save();
			
		//	c1.save();
			d1.save();

			d2.save();
		//	c2.save();

			a1.save();
			a2.save();
			amb1.save();
			amb2.save();

			t.commit();
			
			PersistentTransaction t1 = packagediagramdesktopcomponent.model.GreenhousePersistentManager.instance().getSession().beginTransaction();
			try {

				Coltivazione c1 = Coltivazione.createColtivazione();
				c1.setArea(a1);
				c1.setData_prossima_operazione(new Date());
				
				Coltivazione c2 = Coltivazione.createColtivazione();
				c2.setArea(a2);
				c2.setData_prossima_operazione(new Date());
			
				c1.setDescrizione(d1);
				c2.setDescrizione(d2);

				c1.save();
				c2.save();


				t1.commit();
				

			}
			catch (Exception e) {
				t1.rollback();
			}

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
				packagediagramdesktopcomponent.model.GreenhousePersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}