package com.Hotel_mangement.Hotel_Project.Hotel_Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Hotel_mangement.Hotel_Project.Hotel_Entity.Hotel;
import com.Hotel_mangement.Hotel_Project.Hotel_Entity.OnlineFood;
import com.Hotel_mangement.Hotel_Project.Repository.Hotel_Repository;

import jakarta.transaction.Transactional;

public interface HotelService {
	
	
	Hotel save(Hotel theHotel);

	List<Hotel> findAll();
	
	OnlineFood save (OnlineFood theOnlineFood);
	
	void deleteById(int theId);


	 Hotel findById(int theId);

	Hotel updateHotel(int Id, Hotel theHotel);
	 
	 


	 
	 
	 

	
	
	
   

	

}
