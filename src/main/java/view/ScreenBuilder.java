package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ScreenBuilder {
	 static JFrame f; 
	 static JButton create, send, Clear, Close;
	 static JLabel label1, label2, label3;
	 static JTextField text1, text2;
	 static JTextArea textarea;
	 
	public static void close(){
	     f.setVisible(false);
	     f.dispose();
	}
	
	public void indexPage() {
		
		f = new JFrame("Basic Email Client");
		create =new JButton("Create Email");
		
		create.setBounds(700,500,600,50);  
		f.add(create);
		
		
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//f.setSize(400,400);  
		f.setLayout(null);  
		f.setVisible(true);
		
		create.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  close();
				  creatEmail();
			  } 
		} );
	}
	
	public void creatEmail() {
		
		f = new JFrame("Compose email");
		
		text1 = new JTextField();
		text2 = new JTextField();
		
		label1 = new JLabel("To :");
		label2 = new JLabel("Subject :");
		label3 = new JLabel("Compose email");
	
		
		textarea = new JTextArea();
		
		send =new JButton("Send");
		Clear=new JButton("Clear");
		Close =new JButton("Close");
		
		text1.setBounds(600,60,900,40);
		text2.setBounds(600,130,900,40);
		label1.setBounds(520,60,600,50);
		label2.setBounds(520,130,600,50);
		textarea.setBounds(600,200,900,600);
		send.setBounds(600,800,100,40);
		Clear.setBounds(700,800,100,40);
		Close.setBounds(1400,800,100,40);
		
		
		f.add(text1);
		f.add(text2);
		f.add(label1);
		f.add(label2);
		f.add(textarea);
		f.add(send);
		f.add(Clear);
		f.add(Close);
		
		
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		f.setLayout(null);  
		f.setVisible(true);
		
		Close.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  close();
			  } 
		} );
		
		Clear.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  textarea.setText("");
			  } 
		} );
		
		send.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				 String email = text1.getText();
				  
				  if (ScreenValidator.isValid(email)) {
					  
				  }else {
					  JOptionPane.showMessageDialog(send,"You have entered an Invalid email."); 
				  }
			  } 
		} );
		
	}

}
