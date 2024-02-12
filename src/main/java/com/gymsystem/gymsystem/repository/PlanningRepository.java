package com.gymsystem.gymsystem.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gymsystem.gymsystem.entities.Coach;
import com.gymsystem.gymsystem.entities.Cours;

import com.gymsystem.gymsystem.entities.Planning;

public interface PlanningRepository extends JpaRepository<Planning, Long>{


	List<Planning> findByCoach(Coach coach);

	List<Planning> findByCours(Cours cours);

	
}
