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

public class ColtivazioneCriteria extends AbstractORMCriteria {
	public final IntegerExpression attribute;
	public final IntegerExpression descrizioneId;
	public final AssociationExpression descrizione;
	public final IntegerExpression ID;
	public final StringExpression stato;
	public final DateExpression data_prossima_operazione;
	public final IntegerExpression areaId;
	public final AssociationExpression area;
	public final CollectionExpression impiegato;
	
	public ColtivazioneCriteria(Criteria criteria) {
		super(criteria);
		attribute = new IntegerExpression("attribute", this);
		descrizioneId = new IntegerExpression("descrizione.attribute", this);
		descrizione = new AssociationExpression("descrizione", this);
		ID = new IntegerExpression("ID", this);
		stato = new StringExpression("stato", this);
		data_prossima_operazione = new DateExpression("data_prossima_operazione", this);
		areaId = new IntegerExpression("area.attribute", this);
		area = new AssociationExpression("area", this);
		impiegato = new CollectionExpression("ORM_Impiegato", this);
	}
	
	public ColtivazioneCriteria(PersistentSession session) {
		this(session.createCriteria(Coltivazione.class));
	}
	
	public ColtivazioneCriteria() throws PersistentException {
		this(package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession());
	}
	
	public Descrizione_ColtivazioneCriteria createDescrizioneCriteria() {
		return new Descrizione_ColtivazioneCriteria(createCriteria("descrizione"));
	}
	
	public Area_ColtivataCriteria createAreaCriteria() {
		return new Area_ColtivataCriteria(createCriteria("area"));
	}
	
	public package_diagram_desktop_component.model.ImpiegatoCriteria createImpiegatoCriteria() {
		return new package_diagram_desktop_component.model.ImpiegatoCriteria(createCriteria("ORM_Impiegato"));
	}
	
	public Coltivazione uniqueColtivazione() {
		return (Coltivazione) super.uniqueResult();
	}
	
	public Coltivazione[] listColtivazione() {
		java.util.List list = super.list();
		return (Coltivazione[]) list.toArray(new Coltivazione[list.size()]);
	}
}

