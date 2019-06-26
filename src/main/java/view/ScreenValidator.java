package view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScreenValidator {
	
	 public static boolean isValid(String email) 
	 { 
	        String emailPattern =  "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
				                    "[a-zA-Z0-9_+&*-]+)*@" + 
				                    "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
				                    "A-Z]{2,7}$";
	                              
	        Pattern pattern = Pattern.compile(emailPattern); 
	        if (email == null) 
	            return false; 
	        Matcher m = pattern.matcher(email);
	        return m.matches(); 
	  }
	 
	 public static boolean noEmail(String email) {
		 
		 if (email == null || email.isEmpty())
			 return true;
		 return false;
	 }
	 
	 public static boolean noSubject(String subject) {
		 
		 if (subject == null || subject.isEmpty())
			 return true;
		 return false;
	 }
	 
	 public static boolean noText(String text) {
		 
		 if (text == null || text.isEmpty())
			 return true;
		 return false;
	 }

}
