package packagediagramdesktopcomponent.Business_Logic;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import packagediagramdesktopcomponent.model.Impiegato;

public class ControllerUtenti {
	private static String session;
	protected static String login(String mail, String pass)
	{
		MessageDigest digest;
		String encr;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			byte[] encodedhash = digest.digest(
			pass.getBytes(StandardCharsets.UTF_8));
			encr = bytesToHex(encodedhash);
		}catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		session = Impiegato.login(mail,encr);
		return session;
	}
	private static String bytesToHex(byte[] hash) {
	    StringBuffer hexString = new StringBuffer();
	    for (int i = 0; i < hash.length; i++) {
	    String hex = Integer.toHexString(0xff & hash[i]);
	    if(hex.length() == 1) hexString.append('0');
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}
}