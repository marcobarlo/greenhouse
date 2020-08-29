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
	public final IntegerExpression temperaturaTarget;
	public final IntegerExpression irradianzaTarget;
	public final IntegerExpression umiditaAriaTarget;
	public final IntegerExpression umiditaSuoloTarget;
	
	public AmbienteCriteria(Criteria criteria) {
		super(criteria);
		attribute = new IntegerExpression("attribute", this);
		ID = new IntegerExpression("ID", this);
		temperaturaTarget = new IntegerExpression("temperaturaTarget", this);
		irradianzaTarget = new IntegerExpression("irradianzaTarget", this);
		umiditaAriaTarget = new IntegerExpression("umiditaAriaTarget", this);
		umiditaSuoloTarget = new IntegerExpression("umiditaSuoloTarget", this);
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

