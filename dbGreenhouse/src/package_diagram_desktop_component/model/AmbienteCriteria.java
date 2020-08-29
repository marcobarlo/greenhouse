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

public class AmbienteCriteria extends AbstractORMCriteria {
	public final IntegerExpression attribute;
	public final IntegerExpression ID;
	public final IntegerExpression temperatura_target;
	public final IntegerExpression irradianza_target;
	public final IntegerExpression umidità_aria_target;
	public final IntegerExpression umidità_suolo_target;
	
	public AmbienteCriteria(Criteria criteria) {
		super(criteria);
		attribute = new IntegerExpression("attribute", this);
		ID = new IntegerExpression("ID", this);
		temperatura_target = new IntegerExpression("temperatura_target", this);
		irradianza_target = new IntegerExpression("irradianza_target", this);
		umidità_aria_target = new IntegerExpression("umidità_aria_target", this);
		umidità_suolo_target = new IntegerExpression("umidità_suolo_target", this);
	}
	
	public AmbienteCriteria(PersistentSession session) {
		this(session.createCriteria(Ambiente.class));
	}
	
	public AmbienteCriteria() throws PersistentException {
		this(package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession());
	}
	
	public Ambiente uniqueAmbiente() {
		return (Ambiente) super.uniqueResult();
	}
	
	public Ambiente[] listAmbiente() {
		java.util.List list = super.list();
		return (Ambiente[]) list.toArray(new Ambiente[list.size()]);
	}
}

