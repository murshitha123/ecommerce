package com.utility;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.testng.Reporter;



public class SendFileEmail {
	
	String smtpServer = "smtp.gmail.com";
	//String toAddress = null;
	String fromAddress = "smurshi@gmail.com";
	String subject = "Extent Report of the executio:-";
	String body = "Hello All, \r\n" + 
			"\r\n" + 
			"Please find the attached generated detailed reports.\r\n" + 
			"\r\n" + 
			" Thanks, \r\n" + 
			" Automation Team\r\n" + 
			"";
	
	String filename1 = Utility.ExtenthtmlReportPath();
	
	public SendFileEmail(){
		super();
	}
	
	public void setMailWithAttachmentParams(String smtpServer,String toAddress, String fromAddress, String subject,String body, String filename1)
	{
		this.smtpServer=smtpServer;
		//this.toAddress = toAddress;
		this.fromAddress = fromAddress;
		this.subject = subject;
		this.body = body;
		this.filename1 = filename1;
	}
	
	public boolean sendMailWithAttachmentNew(String filename1, String toAddress)
	{
			try
			{
				//Set the host smtp address
				Properties props = new Properties();
				// this will set host of server- you can change based on your requirement 
				props.put("mail.smtp.host", "smtp.gmail.com");
		 
				// set the port of socket factory 
				props.put("mail.smtp.socketFactory.port", "465");
		 
				// set socket factory
				props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		 
				// set the authentication to true
				props.put("mail.smtp.auth", "true");
		 
				// set the port of SMTP server
				props.put("mail.smtp.port", "465");
				props.put("mail.transport.protocol", "smtp");
				//get the default Session
				// This will handle the complete authentication
				Session session = Session.getDefaultInstance(props,
		 
						new javax.mail.Authenticator() {
		 
							protected PasswordAuthentication getPasswordAuthentication() {
		 
							return new PasswordAuthentication("smurshi@gmail.com", "Pas4@gmail");
							}
				});
			

				//Create a message
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(fromAddress));
				//Adding multiple recipients
				InternetAddress[] toAddressArray = InternetAddress.parse(toAddress);			
				message.addRecipients(Message.RecipientType.TO, toAddressArray);			
				message.setSubject(subject);
				// Create the message part 
				BodyPart messageBodyPart = new MimeBodyPart();
				// Fill the message
				messageBodyPart.setText(body);
				Multipart multipart = new MimeMultipart();
				multipart.addBodyPart(messageBodyPart);		
				// Part two is attachment, attach detailed report
				messageBodyPart = new MimeBodyPart();
				Reporter.log( "attached detailed report :" + filename1);			
				DataSource source = new FileDataSource(filename1);			
				messageBodyPart.setDataHandler(new DataHandler(source));	
				messageBodyPart.setFileName(filename1.substring(filename1.lastIndexOf(File.separator)+1,filename1.length()));
				multipart.addBodyPart(messageBodyPart);

				// Put parts in message
				message.setContent(multipart);
	
				// Send the message
				Transport transport = session.getTransport();
				transport.connect();
				//transport.send(message, message.getAllRecipients());
				Transport.send(message);
				System.out.println("=====Email Sent=====");
				return true;
			}
			catch (SendFailedException sfe)
			{
				sfe.printStackTrace();				
				return false;
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
				return false;
			}

		}

}
