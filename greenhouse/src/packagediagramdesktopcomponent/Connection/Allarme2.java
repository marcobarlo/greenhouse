package packagediagramdesktopcomponent.Connection;


public class Allarme2 extends MexAllarme{
	String mex;
	public Allarme2(int idAmb)
	{
		super(idAmb);
		mex="Sensore di umidità mal funzionante";
	}
	
	@Override
	public String getMex()
	{
		return mex;
	}
	
	@Override
	public int getSensoreMalfunzionante()
	{
		return 2;
	}
}
