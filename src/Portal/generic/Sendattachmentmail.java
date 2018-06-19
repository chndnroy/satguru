package Portal.generic;

import java.io.IOException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class Sendattachmentmail {
	public void sendmail() throws IOException {

		String to = "varun.tyagi@techtreeit.com";// change accordingly
		final String user = "chandan.roy@techtreeit.com";// change accordingly
		final String password = "chndnroy123*";// change accordingly

		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Automation Test Report");

			BodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1.setText("Hi sir, please find status");

			MimeBodyPart messageBodyPart2 = new MimeBodyPart();

			String filename = "/home/ttuser10/Desktop/testShots";// change
																									// accordingly
			DataSource source = new FileDataSource(filename);
			messageBodyPart2.setDataHandler(new DataHandler(source));
			messageBodyPart2.setFileName(filename);
			

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart1);
			multipart.addBodyPart(messageBodyPart2);

		message.setContent(multipart);
//		Multipart multipart1 = new MimeMultipart();
//			multipart1.addBodyPart(messageBodyPart1);
//			multipart1.addBodyPart(messageBodyPart2);
//
//			message.setContent(multipart);
//			
//			DataSource source1 = new FileDataSource("/home/ttuser10/Desktop/RegressionLogs");
//			messageBodyPart2.setDataHandler(new DataHandler(source1));
//			messageBodyPart2.setFileName(filename);
//			message.setContent(multipart1);

			Transport.send(message);

			System.out.println("message sent....");
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
	}

}