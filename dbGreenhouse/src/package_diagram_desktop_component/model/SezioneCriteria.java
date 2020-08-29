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

public class SezioneCriteria extends AbstractORMCriteria {
	public final IntegerExpression attribute;
	public final IntegerExpression ID;
	public final IntegerExpression identificativo;
	public final CollectionExpression aree;
	
	public SezioneCriteria(Criteria criteria) {
		super(criteria);
		attribute = new IntegerExpression("attribute", this);
		ID = new IntegerExpression("ID", this);
		identificativo = new IntegerExpression("identificativo", this);
		aree = new CollectionExpression("ORM_Aree", this);
	}
	
	public SezioneCriteria(PersistentSession session) {
		this(session.createCriteria(Sezione.class));
	}
	
	public SezioneCriteria() throws PersistentException {
		this(package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession());
	}
	
	public package_diagram_desktop_component.model.Area_ColtivataCriteria createAreeCriteria() {
		return new package_diagram_desktop_component.model.Area_ColtivataCriteria(createCriteria("ORM_Aree"));
	}
	
	public Sezione uniqueSezione() {
		return (Sezione) super.uniqueResult();
	}
	
	public Sezione[] listSezione() {
		java.util.List list = super.list();
		return (Sezione[]) list.toArray(new Sezione[list.size()]);
	}
}

