package packagediagramdesktopcomponent.model;

public class AmbienteAttuale {
	private float umiditaAttuale;
	private float temperaturaAttuale;
	private float irradianzaAttuale;
	public float getUmiditaAttuale() {
		return umiditaAttuale;
	}
	public void setUmiditaAttuale(float umiditaAttuale) {
		this.umiditaAttuale = umiditaAttuale;
	}
	public float getTemperaturaAttuale() {
		return temperaturaAttuale;
	}
	public void setTemperaturaAttuale(float temperaturaAttuale) {
		this.temperaturaAttuale = temperaturaAttuale;
	}
	public float getIrradianzaAttuale() {
		return irradianzaAttuale;
	}
	public void setIrradianzaAttuale(float irradianzaAttuale) {
		this.irradianzaAttuale = irradianzaAttuale;
	}
	public AmbienteAttuale()
	{
		
	}
	public AmbienteAttuale(float umidita,float temperatura,float irradianza)
	{
		umiditaAttuale = umidita;
		temperaturaAttuale = temperatura;
		irradianzaAttuale = irradianza;
	}
}
