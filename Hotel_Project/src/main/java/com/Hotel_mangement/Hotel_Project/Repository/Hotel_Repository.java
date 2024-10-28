package com.Hotel_mangement.Hotel_Project.Repository;

import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.Hotel_mangement.Hotel_Project.Hotel_Entity.Hotel;
import com.Hotel_mangement.Hotel_Project.Hotel_Entity.OnlineFood;

import jakarta.transaction.Transactional;

public interface Hotel_Repository extends JpaRepository<Hotel, Integer> {


	OnlineFood save(OnlineFood theOnlineFood);
	

	

	
	

}
