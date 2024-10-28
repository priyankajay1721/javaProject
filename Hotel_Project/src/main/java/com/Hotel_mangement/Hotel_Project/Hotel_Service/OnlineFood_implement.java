package com.Hotel_mangement.Hotel_Project.Hotel_Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hotel_mangement.Hotel_Project.Hotel_Entity.OnlineFood;
import com.Hotel_mangement.Hotel_Project.Repository.OnlineFood_Repository;
@Service
public class OnlineFood_implement implements OnlineFoodService {
	@Autowired
	private OnlineFood_Repository theRepository;
	


	public OnlineFood_implement(OnlineFood_Repository theRepository) {
		super();
		this.theRepository = theRepository;
	}



	@Override
	public List<OnlineFood> findAll() {
		// TODO Auto-generated method stub
		return theRepository.findAll();
	}



	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		 theRepository.deleteById(theId);
		
	}

	
}
