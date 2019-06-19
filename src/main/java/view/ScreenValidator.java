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

}
