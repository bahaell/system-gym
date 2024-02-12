package com.gymsystem.gymsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymsystem.gymsystem.entities.Coach;
import com.gymsystem.gymsystem.entities.Membre;
import com.gymsystem.gymsystem.entities.Notification;
import com.gymsystem.gymsystem.entities.Reservation;
import com.gymsystem.gymsystem.entities.Status;
import com.gymsystem.gymsystem.repository.CoachRepository;
import com.gymsystem.gymsystem.repository.MembreRepository;
import com.gymsystem.gymsystem.repository.ReservationRepository;
import com.gymsystem.gymsystem.repository.UserRepository;

@Service
public class ReservationServiceImpl implements ReservationServiceInter{
	@Autowired
	  ReservationRepository reservationRep;
	@Autowired
	  UserRepository userRep;
	@Autowired
	MembreRepository membreRep;
	@Autowired
	CoachRepository coachRep;
    @Autowired
    private NotificationServiceImpl notificationSer;
	 
	    
	  @Override
	public Reservation reserverCoach(Long membreId, Long coachId, Reservation reservation) {
		 Membre membre = membreRep.findById(membreId).orElseThrow(() -> new RuntimeException("Membre non trouvé avec l'ID: " + membreId));
		 if (membre.getStatus() != Status.ACTIVE) {
	            throw new RuntimeException("Le membre n'est pas actif et ne peut pas réserver un coach.");
	        }
	     Coach coach = (Coach)userRep.findById(coachId).orElseThrow(() -> new RuntimeException("Coach non trouvé avec l'ID: " + coachId));

	     reservation.setMembre(membre);
	     reservation.setCoach(coach);
         reservationRep.save(reservation);
         Notification notification = new Notification();
	      notification.setMessage("Nouvelle réservation ! Vous avez une réservation avec le membre "
	                 + membre.getNom() + " " + membre.getPrénom()
	                 + " pour le " + reservation.getDay() + ". Merci de préparer la session.");
	        
	      notificationSer.addNotification(coach.getId(), notification);
         return reservation;
    }
	  
	  @Override
	  public void annulerReservation(Long reservationId) {
		  Reservation reservation = reservationRep.findById(reservationId).orElseThrow(() -> new RuntimeException("Reservation non trouvé avec l'ID: " + reservationId));
		  reservationRep.deleteById(reservationId);
		  Membre membre = reservation.getMembre();
		  Notification notification = new Notification();
	      notification.setMessage("Votre réservation avec le coach "
                  + reservation.getCoach().getNom() + " "
                  + reservation.getCoach().getPrénom()
                  + " le " + reservation.getDay() + " a été annulée.");
	        
	      notificationSer.addNotification(membre.getId(), notification);
	          
	      System.out.println("Réservation avec l'ID " + reservationId + " annulée avec succès.");
	      	      
	  }
	  @Override
	  public List<Reservation> getListReservations() {
	      return reservationRep.findAll();
	  }
	  @Override
	  public List<Reservation> getListReservationsByCoach(Long coachId) {
	      Coach coach = coachRep.findById(coachId).orElseThrow(() -> new RuntimeException("Coach non trouvé avec l'ID: " + coachId));
	      return reservationRep.findByCoach(coach);
	  }
	  @Override
	  public List<Reservation> getListReservationsByMembre(Long membreId) {
	      Membre membre = membreRep.findById(membreId).orElseThrow(() -> new RuntimeException("Membre non trouvé avec l'ID: " + membreId));
	      return reservationRep.findByMembre(membre);
	  }



}
