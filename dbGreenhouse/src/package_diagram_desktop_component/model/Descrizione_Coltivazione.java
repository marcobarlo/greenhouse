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

public class Descrizione_Coltivazione {
	public Descrizione_Coltivazione() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == package_diagram_desktop_component.model.ORMConstants.KEY_DESCRIZIONE_COLTIVAZIONE_COLTIVAZIONI) {
			return ORM_coltivazioni;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int attribute;
	
	private int ID;
	
	private String tipo;
	
	private String descrizione;
	
	private java.util.Set ORM_coltivazioni = new java.util.HashSet();
	
	private void setAttribute(int value) {
		this.attribute = value;
	}
	
	public int getAttribute() {
		return attribute;
	}
	
	public int getORMID() {
		return getAttribute();
	}
	
	public void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setTipo(String value) {
		this.tipo = value;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setDescrizione(String value) {
		this.descrizione = value;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	private void setORM_Coltivazioni(java.util.Set value) {
		this.ORM_coltivazioni = value;
	}
	
	private java.util.Set getORM_Coltivazioni() {
		return ORM_coltivazioni;
	}
	
	public final package_diagram_desktop_component.model.ColtivazioneSetCollection coltivazioni = new package_diagram_desktop_component.model.ColtivazioneSetCollection(this, _ormAdapter, package_diagram_desktop_component.model.ORMConstants.KEY_DESCRIZIONE_COLTIVAZIONE_COLTIVAZIONI, package_diagram_desktop_component.model.ORMConstants.KEY_COLTIVAZIONE_DESCRIZIONE, package_diagram_desktop_component.model.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void ricercaColtivazione() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getAttribute());
	}
	
}
