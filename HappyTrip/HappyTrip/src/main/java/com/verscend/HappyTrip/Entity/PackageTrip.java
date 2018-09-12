package com.verscend.HappyTrip.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;

@Entity
@Table(name = "PackageTrip")
public class PackageTrip {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQUENCE1")
	@SequenceGenerator(name="SEQUENCE1", sequenceName="SEQUENCE1", allocationSize=1)
	@Column(name = "id")
	private int id;
	

	@Override
	public String toString() {
		return "PackageTrip [id=" + id + ", packageDesc=" + packageDesc
				+ ", imagesLocation=" + imagesLocation + ", location=" + location + ", days=" + days + ", price="
				+ price + ", startDate=" + "]";
	}

	@Lob
	@Column(name = "packageDesc")
	private String packageDesc;

	@Column(name = "imagesLocation")
	private String imagesLocation;



	@Column(name = "location")
	private String location;

	@Column(name = "days")
	private String days;

	@Column(name = "price")
	private String price;


	public PackageTrip() {

	}

	public PackageTrip(int id, String packageDesc, String imagesLocation, String location, String days,
			String price, Date startDate, Date endDate, String packageName) {
		super();
		this.id = id;
		this.packageDesc = packageDesc;
		this.imagesLocation = imagesLocation;
		this.location = location;
		this.days = days;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPackageDescription() {
		return packageDesc;
	}

	public void setPackageDescription(String packageDesc) {
		this.packageDesc = packageDesc;
	}

	public String getImagesLocation() {
		return imagesLocation;
	}

	public void setImagesLocation(String imagesLocation) {
		this.imagesLocation = imagesLocation;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	

}
