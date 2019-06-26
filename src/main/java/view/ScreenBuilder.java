package view;

import controller.InitProcess;
import services.BasicMail;
import services.MailSender;
import services.PropertyFetcher;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ScreenBuilder {
	private JFrame frame;
	private JPanel panel;
	private JButton btnSend, btnClear;
	private JLabel labelTo, labelCC, labelBCC, labelSubject;
	private JTextField txtTo, txtCC, txtBCC, txtSubject;
	private JTextArea txtEmailBody;

	private InitProcess controller;
	private MailSender sender;
	private PropertyFetcher fetcher;

	private  void initEmailView()
	{
		frame = new JFrame("Basic Email Client");
		panel = new JPanel();
		btnSend = new JButton("Send");
		btnClear = new JButton("Clear");
		labelTo = new JLabel("Recipient(s): ");
		labelBCC = new JLabel("Bcc: ");
		labelCC = new JLabel("CC: ");
		labelSubject = new JLabel("Subject: ");
		txtTo = new JTextField();
		txtBCC = new JTextField();
		txtCC = new JTextField();
		txtSubject = new JTextField();
		txtEmailBody = new JTextArea();
		setBounds();
		setListeners();
		addToPanel();
	}

	private  void setBounds()
	{
		frame.setBackground(Color.gray);
		labelTo.setBounds(40,40,100,20);
		txtTo.setBounds(150, 40,710,20);
		labelCC.setBounds(40, 70, 100, 20);
		txtCC.setBounds(150, 70, 710,20);
		labelBCC.setBounds(40,100, 100,20);
		txtBCC.setBounds(150, 100,710,20);
		labelSubject.setBounds(40,130,100,20);
		txtSubject.setBounds(150,130,710,20);
		txtEmailBody.setBounds(40,160,820,460);
		btnSend.setBounds(40,640, 80,20);
		btnSend.setBackground(Color.cyan);
		btnClear.setBounds(140, 640, 80,20);
		btnClear.setBackground(Color.cyan);
	}

	private  void setListeners()
	{
		btnSend.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				BasicMail basicMail = controller.createBasicMail(txtTo.getText(), txtCC.getText(), txtBCC.getText(), txtEmailBody.getText());
				
				if (ScreenValidator.noEmail(txtTo.getText())) {
					 JOptionPane.showMessageDialog(btnSend,"Please specify at least one recipient.");
			 }
				 else if (ScreenValidator.noSubject(txtSubject.getText()) || ScreenValidator.noText(txtEmailBody.getText())) {
					 
					 	JOptionPane optionPane = new JOptionPane("Send this message without a subject or text in the body?",JOptionPane.WARNING_MESSAGE);
					 	JDialog dialog = optionPane.createDialog("Email");
					 	optionPane.setOptionType(JOptionPane.OK_CANCEL_OPTION);
					 	dialog.setAlwaysOnTop(true);
					 	dialog.setVisible(true);
					 
				 }
				 else if (ScreenValidator.isValid(txtTo.getText())) {
					
				}
				 else {
					  JOptionPane.showMessageDialog(btnSend,"You have entered an Invalid email.","Alert",JOptionPane.WARNING_MESSAGE);
				  }
				 sender.sendMail(basicMail, fetcher);
			}
		});

		btnClear.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				txtTo.setText("");
				txtCC.setText("");
				txtBCC.setText("");
				txtSubject.setText("");
				txtEmailBody.setText("");
			}
		});
	}

	private  void addToPanel()
	{
		panel.add(labelTo);
		panel.add(txtTo);
		panel.add(labelCC);
		panel.add(txtCC);
		panel.add(labelBCC);
		panel.add(txtBCC);
		panel.add(labelSubject);
		panel.add(txtSubject);
		panel.add(txtEmailBody);
		panel.add(btnSend);
		panel.add(btnClear);
	}


	public  void displayEmailView(MailSender sender, PropertyFetcher fetcher, InitProcess controller)
	{
		initEmailView();
		this.controller = controller;
		this.sender = sender;
		this.fetcher = fetcher;
		frame.setContentPane(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(900, 700));
		frame.setResizable(false);
		frame.setLayout(null);
		frame.pack();
		frame.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		//this tries to make the screen pops up in the centre
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
	}



}
