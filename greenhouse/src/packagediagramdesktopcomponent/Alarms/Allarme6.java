package packagediagramdesktopcomponent.Alarms;

public class Allarme6 extends Allarme{
	String mex;
	public Allarme6()
	{
		mex="Attuatore di irradianza mal funzionante";
	}
	
	@Override
	public String getErrore()
	{
		return mex;
	}
}
