package packagediagramdesktopcomponent.Alarms;

public class Allarme2 extends Allarme{
	String mex;
	public Allarme2()
	{
		mex="Sensore di umidit� mal funzionante";
	}
	
	@Override
	public String getErrore()
	{
		return mex;
	}
}
