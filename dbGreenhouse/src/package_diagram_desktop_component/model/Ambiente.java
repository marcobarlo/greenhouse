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
	
	private int temperatura_target;
	
	private int irradianza_target;
	
	private int umidità_aria_target;
	
	private int umidità_suolo_target;
	
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
	
	public void setTemperatura_target(int value) {
		this.temperatura_target = value;
	}
	
	public int getTemperatura_target() {
		return temperatura_target;
	}
	
	public void setIrradianza_target(int value) {
		this.irradianza_target = value;
	}
	
	public int getIrradianza_target() {
		return irradianza_target;
	}
	
	public void setUmidità_aria_target(int value) {
		this.umidità_aria_target = value;
	}
	
	public int getUmidità_aria_target() {
		return umidità_aria_target;
	}
	
	public void setUmidità_suolo_target(int value) {
		this.umidità_suolo_target = value;
	}
	
	public int getUmidità_suolo_target() {
		return umidità_suolo_target;
	}
	
	public String toString() {
		return String.valueOf(getAttribute());
	}
	
}
