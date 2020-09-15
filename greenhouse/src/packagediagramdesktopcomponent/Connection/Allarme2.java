package packagediagramdesktopcomponent.Connection;


public class Allarme2 extends Allarme{
	protected Allarme2(int idAmb)
	{
		super(idAmb);
		mex="Sensore di umidità mal funzionante";
	}
	
	@Override
	public int getSensoreMalfunzionante()
	{
		return 2;
	}
}
