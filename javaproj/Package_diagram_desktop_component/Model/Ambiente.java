package Package_diagram_desktop_component.Model;

import java.util.*;

public class Ambiente {

	Area_Coltivata area_coltivata;
	private int temperatura_target;
	private int irradianza_target;
	private int umidit�_aria_target;
	private int umidit�_suolo_target;
	
	public int getTemperatura_target() {
		return temperatura_target;
	}
	
	public void setTemperatura_target(int temperatura_target) {
		this.temperatura_target = temperatura_target;
	}
	
	public int getIrradianza_target() {
		return irradianza_target;
	}
	
	public void setIrradianza_target(int irradianza_target) {
		this.irradianza_target = irradianza_target;
	}
	
	public int getUmidit�_aria_target() {
		return umidit�_aria_target;
	}
	
	public void setUmidit�_aria_target(int umidit�_aria_target) {
		this.umidit�_aria_target = umidit�_aria_target;
	}
	
	public int getUmidit�_suolo_target() {
		return umidit�_suolo_target;
	}
	
	public void setUmidit�_suolo_target(int umidit�_suolo_target) {
		this.umidit�_suolo_target = umidit�_suolo_target;
	}

}