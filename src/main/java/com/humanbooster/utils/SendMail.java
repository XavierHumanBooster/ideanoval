package com.humanbooster.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	

	public static boolean envoyerMailSMTP(String mailUser) {

		try {

			String smtpHost = "smtp.gmail.com";
			String from = "ideanovalhbs3@gmail.com";
			String to = mailUser;
			String username = "ideanovalhbs3@gmail.com";
			String password = "ideanoval";

			Properties props = new Properties();
			props.put("mail.smtp.host", smtpHost);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.user", username);
			props.put("mail.smtp.password", password);
			props.put("mail.smtp.starttls.enable", "true");

			 Authenticator auth = new Authenticator() {
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication(from, password);
	                }
	            };
			
	        Session session = Session.getInstance(props, auth);

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Confirmation d'inscription");
			message.setText("Merci de valider votre inscription en cliquant sur le lien suivant");

			Transport tr = session.getTransport("smtp");
			tr.connect(smtpHost, username, password);
			message.saveChanges();

			Transport.send(message);
			tr.close();

			return true;
		} catch (NoSuchProviderException e) {
			System.err.println("Pas de transport disponible pour ce protocole");
			System.err.println(e);
			return false;
		} catch (AddressException e) {
			System.err.println("Adresse invalide");
			System.err.println(e);
			return false;
		} catch (MessagingException e) {
			System.err.println("Erreur dans le message");
			System.err.println(e);
			e.printStackTrace();
			return false;
		}
	}

}
