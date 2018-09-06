package com.verscend.HappyTrip.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "UserMessage")
public class UserMessage {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="SEQUENCE1")
	@SequenceGenerator(name="SEQUENCE1", sequenceName="SEQUENCE1", allocationSize=1)
	@Column(name = "messageId")
	private int messageId;

	@Column(name = "userName")
	private String userName;

	@Column(name = "subject")
	private String subject;

	@Lob
	@Column(name = "message")
	private String message;

	@Column(name = "email")
	private String email;

	public UserMessage() {

	}

	public UserMessage(int messageId, String userName, String subject, String message, String email) {
		super();
		this.messageId = messageId;
		this.userName = userName;
		this.subject = subject;
		this.message = message;
		this.email = email;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
