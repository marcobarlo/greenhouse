package packagediagramdesktopcomponent.Business_Logic;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.orm.PersistentException;

import packagediagramdesktopcomponent.model.Impiegato;
import packagediagramdesktopcomponent.model.ImpiegatoCriteria;

public class ControllerUtenti {
	
	public static String login(String mail, String pass)
	{
		return Impiegato.login(mail,pass);
	}

}