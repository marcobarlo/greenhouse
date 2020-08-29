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

public class Descrizione_ColtivazioneCriteria extends AbstractORMCriteria {
	public final IntegerExpression attribute;
	public final IntegerExpression ID;
	public final StringExpression tipo;
	public final StringExpression descrizione;
	public final CollectionExpression coltivazioni;
	
	public Descrizione_ColtivazioneCriteria(Criteria criteria) {
		super(criteria);
		attribute = new IntegerExpression("attribute", this);
		ID = new IntegerExpression("ID", this);
		tipo = new StringExpression("tipo", this);
		descrizione = new StringExpression("descrizione", this);
		coltivazioni = new CollectionExpression("ORM_Coltivazioni", this);
	}
	
	public Descrizione_ColtivazioneCriteria(PersistentSession session) {
		this(session.createCriteria(Descrizione_Coltivazione.class));
	}
	
	public Descrizione_ColtivazioneCriteria() throws PersistentException {
		this(package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession());
	}
	
	public package_diagram_desktop_component.model.ColtivazioneCriteria createColtivazioniCriteria() {
		return new package_diagram_desktop_component.model.ColtivazioneCriteria(createCriteria("ORM_Coltivazioni"));
	}
	
	public Descrizione_Coltivazione uniqueDescrizione_Coltivazione() {
		return (Descrizione_Coltivazione) super.uniqueResult();
	}
	
	public Descrizione_Coltivazione[] listDescrizione_Coltivazione() {
		java.util.List list = super.list();
		return (Descrizione_Coltivazione[]) list.toArray(new Descrizione_Coltivazione[list.size()]);
	}
}

