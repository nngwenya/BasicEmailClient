package controller;

import services.BasicMail;
import services.MailSender;
import services.PropertyFetcher;
import view.ScreenBuilder;

public class InitProcess {
	
	public static void main(String[] args) {  
		
		ScreenBuilder screen = new ScreenBuilder();
		MailSender mailSender = new MailSender();
		PropertyFetcher fetcher = new PropertyFetcher();
		screen.displayEmailView(mailSender, fetcher, new InitProcess());
	}

	public BasicMail createBasicMail(String recipients, String cc, String bcc, String body)
	{
		//validations and return mailModel;
		return null;
	}
}
