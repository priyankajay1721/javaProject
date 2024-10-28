package com.Hotel_mangement.Hotel_Project.Hotel_Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name="Room_Details")
public class RoomDetails {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name ="Id")
	@jakarta.persistence.Id
	private int Id;
	
	@Column(name ="room_type")
	private String room_type;
	
	@Column(name = "price")
	private int price;
	
	
	public RoomDetails()
	{
		
	}


	public RoomDetails(int id, String room_type, int price) {
		super();
		Id = id;
		this.room_type = room_type;
		this.price = price;
	}


	public RoomDetails(String room_type, int price) {
		super();
		this.room_type = room_type;
		this.price = price;
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getRoom_type() {
		return room_type;
	}


	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "RoomDetails [Id=" + Id + ", room_type=" + room_type + ", price=" + price + "]";
	}
	
	

}
