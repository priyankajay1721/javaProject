package com.Hotel_mangement.Hotel_Project.Hotel_Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hotel_mangement.Hotel_Project.Hotel_Entity.Hotel;
import com.Hotel_mangement.Hotel_Project.Hotel_Entity.OnlineFood;
import com.Hotel_mangement.Hotel_Project.Repository.Hotel_Repository;

import jakarta.persistence.EntityManager;
@Service
public class ServiceImplementing implements HotelService{
	@Autowired
	private Hotel_Repository repository;
	EntityManager entityManager ;

	@Autowired
	public ServiceImplementing(Hotel_Repository hotelRepsitory,EntityManager entityManager) {
		hotelRepsitory = repository;
	}
	
	

	@Override
	public List<Hotel> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}



	@Override
	public Hotel save(Hotel theHotel) {
		// TODO Auto-generated method stub
		return repository.save(theHotel);
	}



	@Override
	public OnlineFood save(OnlineFood theOnlineFood) {
		// TODO Auto-generated method stub
		return repository.save(theOnlineFood);
	}



	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		repository.deleteById(theId);
		
		
	}



	@Override
	public Hotel findById(int theId) {
		Optional<Hotel> result = repository.findById(theId);
		
		Hotel theHotel = null;
		
		if(result.isPresent()) {
			theHotel = result.get();
		}
		else {
			throw new RuntimeException("Did Not Find The Customer Id -"+ theId);
		}
		return theHotel;
	}



	 public Hotel updateHotel(int Id, Hotel updatedHotel) {
	        Optional<Hotel> optionalHotel = repository.findById(Id);
	        if (optionalHotel.isPresent()) {
	            Hotel existingHotel = optionalHotel.get();
	            existingHotel.setFullname(updatedHotel.getFullname());
	            existingHotel.setEmail(updatedHotel.getEmail());
	            existingHotel.setContact(updatedHotel.getContact());
	            existingHotel.setCheck_in(updatedHotel.getCheck_in());
	            existingHotel.setCheck_out(updatedHotel.getCheck_out());
	            existingHotel.setGuest(updatedHotel.getGuest());
	            return repository.save(existingHotel);  // This will update the existing entity
	        } else {
	            // Handle the case where the Hotel with the given ID is not found
	            throw new RuntimeException("Hotel not found with id: " + Id);
	        }
	    }


	



	
	
	
	



	


	

}
