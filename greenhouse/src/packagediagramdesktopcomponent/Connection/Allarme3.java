package packagediagramdesktopcomponent.Connection;


public class Allarme3 extends MexAllarme{
	String mex;
	public Allarme3(int idAmb)
	{
		super(idAmb);
		mex="Sensore di irradianza mal funzionante";
	}
	
	@Override
	public String getMex()
	{
		return mex;
	}
	
	@Override
	public int getSensoreMalfunzionante()
	{
		return 3;
	}
}
