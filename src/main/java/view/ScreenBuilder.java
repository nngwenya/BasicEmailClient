package view;

import controller.InitProcess;
import services.BasicMail;
import services.MailSender;
import services.PropertyFetcher;
import services.ScreenValidator;

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
	private ScreenValidator validator;

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
		btnClear.setBounds(140, 640, 80,20);
	}

	private  void setListeners()
	{
		btnSend.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (validator.invalidAddresses(txtTo.getText(), txtCC.getText(), txtBCC.getText())) {
					warningPopup(validator.getErrorHeading(), validator.getErrorMessage(), "error"); //passing string literal here this is bad practice but... meh. Enum? maybe
					return;
				}
				if (validator.isSubjectOrBodyEmpty(txtSubject.getText(), txtEmailBody.getText())) {
					warningPopup(validator.getWarningHeading(), validator.getWarningMessage(), "warning");
				}
				BasicMail basicMail = controller.createBasicMail(txtTo.getText(), txtCC.getText(), txtBCC.getText(),
																txtSubject.getText(), txtEmailBody.getText());
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

	private void warningPopup(String header, String message, String type)
	{
		 if(type.equalsIgnoreCase("error")) {
			 JOptionPane.showMessageDialog(btnSend, message, header, JOptionPane.WARNING_MESSAGE);
			 return;
		 }
		 JOptionPane optionPane = new JOptionPane(message,JOptionPane.WARNING_MESSAGE);
		 JDialog dialog = optionPane.createDialog(header);
		 optionPane.setOptionType(JOptionPane.OK_CANCEL_OPTION);
		 dialog.setAlwaysOnTop(true);
		 dialog.setVisible(true);
	}


	public  void displayEmailView(MailSender sender, PropertyFetcher fetcher, ScreenValidator validator, InitProcess controller)
	{
		initEmailView();
		this.controller = controller;
		this.sender = sender;
		this.fetcher = fetcher;
		this.validator = validator;
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
