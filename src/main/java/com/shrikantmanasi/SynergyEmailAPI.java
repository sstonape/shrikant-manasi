package com.shrikantmanasi;

import java.util.Properties;

import javax.mail.MessagingException;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class SynergyEmailAPI {
	
	private static final String HOST_MAIL_DEBUG_KEY = "mail.debug";
	private static final String HOST_SMTP_STARTTLS_ENABLE_KEY = "mail.smtp.starttls.enable";
	private static final String HOST_SMTP_AUTH_KEY = "mail.smtp.auth";
	private static final String HOST_USERNAME = "support@synergymarketresearch.com";
	private static final String HOST_NAME = "localhost";
	private static final String HOST_PASSWORD = "synergy@99";
	private static final String HOST_VALUE = "smtp";
	private static final String SMTP_HOST_KEY = "synergymarketres";
	private static final String HOST_SMTP_STARTTLS_ENABLE_VALUE = "false";
	private static final String HOST_MAIL_DEBUG_VALUE = "true";
	
	private static JavaMailSenderImpl javaMailSenderImpl;
	
	public void readyToSendEmail(String toAddress, String fromAddress, String ccAddress, String bccAddress, String subject, String msgBody) throws MessagingException {
		SimpleMailMessage synergyMsg = new SimpleMailMessage();
		synergyMsg.setFrom(fromAddress);
		synergyMsg.setTo(toAddress);
		synergyMsg.setCc(ccAddress);
		synergyMsg.setBcc(bccAddress);
		synergyMsg.setSubject(subject);
		synergyMsg.setText(msgBody);
		javaMailSenderImpl = getMailSenderInstance();
		javaMailSenderImpl.send(synergyMsg);
	}     
	
	public JavaMailSenderImpl getMailSenderInstance() {
		if ( javaMailSenderImpl == null ) {
			javaMailSenderImpl = new JavaMailSenderImpl();
			Properties properties = javaMailSenderImpl.getJavaMailProperties();
			properties.setProperty(SMTP_HOST_KEY, HOST_VALUE);
			properties.setProperty(HOST_SMTP_AUTH_KEY, HOST_SMTP_STARTTLS_ENABLE_VALUE);
			properties.setProperty(HOST_SMTP_STARTTLS_ENABLE_KEY, HOST_SMTP_STARTTLS_ENABLE_VALUE);
			properties.setProperty(HOST_MAIL_DEBUG_KEY, HOST_MAIL_DEBUG_VALUE);
			javaMailSenderImpl.setHost(HOST_NAME);
			javaMailSenderImpl.setUsername(HOST_USERNAME);
			javaMailSenderImpl.setPassword(HOST_PASSWORD);
		}
		return javaMailSenderImpl;
	}
}
