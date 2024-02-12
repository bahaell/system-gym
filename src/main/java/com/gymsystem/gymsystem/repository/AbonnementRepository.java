package com.gymsystem.gymsystem.repository;




import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gymsystem.gymsystem.entities.Abonnement;
import com.gymsystem.gymsystem.entities.Membre;
import com.gymsystem.gymsystem.entities.Offre;

public interface AbonnementRepository extends JpaRepository<Abonnement, Long>{

	List<Abonnement> findByDateFinInscription(LocalDate now);

	List<Abonnement> findByOffre(Offre offre);

	List<Abonnement> findByMembre(Membre membre);

	
}
