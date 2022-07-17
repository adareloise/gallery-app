package cl.gallery.webapp.models.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import cl.gallery.webapp.models.email.Mail;

@Service
public class EmailServiceImpl implements MailService {

	@Autowired
	JavaMailSender mailSender;

	@Override
	public void sendEmail(Mail mail) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		 
        try {
 
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
 
            mimeMessageHelper.setSubject(mail.getMailSubject());
            mimeMessageHelper.setFrom(new InternetAddress(mail.getMailFrom(), "artevalparaiso.cl"));
            mimeMessageHelper.setTo(mail.getMailTo());
            mimeMessageHelper.setCc(mail.getMailCc());
            mimeMessageHelper.setText(mail.getNombre()+"\n"+ "He recibido el siguiente mensaje:"+"\n"+"\n"+
            mail.getMailContent()+"\n"
            +"\n"+"Saludos"+"\n"+"Fernando Concha");
            
            mailSender.send(mimeMessageHelper.getMimeMessage());
 
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
	}

}
