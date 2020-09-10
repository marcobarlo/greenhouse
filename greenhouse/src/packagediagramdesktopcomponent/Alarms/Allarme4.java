package packagediagramdesktopcomponent.Alarms;

public class Allarme4 extends Allarme{
	String mex;
	public Allarme4()
	{
		mex="Attuatore di temperatura mal funzionante";
	}
	
	@Override
	public String getErrore()
	{
		return mex;
	}
}
