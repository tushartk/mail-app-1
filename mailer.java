import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailer {
public static void send(String to,String subject,String msg){

final String user="myhome_tushark@yahoo.co.in";
final String pass="****************";

	
Properties props = new Properties();
props.put("mail.smtp.host", "mail.yahoo.com");
props.put("mail.smtp.auth", "true");

Session session = Session.getInstance(props,
 new javax.mail.Authenticator() {
  protected PasswordAuthentication getPasswordAuthentication() {
   return new PasswordAuthentication(user,pass);
   }
});

try {
 MimeMessage message = new MimeMessage(session);
 message.setFrom(new InternetAddress(user));
 message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
 message.setSubject(subject);
 message.setText(msg);
 

 Transport.send(message);

 System.out.println("Done");

 } catch (MessagingException e) {
	throw new RuntimeException(e);
 }
	
}
}
