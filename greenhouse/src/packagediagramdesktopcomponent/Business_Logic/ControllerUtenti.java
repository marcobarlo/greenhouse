package packagediagramdesktopcomponent.Business_Logic;

import packagediagramdesktopcomponent.model.Impiegato;

public class ControllerUtenti {
	private static String session;
	protected static String login(String mail, String pass)
	{
		session = Impiegato.login(mail,pass);
		return session;
	}
	protected static String getSessionRole() {
		return session;
	}
	public static void logOut() {
		session=null;
	}
}