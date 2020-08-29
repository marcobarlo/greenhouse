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

public class Coltivazione {
	public Coltivazione() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == package_diagram_desktop_component.model.ORMConstants.KEY_COLTIVAZIONE_IMPIEGATO) {
			return ORM_impiegato;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == package_diagram_desktop_component.model.ORMConstants.KEY_COLTIVAZIONE_AREA) {
			this.area = (package_diagram_desktop_component.model.Area_Coltivata) owner;
		}
		
		else if (key == package_diagram_desktop_component.model.ORMConstants.KEY_COLTIVAZIONE_DESCRIZIONE) {
			this.descrizione = (package_diagram_desktop_component.model.Descrizione_Coltivazione) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int attribute;
	
	private package_diagram_desktop_component.model.Descrizione_Coltivazione descrizione;
	
	private int ID;
	
	private String stato;
	
	private java.util.Date data_prossima_operazione;
	
	private package_diagram_desktop_component.model.Area_Coltivata area;
	
	private java.util.Set ORM_impiegato = new java.util.HashSet();
	
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
	
	public void setStato(String value) {
		this.stato = value;
	}
	
	public String getStato() {
		return stato;
	}
	
	public void setData_prossima_operazione(java.util.Date value) {
		this.data_prossima_operazione = value;
	}
	
	public java.util.Date getData_prossima_operazione() {
		return data_prossima_operazione;
	}
	
	public void setArea(package_diagram_desktop_component.model.Area_Coltivata value) {
		if (this.area != value) {
			package_diagram_desktop_component.model.Area_Coltivata larea = this.area;
			this.area = value;
			if (value != null) {
				area.setColtivazione(this);
			}
			if (larea != null && larea.getColtivazione() == this) {
				larea.setColtivazione(null);
			}
		}
	}
	
	public package_diagram_desktop_component.model.Area_Coltivata getArea() {
		return area;
	}
	
	public void setDescrizione(package_diagram_desktop_component.model.Descrizione_Coltivazione value) {
		if (descrizione != null) {
			descrizione.coltivazioni.remove(this);
		}
		if (value != null) {
			value.coltivazioni.add(this);
		}
	}
	
	public package_diagram_desktop_component.model.Descrizione_Coltivazione getDescrizione() {
		return descrizione;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Descrizione(package_diagram_desktop_component.model.Descrizione_Coltivazione value) {
		this.descrizione = value;
	}
	
	private package_diagram_desktop_component.model.Descrizione_Coltivazione getORM_Descrizione() {
		return descrizione;
	}
	
	private void setORM_Impiegato(java.util.Set value) {
		this.ORM_impiegato = value;
	}
	
	private java.util.Set getORM_Impiegato() {
		return ORM_impiegato;
	}
	
	public final package_diagram_desktop_component.model.ImpiegatoSetCollection impiegato = new package_diagram_desktop_component.model.ImpiegatoSetCollection(this, _ormAdapter, package_diagram_desktop_component.model.ORMConstants.KEY_COLTIVAZIONE_IMPIEGATO, package_diagram_desktop_component.model.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public void getAreaColtivata() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void modificaAmbiente() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void getTipo() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getAttribute());
	}
	
}
