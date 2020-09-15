package packagediagramdesktopcomponent.Connection;

public class Allarme6 extends MexAllarme{
	String mex;
	public Allarme6(int idAmb)
	{
		super(idAmb);
		mex="Attuatore di irradianza mal funzionante";
	}
	public Allarme6(int idAmb,float delta)
	{
		super(idAmb);
		mex="Attuatore di irradianza mal funzionante, l'irradianza attuale dista "+delta+" lux da quella target";
	}
	@Override
	public String getMex()
	{
		return mex;
	}
}
