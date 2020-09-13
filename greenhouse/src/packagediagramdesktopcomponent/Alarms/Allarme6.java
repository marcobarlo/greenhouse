package packagediagramdesktopcomponent.Alarms;

public class Allarme6 extends Allarme{
	String mex;
	public Allarme6()
	{
		mex="Attuatore di irradianza mal funzionante";
	}
	public Allarme6(float delta)
	{
		mex="Attuatore di irradianza mal funzionante, l'irradianza attuale dista "+delta+" lux da quella target";
	}
	@Override
	public String getErrore()
	{
		return mex;
	}
}
