package com.verscend.HappyTrip.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Customers")
public class Customers {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="SEQUENCE1")
	@SequenceGenerator(name="SEQUENCE1", sequenceName="SEQUENCE1", allocationSize=1)
	@Column(name = "id")
	private int id;

	public int getId() {
		return id;
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true
	)
	@JoinColumn(name = "cusId")
	private List<Booking> bookings =  new ArrayList<>();
	
	
	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "age")
	private int age;

	@Column(name = "gender")
	private String gender;

	@Column(name = "phoneNo")
	private String phoneNo;

	@Column(name = "email")
	private String email;
	
	@Column(name = "address")
	private String address;
	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "password")
	private String password;

	public String getFirstName() {
		return firstName;
	}

	public Customers() {

	}

	
	public Customers(int id, String firstName, String lastName, int age, String gender, String phoneNo, String email,
			String address, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.phoneNo = phoneNo;
		this.email = email;
		this.address = address;
		this.password = password;
	}

	

	@Override
	public String toString() {
		return "Customers [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", gender=" + gender + ", phoneNo=" + phoneNo + ", email=" + email + ", address=" + address
				+ ", password=" + password + "]";
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	// Seperated the getter and the setter for booking
	// Getter returns all the list of bookings
	public List<Booking> getBookings() {
		return bookings;
	}

	// Setter sets the single booking in list
	public void setBookings(Booking booking) {
		bookings.add(booking);
	}
		 


}
