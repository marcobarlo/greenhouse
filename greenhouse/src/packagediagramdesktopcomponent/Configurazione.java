package packagediagramdesktopcomponent;

import packagediagramdesktopcomponent.Business_Logic.DettagliBusiness;
import packagediagramdesktopcomponent.Business_Logic.ControllerFacade;

public class Configurazione {
	private int id;
	private String mac;
	private int sezione;
	private float sogliaTemp;
	private float sogliaUmi;
	private float sogliaIrr;
	private float tempTarget;
	private float umiTarget;
	private float irrTarget;

	Configurazione(int id, String mac,int sez, float sTemp, float sUmi, float sIrr)
	{
		this.id=id;
		this.mac= mac;
		this.sezione= sez;
		this.sogliaTemp = sTemp;
		this.sogliaUmi = sUmi;
		this.sogliaIrr = sIrr;
		DettagliBusiness dett =ControllerFacade.getParametriTarget(id);
		if(dett != null)
		{
			this.tempTarget = dett.getTemperatura_target();
			this.umiTarget = dett.getUmidita_target();
			this.irrTarget = dett.getUmidita_target();
		}
	}
	
	public int getId() {
		return id;
	}
	public String getMac() {
		return mac;
	}
	public int getSezione() {
		return sezione;
	}
	public float getsogliaTemp() {
		return sogliaTemp;
	}
	public float getsogliaUmi() {
		return sogliaUmi;
	}
	public float getsogliaIrr() {
		return sogliaIrr;
	}
	public float getTempTarget() {
		return tempTarget;
	}

	public float getUmiTarget() {
		return umiTarget;
	}

	public float getIrrTarget() {
		return irrTarget;
	}
}
