package packagediagramdesktopcomponent.Alarms;

public class Allarme1 extends Allarme{
	String mex;
	public Allarme1()
	{
		mex="Sensore di temperatura mal funzionante";
	}
	
	@Override
	public String getErrore()
	{
		return mex;
	}
}
