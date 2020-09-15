package packagediagramdesktopcomponent.Alarms;

import packagediagramdesktopcomponent.Connection.Allarme1;
import packagediagramdesktopcomponent.Connection.Allarme2;
import packagediagramdesktopcomponent.Connection.Allarme3;
import packagediagramdesktopcomponent.Connection.Allarme4;
import packagediagramdesktopcomponent.Connection.Allarme5;
import packagediagramdesktopcomponent.Connection.Allarme6;

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
	public static Allarme buildAllarme(int code, float delta)
	{
		switch(code)
		{
			case 4:
				return new Allarme4(delta);
			case 5:
				return new Allarme5(delta);
			case 6:
				return new Allarme6(delta);
		 	default: return new Allarme();
		}
	}
	
	public String getErrore()
	{
		return "Errore generico";
	}
}
