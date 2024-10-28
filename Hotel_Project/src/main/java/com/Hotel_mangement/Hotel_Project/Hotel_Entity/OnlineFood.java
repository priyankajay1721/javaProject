package com.Hotel_mangement.Hotel_Project.Hotel_Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name="online_food")
public class OnlineFood {
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "Id")
	private int Id;
	
	@Column(name ="full_name")
	private String fullName;
	
	@Column(name ="email")
	private String email;
	
	@Column(name ="contact")
	private Long contact;
	
	@Column(name= "address")
	private String address;
	
	@Column(name="room_no")
	private String room_no;
	
	@Column(name ="food")
	private String food;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="special_instruction")
	private String special_instruction;

	public OnlineFood()
	{
		
	}

	public OnlineFood(int id, String fullName, String email, Long contact, String address, String room_no, String food,
			int quantity, String special_instruction) {
		super();
		Id = id;
		this.fullName = fullName;
		this.email = email;
		this.contact = contact;
		this.address = address;
		this.room_no = room_no;
		this.food = food;
		this.quantity = quantity;
		this.special_instruction = special_instruction;
	}

	public OnlineFood(String fullName, String email, Long contact, String address, String room_no, String food,
			int quantity, String special_instruction) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.contact = contact;
		this.address = address;
		this.room_no = room_no;
		this.food = food;
		this.quantity = quantity;
		this.special_instruction = special_instruction;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRoom_no() {
		return room_no;
	}

	public void setRoom_no(String room_no) {
		this.room_no = room_no;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSpecial_instruction() {
		return special_instruction;
	}

	public void setSpecial_instruction(String special_instruction) {
		this.special_instruction = special_instruction;
	}

	@Override
	public String toString() {
		return "OnlineFood [Id=" + Id + ", fullName=" + fullName + ", email=" + email + ", contact=" + contact
				+ ", address=" + address + ", room_no=" + room_no + ", food=" + food + ", quantity=" + quantity
				+ ", special_instruction=" + special_instruction + "]";
	}
	
	
	
	
}
