package com.gymsystem.gymsystem.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gymsystem.gymsystem.entities.Coach;
import com.gymsystem.gymsystem.entities.Cours;
import com.gymsystem.gymsystem.entities.Membre;
import com.gymsystem.gymsystem.entities.Notification;
import com.gymsystem.gymsystem.entities.Planning;
import com.gymsystem.gymsystem.entities.Status;
import com.gymsystem.gymsystem.repository.CoachRepository;
import com.gymsystem.gymsystem.repository.CoursRepository;
import com.gymsystem.gymsystem.repository.MembreRepository;
import com.gymsystem.gymsystem.repository.OffreRepository;
import com.gymsystem.gymsystem.repository.PlanningRepository;
import com.gymsystem.gymsystem.repository.UserRepository;

@Service
public class PlanningServiceImpl implements PlanningServiceInter{
	
	@Autowired
	UserRepository userRep;
	@Autowired
	PlanningRepository planningRep;
	@Autowired
	CoursRepository coursRep;
	@Autowired
	OffreRepository offreRep;
	@Autowired
	MembreRepository membreRep;
	@Autowired
	CoachRepository coachRep;
	@Autowired
	NotificationServiceImpl notificationSer;


	
	  @Override
	public Planning planifiercours ( Long coachId , Long coursId ) {
		 Coach coach = coachRep.findById(coachId).orElseThrow(() -> new RuntimeException("Membre non trouvé avec l'ID: " + coachId));		 
	     Cours cours = coursRep.findById(coursId).orElseThrow(() -> new RuntimeException("L'offre non trouvé avec le code : " + coursId));
	     Planning planning = new Planning();
	     planning.setCoach(coach);
	     planning.setCours(cours);
	     planning.setDay(planning.getDay());
	     planning.setStartTime(planning.getStartTime());
	     planning.setEndTime(planning.getEndTime());
	     planningRep.save(planning);
	     cours.setNomC(coach.getSpécialité());
	     coursRep.save(cours);
	     List<Membre> membresActifs = (List<Membre>) membreRep.findAllByStatus(Status.ACTIVE);
	     
	     for (Membre membre : membresActifs) {
	         Notification notification = new Notification();
	         notification.setMessage("Un nouveau cours " + cours.getNomC() + " a été planifié avec le coach "
	                 + planning.getCoach().getNom() + " "
	                 + planning.getCoach().getPrénom()
	                 + " pour le " + planning.getDay() + ". \n Assurez-vous d'être présent!");
	         notificationSer.addNotification(membre.getId(), notification);
	     }
       return planning;
  }
	  
	

	  @Override
	  public List<Planning> getListPlanning() {
	      return planningRep.findAll();
	  }
	  @Override
	  public List<Planning> getListPlanningByCoach(Long coachId) {
		  Coach coach = coachRep.findById(coachId).orElseThrow(() -> new RuntimeException("L'offre non trouvé avec le code : " + coachId));
		return planningRep.findByCoach(coach);
	  }
	  @Override
	  public List<Planning> getListPlanningByCours(Long coursId) {
	      Cours cours = coursRep.findById(coursId).orElseThrow(() -> new RuntimeException("Membre non trouvé avec l'ID: " + coursId));
	      return planningRep.findByCours(cours);
	  }

		  
	  
	  
	  
}