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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class AmbienteCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final FloatExpression temperaturaTarget;
	public final FloatExpression irradianzaTarget;
	public final FloatExpression umiditaSuoloTarget;
	
	public AmbienteCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		temperaturaTarget = new FloatExpression("temperaturaTarget", this);
		irradianzaTarget = new FloatExpression("irradianzaTarget", this);
		umiditaSuoloTarget = new FloatExpression("umiditaSuoloTarget", this);
	}
	
	public AmbienteCriteria(PersistentSession session) {
		this(session.createCriteria(Ambiente.class));
	}
	
	public AmbienteCriteria() throws PersistentException {
		this(packagediagramdesktopcomponent.model.GreenhousePersistentManager.instance().getSession());
	}
	
	public Ambiente uniqueAmbiente() {
		return (Ambiente) super.uniqueResult();
	}
	
	public Ambiente[] listAmbiente() {
		java.util.List list = super.list();
		return (Ambiente[]) list.toArray(new Ambiente[list.size()]);
	}
}

