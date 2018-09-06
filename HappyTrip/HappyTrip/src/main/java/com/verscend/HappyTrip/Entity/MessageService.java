package com.verscend.HappyTrip.Entity;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
	public String senderMail = "Nitish.Manandhar@verscend.com";
	public String recieverMail = "Nitish.Manandhar@verscend.com";
	private String host = "localhost";

	public MessageService(String senderMail, String recieverMail) {
		this.senderMail = senderMail;
		this.recieverMail = recieverMail;
	}

	public MessageService() {

	}

	public void SendMail() {
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		Session session = Session.getDefaultInstance(properties);
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(senderMail));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(recieverMail));
			message.setSubject("This is the Subject Line!");
			message.setText("This is actual message");
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
