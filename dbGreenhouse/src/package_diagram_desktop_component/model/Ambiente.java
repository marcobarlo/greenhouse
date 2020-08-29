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

public class Ambiente {
	public Ambiente() {
	}
	
	private int attribute;
	
	private int ID;
	
	private int temperaturaTarget;
	
	private int irradianzaTarget;
	
	private int umiditaAriaTarget;
	
	private int umiditaSuoloTarget;
	
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
	
	public void setTemperaturaTarget(int value) {
		this.temperaturaTarget = value;
	}
	
	public int getTemperaturaTarget() {
		return temperaturaTarget;
	}
	
	public void setIrradianzaTarget(int value) {
		this.irradianzaTarget = value;
	}
	
	public int getIrradianzaTarget() {
		return irradianzaTarget;
	}
	
	public void setUmiditaAriaTarget(int value) {
		this.umiditaAriaTarget = value;
	}
	
	public int getUmiditaAriaTarget() {
		return umiditaAriaTarget;
	}
	
	public void setUmiditaSuoloTarget(int value) {
		this.umiditaSuoloTarget = value;
	}
	
	public int getUmiditaSuoloTarget() {
		return umiditaSuoloTarget;
	}
	
	public String toString() {
		return String.valueOf(getAttribute());
	}
	
}
