package com.Hotel_mangement.Hotel_Project.Hotel_Service;

import java.util.List;

import com.Hotel_mangement.Hotel_Project.Hotel_Entity.OnlineFood;

public interface OnlineFoodService {
	
	 List<OnlineFood> findAll();
	 
	 void deleteById(int theId);

}
