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

public class Area_ColtivataCriteria extends AbstractORMCriteria {
	public final IntegerExpression attribute;
	public final IntegerExpression sezioneId;
	public final AssociationExpression sezione;
	public final IntegerExpression ID;
	public final IntegerExpression fila;
	public final IntegerExpression posizione;
	public final FloatExpression estensione;
	public final StringExpression tipo_di_terreno;
	public final IntegerExpression ambienteId;
	public final AssociationExpression ambiente;
	public final IntegerExpression coltivazioneId;
	public final AssociationExpression coltivazione;
	
	public Area_ColtivataCriteria(Criteria criteria) {
		super(criteria);
		attribute = new IntegerExpression("attribute", this);
		sezioneId = new IntegerExpression("sezione.attribute", this);
		sezione = new AssociationExpression("sezione", this);
		ID = new IntegerExpression("ID", this);
		fila = new IntegerExpression("fila", this);
		posizione = new IntegerExpression("posizione", this);
		estensione = new FloatExpression("estensione", this);
		tipo_di_terreno = new StringExpression("tipo_di_terreno", this);
		ambienteId = new IntegerExpression("ambiente.attribute", this);
		ambiente = new AssociationExpression("ambiente", this);
		coltivazioneId = new IntegerExpression("coltivazione.attribute", this);
		coltivazione = new AssociationExpression("coltivazione", this);
	}
	
	public Area_ColtivataCriteria(PersistentSession session) {
		this(session.createCriteria(Area_Coltivata.class));
	}
	
	public Area_ColtivataCriteria() throws PersistentException {
		this(package_diagram_desktop_component.model.GreenhousePersistentManager.instance().getSession());
	}
	
	public SezioneCriteria createSezioneCriteria() {
		return new SezioneCriteria(createCriteria("sezione"));
	}
	
	public AmbienteCriteria createAmbienteCriteria() {
		return new AmbienteCriteria(createCriteria("ambiente"));
	}
	
	public ColtivazioneCriteria createColtivazioneCriteria() {
		return new ColtivazioneCriteria(createCriteria("coltivazione"));
	}
	
	public Area_Coltivata uniqueArea_Coltivata() {
		return (Area_Coltivata) super.uniqueResult();
	}
	
	public Area_Coltivata[] listArea_Coltivata() {
		java.util.List list = super.list();
		return (Area_Coltivata[]) list.toArray(new Area_Coltivata[list.size()]);
	}
}

