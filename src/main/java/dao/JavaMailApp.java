package dao;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class JavaMailApp {
	 public static void main(String[] args) {
         Properties props = new Properties();
         /** Parâmetros de conexão com servidor Gmail */
         props.put("mail.smtp.host", "smtp.gmail.com");
         props.put("mail.smtp.socketFactory.port", "465");
         props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
         props.put("mail.smtp.auth", "true");
         props.put("mail.smtp.port", "465");

         Session session = Session.getDefaultInstance(props,
                     new javax.mail.Authenticator() {
                          protected PasswordAuthentication getPasswordAuthentication()
                          {
                                return new PasswordAuthentication("adelino18fernandes@gmail.com", "botesuasenhaaqui");
                          }
                     });

         /** Debug para sessão */
         session.setDebug(true);

         try {

               Message message = new MimeMessage(session);
               message.setFrom(new InternetAddress("adelino18fernandes8@gmail.com")); //Remetente

               Address[] recipientes = InternetAddress //Destinatário(s)
                          .parse("aafavelino@icloud.com, adelino-afonso@hotmail.com, Pedrohbcavalcante@outlook.com");  

               message.setRecipients(Message.RecipientType.TO, recipientes);
               message.setSubject("Enviando email com JavaMail");//Assunto
               message.setText("Enviei este email utilizando JavaMail com minha conta GMail!");
               /**Enviar a mensagem criada*/
               Transport.send(message);

               System.out.println("Feito!!!");

          } catch (MessagingException e) {
               throw new RuntimeException(e);
         }
   }
}