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

public class Area_Coltivata {
	public Area_Coltivata() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == package_diagram_desktop_component.model.ORMConstants.KEY_AREA_COLTIVATA_SEZIONE) {
			this.sezione = (package_diagram_desktop_component.model.Sezione) owner;
		}
		
		else if (key == package_diagram_desktop_component.model.ORMConstants.KEY_AREA_COLTIVATA_COLTIVAZIONE) {
			this.coltivazione = (package_diagram_desktop_component.model.Coltivazione) owner;
		}
		
		else if (key == package_diagram_desktop_component.model.ORMConstants.KEY_AREA_COLTIVATA_AMBIENTE) {
			this.ambiente = (package_diagram_desktop_component.model.Ambiente) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int attribute;
	
	private package_diagram_desktop_component.model.Sezione sezione;
	
	private int ID;
	
	private int fila;
	
	private int posizione;
	
	private float estensione;
	
	private String tipo_di_terreno;
	
	private package_diagram_desktop_component.model.Ambiente ambiente;
	
	private package_diagram_desktop_component.model.Coltivazione coltivazione;
	
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
	
	public void setFila(int value) {
		this.fila = value;
	}
	
	public int getFila() {
		return fila;
	}
	
	public void setPosizione(int value) {
		this.posizione = value;
	}
	
	public int getPosizione() {
		return posizione;
	}
	
	public void setEstensione(float value) {
		this.estensione = value;
	}
	
	public float getEstensione() {
		return estensione;
	}
	
	public void setTipo_di_terreno(String value) {
		this.tipo_di_terreno = value;
	}
	
	public String getTipo_di_terreno() {
		return tipo_di_terreno;
	}
	
	public void setSezione(package_diagram_desktop_component.model.Sezione value) {
		if (sezione != null) {
			sezione.aree.remove(this);
		}
		if (value != null) {
			value.aree.add(this);
		}
	}
	
	public package_diagram_desktop_component.model.Sezione getSezione() {
		return sezione;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Sezione(package_diagram_desktop_component.model.Sezione value) {
		this.sezione = value;
	}
	
	private package_diagram_desktop_component.model.Sezione getORM_Sezione() {
		return sezione;
	}
	
	public void setColtivazione(package_diagram_desktop_component.model.Coltivazione value) {
		if (this.coltivazione != value) {
			package_diagram_desktop_component.model.Coltivazione lcoltivazione = this.coltivazione;
			this.coltivazione = value;
			if (value != null) {
				coltivazione.setArea(this);
			}
			if (lcoltivazione != null && lcoltivazione.getArea() == this) {
				lcoltivazione.setArea(null);
			}
		}
	}
	
	public package_diagram_desktop_component.model.Coltivazione getColtivazione() {
		return coltivazione;
	}
	
	public void setAmbiente(package_diagram_desktop_component.model.Ambiente value) {
		this.ambiente = value;
	}
	
	public package_diagram_desktop_component.model.Ambiente getAmbiente() {
		return ambiente;
	}
	
	public void modificaAmbiente() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getAttribute());
	}
	
}
