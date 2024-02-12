package com.gymsystem.gymsystem.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gymsystem.gymsystem.entities.Membre;
import com.gymsystem.gymsystem.entities.Status;

public interface MembreRepository extends JpaRepository<Membre, Long>{

	List<Membre> findAllByStatus(Status active);
	
}
