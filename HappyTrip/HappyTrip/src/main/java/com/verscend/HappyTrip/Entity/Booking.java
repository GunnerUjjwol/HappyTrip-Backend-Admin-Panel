package com.verscend.HappyTrip.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "booking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE1")
	@SequenceGenerator(name = "SEQUENCE1", sequenceName = "SEQUENCE1", allocationSize = 1)
	@Column(name = "bookId")
	private int bookId;

	@Column(name = "user")
	private String user;

	

	@Column(name = "bookedDate")
	@Temporal(TemporalType.DATE)
	private Date bookedDate = new Date();

	@Column(name = "location")
	private String location;

	@Column(name = "price")
	private String price;

	@Column(name = "startDate")
	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Column(name = "endDate")
	@Temporal(TemporalType.DATE)
	private Date endDate;

	@Column(name = "bookedstatus")
	@Enumerated(EnumType.STRING)
	private bookedStatus bookedstatus;

	public Booking() {

	}

	

	public Booking(int bookId, String user, Date bookedDate, String location, String price, Date startDate,
			Date endDate, bookedStatus bookedstatus) {
		super();
		this.bookId = bookId;
		this.user = user;
		this.bookedDate = bookedDate;
		this.location = location;
		this.price = price;
		this.startDate = startDate;
		this.endDate = endDate;
		this.bookedstatus = bookedstatus;
	}



	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Date getBookedDate() {
		return bookedDate;
	}

	public void setBookedDate(Date bookedDate) {
		this.bookedDate = bookedDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public bookedStatus getBookedstatus() {
		return bookedstatus;
	}

	public void setBookedstatus(bookedStatus bookedstatus) {
		this.bookedstatus = bookedstatus;
	}



	@Override
	public String toString() {
		return "Booking [bookId=" + bookId + ", user=" + user + ", bookedDate=" + bookedDate + ", location=" + location
				+ ", price=" + price + ", startDate=" + startDate + ", endDate=" + endDate + ", bookedstatus="
				+ bookedstatus + "]";
	}

	

}
