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

public class ColtivazioneCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression stato;
	public final DateExpression data_prossima_operazione;
	public final IntegerExpression descrizioneId;
	public final AssociationExpression descrizione;
	public final IntegerExpression areaId;
	public final AssociationExpression area;
	public final CollectionExpression impiegato;
	
	public ColtivazioneCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		stato = new StringExpression("stato", this);
		data_prossima_operazione = new DateExpression("data_prossima_operazione", this);
		descrizioneId = new IntegerExpression("descrizione.ID", this);
		descrizione = new AssociationExpression("descrizione", this);
		areaId = new IntegerExpression("area.ID", this);
		area = new AssociationExpression("area", this);
		impiegato = new CollectionExpression("ORM_Impiegato", this);
	}
	
	public ColtivazioneCriteria(PersistentSession session) {
		this(session.createCriteria(Coltivazione.class));
	}
	
	public ColtivazioneCriteria() throws PersistentException {
		this(packagediagramdesktopcomponent.model.GreenhousePersistentManager.instance().getSession());
	}
	
	public DescrizioneColtivazioneCriteria createDescrizioneCriteria() {
		return new DescrizioneColtivazioneCriteria(createCriteria("descrizione"));
	}
	
	public AreaColtivataCriteria createAreaCriteria() {
		return new AreaColtivataCriteria(createCriteria("area"));
	}
	
	public packagediagramdesktopcomponent.model.ImpiegatoCriteria createImpiegatoCriteria() {
		return new packagediagramdesktopcomponent.model.ImpiegatoCriteria(createCriteria("ORM_Impiegato"));
	}
	
	public Coltivazione uniqueColtivazione() {
		return (Coltivazione) super.uniqueResult();
	}
	
	public Coltivazione[] listColtivazione() {
		java.util.List list = super.list();
		return (Coltivazione[]) list.toArray(new Coltivazione[list.size()]);
	}
}

