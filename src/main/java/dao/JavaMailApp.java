package dao;
import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import controle.JavaMailAppMBean;


public class JavaMailApp {
	 public static void main(String[] args) {
		 ArrayList<String> emails = new ArrayList<>();
		 
		 emails.add("aafavelino@icloud.com");
		 emails.add("adelino18fernandes@gmail.com");
		 JavaMailAppMBean email =  new JavaMailAppMBean();
		 email.enviarEmail("Teste", "Uma mensagem qualquer", emails);
   }
}
