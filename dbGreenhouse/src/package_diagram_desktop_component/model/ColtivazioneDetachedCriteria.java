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
package package_diagram_desktop_component.model;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ColtivazioneDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression attribute;
	public final IntegerExpression descrizioneId;
	public final AssociationExpression descrizione;
	public final IntegerExpression ID;
	public final StringExpression stato;
	public final DateExpression data_prossima_operazione;
	public final IntegerExpression areaId;
	public final AssociationExpression area;
	public final CollectionExpression impiegato;
	
	public ColtivazioneDetachedCriteria() {
		super(package_diagram_desktop_component.model.Coltivazione.class, package_diagram_desktop_component.model.ColtivazioneCriteria.class);
		attribute = new IntegerExpression("attribute", this.getDetachedCriteria());
		descrizioneId = new IntegerExpression("descrizione.attribute", this.getDetachedCriteria());
		descrizione = new AssociationExpression("descrizione", this.getDetachedCriteria());
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		stato = new StringExpression("stato", this.getDetachedCriteria());
		data_prossima_operazione = new DateExpression("data_prossima_operazione", this.getDetachedCriteria());
		areaId = new IntegerExpression("area.attribute", this.getDetachedCriteria());
		area = new AssociationExpression("area", this.getDetachedCriteria());
		impiegato = new CollectionExpression("ORM_Impiegato", this.getDetachedCriteria());
	}
	
	public ColtivazioneDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, package_diagram_desktop_component.model.ColtivazioneCriteria.class);
		attribute = new IntegerExpression("attribute", this.getDetachedCriteria());
		descrizioneId = new IntegerExpression("descrizione.attribute", this.getDetachedCriteria());
		descrizione = new AssociationExpression("descrizione", this.getDetachedCriteria());
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		stato = new StringExpression("stato", this.getDetachedCriteria());
		data_prossima_operazione = new DateExpression("data_prossima_operazione", this.getDetachedCriteria());
		areaId = new IntegerExpression("area.attribute", this.getDetachedCriteria());
		area = new AssociationExpression("area", this.getDetachedCriteria());
		impiegato = new CollectionExpression("ORM_Impiegato", this.getDetachedCriteria());
	}
	
	public package_diagram_desktop_component.model.Descrizione_ColtivazioneDetachedCriteria createDescrizioneCriteria() {
		return new package_diagram_desktop_component.model.Descrizione_ColtivazioneDetachedCriteria(createCriteria("descrizione"));
	}
	
	public package_diagram_desktop_component.model.Area_ColtivataDetachedCriteria createAreaCriteria() {
		return new package_diagram_desktop_component.model.Area_ColtivataDetachedCriteria(createCriteria("area"));
	}
	
	public package_diagram_desktop_component.model.ImpiegatoDetachedCriteria createImpiegatoCriteria() {
		return new package_diagram_desktop_component.model.ImpiegatoDetachedCriteria(createCriteria("ORM_Impiegato"));
	}
	
	public Coltivazione uniqueColtivazione(PersistentSession session) {
		return (Coltivazione) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Coltivazione[] listColtivazione(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Coltivazione[]) list.toArray(new Coltivazione[list.size()]);
	}
}

