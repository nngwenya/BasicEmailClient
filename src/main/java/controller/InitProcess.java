package controller;

import services.BasicMail;
import services.MailSender;
import services.PropertyFetcher;
import view.ScreenBuilder;
import services.ScreenValidator;

import java.util.Arrays;

public class InitProcess {
	
	public static void main(String[] args) {  
		
		ScreenBuilder screen = new ScreenBuilder();
		MailSender mailSender = new MailSender();
		PropertyFetcher fetcher = new PropertyFetcher();
		ScreenValidator validator = new ScreenValidator();
		InitProcess controller = new InitProcess();
		screen.displayEmailView(mailSender, fetcher, validator, controller );
	}

	public BasicMail createBasicMail(String recipients, String cc, String bcc, String subject, String body)
	{
		//just maps the strings into BasicMail object
		BasicMail basicMail = new BasicMail();
		basicMail.setRecipients(Arrays.asList(recipients.trim().split(";")));
		basicMail.setCc(Arrays.asList(cc.trim().split(";")));
		basicMail.setBcc(Arrays.asList(bcc.trim().split(";")));
		basicMail.setSubject(subject);
		basicMail.setBody(body);
		return basicMail;
	}
}
