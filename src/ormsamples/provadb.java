package ormsamples;

import java.util.Iterator;

import org.orm.PersistentException;

import packagediagramdesktopcomponent.model.*;

public class provadb {
	public static void main(String[] args) throws PersistentException {
		Sezione sez1[];
		SezioneCriteria sezcrit;
		sezcrit = new SezioneCriteria();
		sez1 = sezcrit.listSezione();
		System.out.println(sez1.length);
		for(Sezione sezion: sez1)
		{
			System.out.println("Sezione con aree " + sezion.aree.size());	
			Iterator<AreaColtivata> itr =sezion.aree.getIterator();
			while(itr.hasNext())
			{
				AreaColtivata a=itr.next();
				System.out.println("Area " + a.getFila() + a.getPosizione());	
				Coltivazione c= a.getColtivazione();
				if(c != null)
				{
					System.out.println("Coltivazione con id: "+c.getID());
					DescrizioneColtivazione d = c.getDescrizioneColtivazione();
					System.out.println(d.getTipo());
				}
			}
		}

		Coltivazione colt = Coltivazione.getColtivazioneByORMID(1);
		DescrizioneColtivazione descr = colt.getDescrizioneColtivazione();
		if(descr == null) {
			System.out.println("a saj a mammt?");
		}
		else {
			System.out.println(descr.getID());
			System.out.println(descr.getTipo());
			System.out.println(descr.getDescrizione());
		}
		Sezione sez = Sezione.getSezioneByORMID(8);
		System.out.println(sez.aree.size());
		
		
	}
	
	
}
