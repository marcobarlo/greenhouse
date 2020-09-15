package packagediagramdesktopcomponent.Connection;

public class Allarme1 extends MexAllarme{
	String mex;
	public Allarme1(int idAmb)
	{
		super(idAmb);
		mex="Sensore di temperatura mal funzionante";
	}
	
	@Override
	public String getMex()
	{
		return mex;
	}
	
	@Override
	public int getSensoreMalfunzionante()
	{
		return 1;
	}
}
