package Package_diagram_desktop_component.Model;

import java.util.*;

public class Ambiente {

	Area_Coltivata area_coltivata;
	private int temperatura_target;
	private int irradianza_target;
	private int umidità_aria_target;
	private int umidità_suolo_target;
	
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
	
	public int getUmidità_aria_target() {
		return umidità_aria_target;
	}
	
	public void setUmidità_aria_target(int umidità_aria_target) {
		this.umidità_aria_target = umidità_aria_target;
	}
	
	public int getUmidità_suolo_target() {
		return umidità_suolo_target;
	}
	
	public void setUmidità_suolo_target(int umidità_suolo_target) {
		this.umidità_suolo_target = umidità_suolo_target;
	}

}