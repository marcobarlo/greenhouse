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

public class Sezione {
	public Sezione() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == package_diagram_desktop_component.model.ORMConstants.KEY_SEZIONE_AREE) {
			return ORM_aree;
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
	
	private int identificativo;
	
	private java.util.Set ORM_aree = new java.util.HashSet();
	
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
	
	public void setIdentificativo(int value) {
		this.identificativo = value;
	}
	
	public int getIdentificativo() {
		return identificativo;
	}
	
	private void setORM_Aree(java.util.Set value) {
		this.ORM_aree = value;
	}
	
	private java.util.Set getORM_Aree() {
		return ORM_aree;
	}
	
	public final package_diagram_desktop_component.model.Area_ColtivataSetCollection aree = new package_diagram_desktop_component.model.Area_ColtivataSetCollection(this, _ormAdapter, package_diagram_desktop_component.model.ORMConstants.KEY_SEZIONE_AREE, package_diagram_desktop_component.model.ORMConstants.KEY_AREA_COLTIVATA_SEZIONE, package_diagram_desktop_component.model.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public package_diagram_desktop_component.model.Area_Coltivata[] getAreeColtivate(int posizione, int fila) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getAttribute());
	}
	
}
