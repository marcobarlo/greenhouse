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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ImpiegatoCriteria extends AbstractORMCriteria {
	public final IntegerExpression attribute;
	public final IntegerExpression ID;
	public final StringExpression email;
	
	public ImpiegatoCriteria(Criteria criteria) {
		super(criteria);
		attribute = new IntegerExpression("attribute", this);
		ID = new IntegerExpression("ID", this);
		email = new StringExpression("email", this);
	}
	
	public ImpiegatoCriteria(PersistentSession session) {
		this(session.createCriteria(Impiegato.class));
	}
	
	public ImpiegatoCriteria() throws PersistentException {
		this(package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession());
	}
	
	public Impiegato uniqueImpiegato() {
		return (Impiegato) super.uniqueResult();
	}
	
	public Impiegato[] listImpiegato() {
		java.util.List list = super.list();
		return (Impiegato[]) list.toArray(new Impiegato[list.size()]);
	}
}

