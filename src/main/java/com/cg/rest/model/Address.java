package com.cg.rest.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Address 
{	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long addressId;
	@Column(nullable=false)
	private String city;
	@Column(nullable=false)
	private String district;
	@Column(nullable=false)
	private  String state;
	@Column(nullable=false)
	private String country;
//	@Column(nullable=false)
	@NotEmpty(message="Please provide zipcode")
	private int zipcode;
	private String landmark;
	
	
	public Address() {
		super();
	}
	
	public Address(String city, String district, String state, String country, int zipcode,
			String landmark) {
		super();
		this.city = city;
		this.district = district;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
		this.landmark = landmark;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", city=" + city + ", district=" + district + ", state=" + state
				+ ", country=" + country + ", zipcode=" + zipcode + ", landmark=" + landmark + "]";
	}
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
}
