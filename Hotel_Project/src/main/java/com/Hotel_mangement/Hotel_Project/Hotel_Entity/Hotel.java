package com.Hotel_mangement.Hotel_Project.Hotel_Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "Hotel_Details")
public class Hotel {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="Id")
	@jakarta.persistence.Id
	private int Id;
	
	
	@Column(name="fullname")
	private String fullname;
	
	
	
	@Column(name="email")
	private String email;
	
	@Column(name="contact")
	private Long contact;
	
	
	@Column(name="check_in")
	private String check_in;
	
	
	@Column(name="check_out")
	private String check_out;
	
	
	@Column(name="guest")
	private int guest;
	
	
	
	
	
	

	public Hotel()
	{
		
	}







	public Hotel(int id, String fullname, String email, Long contact, String check_in, String check_out, int guest) {
		super();
		Id = id;
		this.fullname = fullname;
		this.email = email;
		this.contact = contact;
		this.check_in = check_in;
		this.check_out = check_out;
		this.guest = guest;
	}







	public Hotel(String fullname, String email, Long contact, String check_in, String check_out, int guest) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.contact = contact;
		this.check_in = check_in;
		this.check_out = check_out;
		this.guest = guest;
	}







	public int getId() {
		return Id;
	}







	public void setId(int id) {
		Id = id;
	}







	public String getFullname() {
		return fullname;
	}







	public void setFullname(String fullname) {
		this.fullname = fullname;
	}







	public String getEmail() {
		return email;
	}







	public void setEmail(String email) {
		this.email = email;
	}







	public Long getContact() {
		return contact;
	}







	public void setContact(Long contact) {
		this.contact = contact;
	}







	public String getCheck_in() {
		return check_in;
	}







	public void setCheck_in(String check_in) {
		this.check_in = check_in;
	}







	public String getCheck_out() {
		return check_out;
	}







	public void setCheck_out(String check_out) {
		this.check_out = check_out;
	}







	public int getGuest() {
		return guest;
	}







	public void setGuest(int guest) {
		this.guest = guest;
	}







	@Override
	public String toString() {
		return "Hotel [Id=" + Id + ", fullname=" + fullname + ", email=" + email + ", contact=" + contact
				+ ", check_in=" + check_in + ", check_out=" + check_out + ", guest=" + guest + "]";
	}

	
	
	

}
