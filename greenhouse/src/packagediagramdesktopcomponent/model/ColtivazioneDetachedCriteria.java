/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package packagediagramdesktopcomponent.model;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ColtivazioneDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression stato;
	public final DateExpression data_prossima_operazione;
	public final IntegerExpression descrizioneId;
	public final AssociationExpression descrizione;
	public final IntegerExpression areaId;
	public final AssociationExpression area;
	public final CollectionExpression impiegato;
	
	public ColtivazioneDetachedCriteria() {
		super(packagediagramdesktopcomponent.model.Coltivazione.class, packagediagramdesktopcomponent.model.ColtivazioneCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		stato = new StringExpression("stato", this.getDetachedCriteria());
		data_prossima_operazione = new DateExpression("data_prossima_operazione", this.getDetachedCriteria());
		descrizioneId = new IntegerExpression("descrizione.ID", this.getDetachedCriteria());
		descrizione = new AssociationExpression("descrizione", this.getDetachedCriteria());
		areaId = new IntegerExpression("area.ID", this.getDetachedCriteria());
		area = new AssociationExpression("area", this.getDetachedCriteria());
		impiegato = new CollectionExpression("ORM_Impiegato", this.getDetachedCriteria());
	}
	
	public ColtivazioneDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, packagediagramdesktopcomponent.model.ColtivazioneCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		stato = new StringExpression("stato", this.getDetachedCriteria());
		data_prossima_operazione = new DateExpression("data_prossima_operazione", this.getDetachedCriteria());
		descrizioneId = new IntegerExpression("descrizione.ID", this.getDetachedCriteria());
		descrizione = new AssociationExpression("descrizione", this.getDetachedCriteria());
		areaId = new IntegerExpression("area.ID", this.getDetachedCriteria());
		area = new AssociationExpression("area", this.getDetachedCriteria());
		impiegato = new CollectionExpression("ORM_Impiegato", this.getDetachedCriteria());
	}
	
	public packagediagramdesktopcomponent.model.DescrizioneColtivazioneDetachedCriteria createDescrizioneCriteria() {
		return new packagediagramdesktopcomponent.model.DescrizioneColtivazioneDetachedCriteria(createCriteria("descrizione"));
	}
	
	public packagediagramdesktopcomponent.model.AreaColtivataDetachedCriteria createAreaCriteria() {
		return new packagediagramdesktopcomponent.model.AreaColtivataDetachedCriteria(createCriteria("area"));
	}
	
	public packagediagramdesktopcomponent.model.ImpiegatoDetachedCriteria createImpiegatoCriteria() {
		return new packagediagramdesktopcomponent.model.ImpiegatoDetachedCriteria(createCriteria("ORM_Impiegato"));
	}
	
	public Coltivazione uniqueColtivazione(PersistentSession session) {
		return (Coltivazione) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Coltivazione[] listColtivazione(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Coltivazione[]) list.toArray(new Coltivazione[list.size()]);
	}
}

