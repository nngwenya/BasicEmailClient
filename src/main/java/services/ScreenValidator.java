package services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScreenValidator {

	private String errorHeading = null;
	private String errorMessage = null;
	private String warningHeading = null;
	private String warningMessage = null;


	public String getErrorHeading() {
		return errorHeading;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getWarningHeading() {
		return warningHeading;
	}

	public String getWarningMessage() {
		return warningMessage;
	}

	public boolean invalidAddresses(String to, String cc, String bcc)
	{
		//need to write proper check using the commons validator
		return false;
	}

	public boolean isSubjectOrBodyEmpty(String subject, String body)
	{
		//need to write proper check using the commons validator
		return false;
	}

}
