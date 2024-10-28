package com.Hotel_mangement.Hotel_Project.Hotel_Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hotel_mangement.Hotel_Project.Hotel_Entity.RoomDetails;
import com.Hotel_mangement.Hotel_Project.Repository.RoomDetailsRepository;

import jakarta.persistence.EntityManager;

@Service
public class RoomSeviceImplent implements RoomDetailService {
	
	@Autowired
	private RoomDetailsRepository theRoomRepository;
	private EntityManager entityManager;
	
	@Autowired
	public RoomSeviceImplent(RoomDetailsRepository roomRepository, EntityManager entityManager)
	{
		roomRepository = theRoomRepository;
	}

	@Override
	public List<RoomDetails> findAll() {
		// TODO Auto-generated method stub
		return theRoomRepository.findAll() ;
	}

}
