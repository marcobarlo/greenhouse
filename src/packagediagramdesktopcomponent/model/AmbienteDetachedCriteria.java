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

public class AmbienteDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final FloatExpression temperaturaTarget;
	public final FloatExpression irradianzaTarget;
	public final FloatExpression umiditaSuoloTarget;
	
	public AmbienteDetachedCriteria() {
		super(packagediagramdesktopcomponent.model.Ambiente.class, packagediagramdesktopcomponent.model.AmbienteCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		temperaturaTarget = new FloatExpression("temperaturaTarget", this.getDetachedCriteria());
		irradianzaTarget = new FloatExpression("irradianzaTarget", this.getDetachedCriteria());
		umiditaSuoloTarget = new FloatExpression("umiditaSuoloTarget", this.getDetachedCriteria());
	}
	
	public AmbienteDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, packagediagramdesktopcomponent.model.AmbienteCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		temperaturaTarget = new FloatExpression("temperaturaTarget", this.getDetachedCriteria());
		irradianzaTarget = new FloatExpression("irradianzaTarget", this.getDetachedCriteria());
		umiditaSuoloTarget = new FloatExpression("umiditaSuoloTarget", this.getDetachedCriteria());
	}
	
	public Ambiente uniqueAmbiente(PersistentSession session) {
		return (Ambiente) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Ambiente[] listAmbiente(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Ambiente[]) list.toArray(new Ambiente[list.size()]);
	}
}

