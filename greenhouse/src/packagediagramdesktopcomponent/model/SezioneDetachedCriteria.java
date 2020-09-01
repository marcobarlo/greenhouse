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

public class SezioneDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final CollectionExpression aree;
	
	public SezioneDetachedCriteria() {
		super(packagediagramdesktopcomponent.model.Sezione.class, packagediagramdesktopcomponent.model.SezioneCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		aree = new CollectionExpression("ORM_Aree", this.getDetachedCriteria());
	}
	
	public SezioneDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, packagediagramdesktopcomponent.model.SezioneCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		aree = new CollectionExpression("ORM_Aree", this.getDetachedCriteria());
	}
	
	public packagediagramdesktopcomponent.model.AreaColtivataDetachedCriteria createAreeCriteria() {
		return new packagediagramdesktopcomponent.model.AreaColtivataDetachedCriteria(createCriteria("ORM_Aree"));
	}
	
	public Sezione uniqueSezione(PersistentSession session) {
		return (Sezione) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Sezione[] listSezione(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Sezione[]) list.toArray(new Sezione[list.size()]);
	}
}

