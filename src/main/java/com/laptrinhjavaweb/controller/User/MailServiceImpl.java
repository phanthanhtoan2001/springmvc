package com.laptrinhjavaweb.controller.User;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailServiceImpl implements MailService
{

	@Autowired
	JavaMailSender mailSender;

	public void sendEmail(final String senderEmailId, final String receiverEmailId,
			final String subject, final String message)
	{

		MimeMessagePreparator preparator = new MimeMessagePreparator()
		{

			public void prepare(MimeMessage mimeMessage) throws Exception
			{
				mimeMessage.setFrom(senderEmailId);
				mimeMessage.setRecipient(Message.RecipientType.TO,
						new InternetAddress(receiverEmailId));
				mimeMessage.setSubject(subject,"UTF-8");
				mimeMessage.setContent(message, "text/html; charset=UTF-8");
				//mimeMessage.setText(message);

			}
		};

		try
		{
			mailSender.send(preparator);
			System.out.println("Message Sent...Hurrey");
		}
		catch (Exception exe)
		{
			exe.printStackTrace();
		}
	}
}