package packagediagramdesktopcomponent.Alarms;

public class Allarme5 extends Allarme{
	String mex;
	public Allarme5()
	{
		mex="Attuatore di umidit� mal funzionante";
	}
	
	@Override
	public String getErrore()
	{
		return mex;
	}
}
