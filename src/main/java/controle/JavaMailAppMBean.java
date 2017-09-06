package controle;

import java.util.ArrayList;
import java.util.Properties;

import javax.faces.bean.ManagedBean;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@ManagedBean
public class JavaMailAppMBean {

	public Session session;
	/**Teste*/ ArrayList<String> emails =  new ArrayList<String>();
	private String menssagem = null;
	private String assunto = null;
	
	
	
	public ArrayList<String> getEmails() {
		return emails;
	}

	public void setEmails(ArrayList<String> emails) {
		this.emails = emails;
	}

	public String getMenssagem() {
		return menssagem;
	}

	public void setMenssagem(String menssagem) {
		this.menssagem = menssagem;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public JavaMailAppMBean() {
		// TODO Auto-generated constructor stub
        Properties props = new Properties();
        // Parâmetros de conexão com servidor Gmail
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                         protected PasswordAuthentication getPasswordAuthentication()
                         {
                               return new PasswordAuthentication("adelino18fernandes@gmail.com", "senha");
                         }
                    });

        //Debug para sessão 
        session.setDebug(true);
        /**Teste*/ //emails.add("adelino18fernandes@gmail.com");
        /**Teste*/ emails.add("aafavelino@icloud.com");
        		   //emails.add("adelino18fernandes@gmail.com");
        
       
	}
	
	public void enviarEmail() {
        try {
        	String mail = "";
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("adelino18fernandes@gmail.com")); //Remetente
            
            Address[] recipientes = null;
            
            for (String string : emails) {
            	if(string != null)
            		mail += string + ", ";
            	
			}
            
            recipientes = InternetAddress.parse(mail);
              

            message.setRecipients(Message.RecipientType.TO, recipientes);
            message.setSubject(assunto);//Assunto
            message.setText(menssagem);//Mensagem
            /**Enviar a mensagem criada*/
            Transport.send(message);

            System.out.println("Feito!!!");

       } catch (MessagingException e) {
            throw new RuntimeException(e);
      }
	}
}
