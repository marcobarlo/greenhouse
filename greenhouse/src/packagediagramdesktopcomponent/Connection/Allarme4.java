package packagediagramdesktopcomponent.Connection;


public class Allarme4 extends MexAllarme{
	String mex;
	public Allarme4(int idAmb)
	{
		super(idAmb);
		mex="Attuatore di temperatura mal funzionante";
	}
	public Allarme4(int idAmb,float delta)
	{
		super(idAmb);
		mex="Attuatore di temperatura mal funzionante, la temperatura attuale dista "+delta+" °C da quella target";
	}
	
	@Override
	public String getMex()
	{
		return mex;
	}
	
}
