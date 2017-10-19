package br.com.igor.emailsender;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	public void send(String nome, String toEmail) {
		
		try {
            Email email = new SimpleEmail();
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("springbootalura@gmail.com", "springboot"));
            email.setSSLOnConnect(true);

            email.setFrom("springbootalura@gmail.com");
            email.setSubject("Você foi convidado pelo ListaVIP");
            email.setMsg("Olá " + nome + ". Você acaba de ser convidado pelo ListaVIP.");
            email.addTo(toEmail);
            email.send();

        } catch (EmailException e) {
            e.printStackTrace();
        }
		
	}
}
