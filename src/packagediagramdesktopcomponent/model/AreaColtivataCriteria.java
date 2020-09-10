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

public class AreaColtivataCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression fila;
	public final IntegerExpression posizione;
	public final FloatExpression estensione;
	public final StringExpression tipo_di_terreno;
	public final IntegerExpression sezioneId;
	public final AssociationExpression sezione;
	public final IntegerExpression coltivazioneId;
	public final AssociationExpression coltivazione;
	public final IntegerExpression ambienteId;
	public final AssociationExpression ambiente;
	
	public AreaColtivataCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		fila = new IntegerExpression("fila", this);
		posizione = new IntegerExpression("posizione", this);
		estensione = new FloatExpression("estensione", this);
		tipo_di_terreno = new StringExpression("tipo_di_terreno", this);
		sezioneId = new IntegerExpression("sezione.ID", this);
		sezione = new AssociationExpression("sezione", this);
		coltivazioneId = new IntegerExpression("coltivazione.ID", this);
		coltivazione = new AssociationExpression("coltivazione", this);
		ambienteId = new IntegerExpression("ambiente.ID", this);
		ambiente = new AssociationExpression("ambiente", this);
	}
	
	public AreaColtivataCriteria(PersistentSession session) {
		this(session.createCriteria(AreaColtivata.class));
	}
	
	public AreaColtivataCriteria() throws PersistentException {
		this(packagediagramdesktopcomponent.model.GreenhousePersistentManager.instance().getSession());
	}
	
	public SezioneCriteria createSezioneCriteria() {
		return new SezioneCriteria(createCriteria("sezione"));
	}
	
	public ColtivazioneCriteria createColtivazioneCriteria() {
		return new ColtivazioneCriteria(createCriteria("coltivazione"));
	}
	
	public AmbienteCriteria createAmbienteCriteria() {
		return new AmbienteCriteria(createCriteria("ambiente"));
	}
	
	public AreaColtivata uniqueAreaColtivata() {
		return (AreaColtivata) super.uniqueResult();
	}
	
	public AreaColtivata[] listAreaColtivata() {
		java.util.List list = super.list();
		return (AreaColtivata[]) list.toArray(new AreaColtivata[list.size()]);
	}
}

