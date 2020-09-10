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

public class ImpiegatoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression email;
	
	public ImpiegatoDetachedCriteria() {
		super(packagediagramdesktopcomponent.model.Impiegato.class, packagediagramdesktopcomponent.model.ImpiegatoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
	}
	
	public ImpiegatoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, packagediagramdesktopcomponent.model.ImpiegatoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
	}
	
	public Impiegato uniqueImpiegato(PersistentSession session) {
		return (Impiegato) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Impiegato[] listImpiegato(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Impiegato[]) list.toArray(new Impiegato[list.size()]);
	}
}

