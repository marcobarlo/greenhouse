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

public class Area_ColtivataDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public Area_ColtivataDetachedCriteria() {
		super(package_diagram_desktop_component.model.Area_Coltivata.class, package_diagram_desktop_component.model.Area_ColtivataCriteria.class);
		attribute = new IntegerExpression("attribute", this.getDetachedCriteria());
		sezioneId = new IntegerExpression("sezione.attribute", this.getDetachedCriteria());
		sezione = new AssociationExpression("sezione", this.getDetachedCriteria());
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		fila = new IntegerExpression("fila", this.getDetachedCriteria());
		posizione = new IntegerExpression("posizione", this.getDetachedCriteria());
		estensione = new FloatExpression("estensione", this.getDetachedCriteria());
		tipo_di_terreno = new StringExpression("tipo_di_terreno", this.getDetachedCriteria());
		ambienteId = new IntegerExpression("ambiente.attribute", this.getDetachedCriteria());
		ambiente = new AssociationExpression("ambiente", this.getDetachedCriteria());
		coltivazioneId = new IntegerExpression("coltivazione.attribute", this.getDetachedCriteria());
		coltivazione = new AssociationExpression("coltivazione", this.getDetachedCriteria());
	}
	
	public Area_ColtivataDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, package_diagram_desktop_component.model.Area_ColtivataCriteria.class);
		attribute = new IntegerExpression("attribute", this.getDetachedCriteria());
		sezioneId = new IntegerExpression("sezione.attribute", this.getDetachedCriteria());
		sezione = new AssociationExpression("sezione", this.getDetachedCriteria());
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		fila = new IntegerExpression("fila", this.getDetachedCriteria());
		posizione = new IntegerExpression("posizione", this.getDetachedCriteria());
		estensione = new FloatExpression("estensione", this.getDetachedCriteria());
		tipo_di_terreno = new StringExpression("tipo_di_terreno", this.getDetachedCriteria());
		ambienteId = new IntegerExpression("ambiente.attribute", this.getDetachedCriteria());
		ambiente = new AssociationExpression("ambiente", this.getDetachedCriteria());
		coltivazioneId = new IntegerExpression("coltivazione.attribute", this.getDetachedCriteria());
		coltivazione = new AssociationExpression("coltivazione", this.getDetachedCriteria());
	}
	
	public package_diagram_desktop_component.model.SezioneDetachedCriteria createSezioneCriteria() {
		return new package_diagram_desktop_component.model.SezioneDetachedCriteria(createCriteria("sezione"));
	}
	
	public package_diagram_desktop_component.model.AmbienteDetachedCriteria createAmbienteCriteria() {
		return new package_diagram_desktop_component.model.AmbienteDetachedCriteria(createCriteria("ambiente"));
	}
	
	public package_diagram_desktop_component.model.ColtivazioneDetachedCriteria createColtivazioneCriteria() {
		return new package_diagram_desktop_component.model.ColtivazioneDetachedCriteria(createCriteria("coltivazione"));
	}
	
	public Area_Coltivata uniqueArea_Coltivata(PersistentSession session) {
		return (Area_Coltivata) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Area_Coltivata[] listArea_Coltivata(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Area_Coltivata[]) list.toArray(new Area_Coltivata[list.size()]);
	}
}

