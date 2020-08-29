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

public class SezioneDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression attribute;
	public final IntegerExpression ID;
	public final IntegerExpression identificativo;
	public final CollectionExpression aree;
	
	public SezioneDetachedCriteria() {
		super(package_diagram_desktop_component.model.Sezione.class, package_diagram_desktop_component.model.SezioneCriteria.class);
		attribute = new IntegerExpression("attribute", this.getDetachedCriteria());
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		identificativo = new IntegerExpression("identificativo", this.getDetachedCriteria());
		aree = new CollectionExpression("ORM_Aree", this.getDetachedCriteria());
	}
	
	public SezioneDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, package_diagram_desktop_component.model.SezioneCriteria.class);
		attribute = new IntegerExpression("attribute", this.getDetachedCriteria());
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		identificativo = new IntegerExpression("identificativo", this.getDetachedCriteria());
		aree = new CollectionExpression("ORM_Aree", this.getDetachedCriteria());
	}
	
	public package_diagram_desktop_component.model.Area_ColtivataDetachedCriteria createAreeCriteria() {
		return new package_diagram_desktop_component.model.Area_ColtivataDetachedCriteria(createCriteria("ORM_Aree"));
	}
	
	public Sezione uniqueSezione(PersistentSession session) {
		return (Sezione) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Sezione[] listSezione(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Sezione[]) list.toArray(new Sezione[list.size()]);
	}
}

