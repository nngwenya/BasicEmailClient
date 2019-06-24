package Model;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;

public class PropertyFetcher {

	
	public void property() {
		
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.mailtrap.io");
		prop.put("mail.smtp.port", "25");
		prop.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");
		
//		Session session = Session.getInstance(prop, new Authenticator() {
//		    @Override
//		    protected PasswordAuthentication getPasswordAuthentication() {
//		        return new PasswordAuthentication(username, password);
//		    }
//		});
}


}
