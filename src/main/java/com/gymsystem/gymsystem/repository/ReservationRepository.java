package com.gymsystem.gymsystem.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gymsystem.gymsystem.entities.Coach;
import com.gymsystem.gymsystem.entities.Membre;
import com.gymsystem.gymsystem.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

	List<Reservation> findByCoach(Coach coach);

	List<Reservation> findByMembre(Membre membre);

	
}
