package com.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;
import java.util.jar.Attributes.Name;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.DaoBase;
import com.domain.Content;
import com.domain.FormInputtedDomain;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Service class for Spring framework. Here we declaring bussines logic for
 * application.
 * 
 * @author Tihomir Puhalo
 *
 */

@Service
@Transactional
public class MainService {

	private static final String fromMail = "noReply@app.com";

	private static final String replyToMail = "";

	private static final String toEmail = "tihomir.puhalo@gmail.com";

	private static final String subject = "mailSubsctiption";

	private static final String userSender = "User";

	private static final String passSender = "userPassword";

	String url = "http://jsonplaceholder.typicode.com/users";

	@Autowired
	DaoBase daoBase;

	/**
	 * Class for checking inputed data. If email of inputed data is already assigned
	 * some of online Json data, then we are parsing that data to database, and
	 * sending mail with that json object.
	 * 
	 * Otherwise we are saving inputed data in database, and sending mail with that
	 * data.
	 * 
	 * @param form
	 * @return error
	 * @throws IOException
	 */
	public String checkFormInputted(FormInputtedDomain form) throws IOException {
		String error = "";

		JsonElement onlineForm = getOnlineForm(form.getEmail());
		JsonObject gForm = objectToJson(form);
	
		if (onlineForm.toString().equals("[]")) {
			Content saveForm = new Content();
			saveForm.setName(gForm.toString());
			daoBase.save(saveForm);
			sendMail(gForm.toString());
			error = "Your form was saved in database." + gForm.toString();
		} else {
			Content saveOnlineForm = new Content();
			saveOnlineForm.setName(onlineForm.toString());
			daoBase.save(saveOnlineForm);
			sendMail(onlineForm.toString());
			error = "Online form was saved in database." + onlineForm.toString();
		}

		return error;
	}

	private JsonElement getOnlineForm(String email) throws IOException {
		URL emailURL;
		URLConnection request = null;

		try {
			emailURL = new URL(url + "?email=" + email);
			request = emailURL.openConnection();
			request.connect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		JsonParser jp = new JsonParser();
		JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));

		return root;
	}

	public JsonObject objectToJson(FormInputtedDomain object) {
		JsonObject gForm = new JsonObject();
		gForm.addProperty("name", object.getName());
		gForm.addProperty("surname", object.getSurname());
		gForm.addProperty("email", object.getEmail());
		return gForm;
	}

	public static void sendMail(String body) {
		String host = "smtp.gmail.com";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userSender, passSender);
			}
		});
		mailOut(session, body);

	}

	public static void mailOut(Session session, String body) {
		try {
			MimeMessage msg = new MimeMessage(session);

			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			msg.setFrom(new InternetAddress(fromMail, "NoReply-JD"));

			msg.setReplyTo(InternetAddress.parse(replyToMail, false));

			msg.setSubject(subject, "UTF-8");

			msg.setText(body, "UTF-8");

			msg.setSentDate(new Date());

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
			Transport.send(msg);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean getUpdatedTime() {
		boolean check = false;
		LocalDateTime currentTime = LocalDateTime.now();
		LocalDateTime lastUpdated = format(daoBase.getSubmitTime().toString().replaceAll(" ", "T"));

		Duration dur = Duration.between(currentTime, lastUpdated);
		Duration oneHour = Duration.ofHours(1L);
		if (dur.compareTo(oneHour) < 0) {
			check = true;
		} else {
			check = false;
		}
		return check;

	}

	public String getBaseUpdatedTime() {
		String time ="";
		try {
			time=  daoBase.getSubmitTime().toString().replaceAll(" ", "T").toString();
		} catch (NullPointerException ex) {
			time= "Time is null.";
		}
		return time;
	}

	public LocalDateTime format(String time) {
		DateTimeFormatter format = DateTimeFormatter.ISO_DATE_TIME;
		LocalDateTime formattedTime = LocalDateTime.parse(time, format);
		return formattedTime;
	}
}
