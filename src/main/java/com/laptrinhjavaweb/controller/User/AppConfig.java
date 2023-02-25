package com.laptrinhjavaweb.controller.User;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@ComponentScan(basePackages = "com.laptrinhjavaweb")
public class AppConfig
{

	@Bean
	public JavaMailSender getMailSender()
	{
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

		// Using Gmail SMTP configuration.
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);

		/*
		 * Use your gmail id and password
		 */
		mailSender.setUsername("tiennguyennaraka@gmail.com");
		mailSender.setPassword("ejvtoerwvhxgrbng");

		Properties javaMailProperties = new Properties();
		javaMailProperties.put("mail.smtp.starttls.enable", "true");
		javaMailProperties.put("mail.smtp.auth", "true");
		javaMailProperties.put("mail.transport.protocol", "smtp");
		javaMailProperties.put("mail.debug", "true");

		mailSender.setJavaMailProperties(javaMailProperties);
		return mailSender;
	}
}