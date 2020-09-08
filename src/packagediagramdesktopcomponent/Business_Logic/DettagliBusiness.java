package packagediagramdesktopcomponent.Business_Logic;

public class DettagliBusiness {
	private String descrizione;
	private float temperatura_target;
	private float umidita_target;
	private float irradianza_target;

	public DettagliBusiness()
	{
		
	}
	
	public DettagliBusiness(String desc, float t, float u, float i)
	{
		this.descrizione = desc;
		this.temperatura_target = t;
		this.umidita_target = u;
		this.irradianza_target = i;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public float getTemperatura_target() {
		return temperatura_target;
	}

	public void setTemperatura_target(float temperatura_target) {
		this.temperatura_target = temperatura_target;
	}

	public float getUmidita_target() {
		return umidita_target;
	}

	public void setUmidita_target(float umidita_target) {
		this.umidita_target = umidita_target;
	}

	public float getIrradianza_target() {
		return irradianza_target;
	}

	public void setIrradianza_target(float irradianza_target) {
		this.irradianza_target = irradianza_target;
	}

}
