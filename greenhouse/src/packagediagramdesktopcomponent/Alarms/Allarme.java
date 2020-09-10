package packagediagramdesktopcomponent.Alarms;

public class Allarme 
{
	public static Allarme buildAllarme(int code)
	{
		switch(code)
		{
		case 1:
			return new Allarme1();
		case 2:
    		return new Allarme2();
    	case 3:
    		return new Allarme3();
    	case 4:
    		return new Allarme4();
    	case 5:
    		return new Allarme5();
    	case 6:
    		return new Allarme6();
    	default: return new Allarme();
		}
	}
	
	public String getErrore()
	{
		return "Errore generico";
	}
}
