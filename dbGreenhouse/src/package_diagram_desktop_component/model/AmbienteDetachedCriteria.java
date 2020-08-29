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

public class AmbienteDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression attribute;
	public final IntegerExpression ID;
	public final IntegerExpression temperatura_target;
	public final IntegerExpression irradianza_target;
	public final IntegerExpression umidità_aria_target;
	public final IntegerExpression umidità_suolo_target;
	
	public AmbienteDetachedCriteria() {
		super(package_diagram_desktop_component.model.Ambiente.class, package_diagram_desktop_component.model.AmbienteCriteria.class);
		attribute = new IntegerExpression("attribute", this.getDetachedCriteria());
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		temperatura_target = new IntegerExpression("temperatura_target", this.getDetachedCriteria());
		irradianza_target = new IntegerExpression("irradianza_target", this.getDetachedCriteria());
		umidità_aria_target = new IntegerExpression("umidità_aria_target", this.getDetachedCriteria());
		umidità_suolo_target = new IntegerExpression("umidità_suolo_target", this.getDetachedCriteria());
	}
	
	public AmbienteDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, package_diagram_desktop_component.model.AmbienteCriteria.class);
		attribute = new IntegerExpression("attribute", this.getDetachedCriteria());
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		temperatura_target = new IntegerExpression("temperatura_target", this.getDetachedCriteria());
		irradianza_target = new IntegerExpression("irradianza_target", this.getDetachedCriteria());
		umidità_aria_target = new IntegerExpression("umidità_aria_target", this.getDetachedCriteria());
		umidità_suolo_target = new IntegerExpression("umidità_suolo_target", this.getDetachedCriteria());
	}
	
	public Ambiente uniqueAmbiente(PersistentSession session) {
		return (Ambiente) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Ambiente[] listAmbiente(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Ambiente[]) list.toArray(new Ambiente[list.size()]);
	}
}

