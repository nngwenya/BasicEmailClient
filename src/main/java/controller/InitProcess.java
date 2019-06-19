package controller;

import view.ScreenBuilder;

public class InitProcess {
	
	public static void main(String[] args) {  
		
		ScreenBuilder screen = new ScreenBuilder();
		
		screen.indexPage();
	}
	
//	  SwingUtilities.invokeLater(new Runnable() {
//          @Override
//          public void run() {
//              SendEmailClient client = new SendEmailClient();
//              client.setVisible(true);
//          }
//      });

}
