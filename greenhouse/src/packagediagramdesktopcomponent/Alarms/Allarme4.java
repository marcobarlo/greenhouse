package packagediagramdesktopcomponent.Alarms;

public class Allarme4 extends Allarme{
	String mex;
	public Allarme4()
	{
		mex="Attuatore di temperatura mal funzionante";
	}
	public Allarme4(float delta)
	{
		mex="Attuatore di temperatura mal funzionante, la temperatura attuale dista "+delta+" °C da quella target";
	}
	
	@Override
	public String getErrore()
	{
		return mex;
	}
}
