package packagediagramdesktopcomponent.Alarms;

public class Allarme5 extends Allarme{
	String mex;
	public Allarme5()
	{
		mex="Attuatore di umidit� mal funzionante";
	}
	public Allarme5(float delta)
	{
		mex="Attuatore di umidit� mal funzionante, l'umidit� del suolo attuale dista "+delta+" % da quella target";
	}
	@Override
	public String getErrore()
	{
		return mex;
	}
}
