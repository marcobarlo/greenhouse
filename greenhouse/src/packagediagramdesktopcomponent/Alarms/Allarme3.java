package packagediagramdesktopcomponent.Alarms;

public class Allarme3 extends Allarme{
	String mex;
	public Allarme3()
	{
		mex="Sensore di irradianza mal funzionante";
	}
	
	@Override
	public String getErrore()
	{
		return mex;
	}
}
