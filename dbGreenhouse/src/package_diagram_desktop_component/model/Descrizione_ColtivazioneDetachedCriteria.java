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

public class Descrizione_ColtivazioneDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression attribute;
	public final IntegerExpression ID;
	public final StringExpression tipo;
	public final StringExpression descrizione;
	public final CollectionExpression coltivazioni;
	
	public Descrizione_ColtivazioneDetachedCriteria() {
		super(package_diagram_desktop_component.model.Descrizione_Coltivazione.class, package_diagram_desktop_component.model.Descrizione_ColtivazioneCriteria.class);
		attribute = new IntegerExpression("attribute", this.getDetachedCriteria());
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		tipo = new StringExpression("tipo", this.getDetachedCriteria());
		descrizione = new StringExpression("descrizione", this.getDetachedCriteria());
		coltivazioni = new CollectionExpression("ORM_Coltivazioni", this.getDetachedCriteria());
	}
	
	public Descrizione_ColtivazioneDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, package_diagram_desktop_component.model.Descrizione_ColtivazioneCriteria.class);
		attribute = new IntegerExpression("attribute", this.getDetachedCriteria());
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		tipo = new StringExpression("tipo", this.getDetachedCriteria());
		descrizione = new StringExpression("descrizione", this.getDetachedCriteria());
		coltivazioni = new CollectionExpression("ORM_Coltivazioni", this.getDetachedCriteria());
	}
	
	public package_diagram_desktop_component.model.ColtivazioneDetachedCriteria createColtivazioniCriteria() {
		return new package_diagram_desktop_component.model.ColtivazioneDetachedCriteria(createCriteria("ORM_Coltivazioni"));
	}
	
	public Descrizione_Coltivazione uniqueDescrizione_Coltivazione(PersistentSession session) {
		return (Descrizione_Coltivazione) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Descrizione_Coltivazione[] listDescrizione_Coltivazione(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Descrizione_Coltivazione[]) list.toArray(new Descrizione_Coltivazione[list.size()]);
	}
}

