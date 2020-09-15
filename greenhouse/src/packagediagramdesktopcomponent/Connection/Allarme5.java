package packagediagramdesktopcomponent.Connection;


public class Allarme5 extends MexAllarme{
	String mex;
	public Allarme5(int idAmb)
	{
		super(idAmb);
		mex="Attuatore di umidità mal funzionante";
	}
	public Allarme5(int idAmb,float delta)
	{
		super(idAmb);
		mex="Attuatore di umidità mal funzionante, l'umidità del suolo attuale dista "+delta+" % da quella target";
	}
	@Override
	public String getMex()
	{
		return mex;
	}
}
