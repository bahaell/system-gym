package com.gymsystem.gymsystem.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.gymsystem.gymsystem.entities.Coach;

public interface CoachRepository extends JpaRepository<Coach, Long>{
	
}
