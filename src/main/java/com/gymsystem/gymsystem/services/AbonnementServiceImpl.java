package com.gymsystem.gymsystem.services;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymsystem.gymsystem.entities.Abonnement;
import com.gymsystem.gymsystem.entities.Membre;
import com.gymsystem.gymsystem.entities.Notification;
import com.gymsystem.gymsystem.entities.Offre;
import com.gymsystem.gymsystem.entities.Status;
import com.gymsystem.gymsystem.repository.AbonnementRepository;
import com.gymsystem.gymsystem.repository.MembreRepository;
import com.gymsystem.gymsystem.repository.OffreRepository;
import com.gymsystem.gymsystem.repository.UserRepository;

@Service
public class AbonnementServiceImpl implements AbonnementServiceInter{
	
	@Autowired
	UserRepository userRep;
	@Autowired
	AbonnementRepository abonnementRep;
	@Autowired
	OffreRepository offreRep;
	@Autowired
	MembreRepository membreRep;
	@Autowired
	NotificationServiceImpl notificationSer;


	
	  @Override
	public Abonnement abonnerOffre(Long membreId, Long codeOffre ) {
		 Membre membre = membreRep.findById(membreId).orElseThrow(() -> new RuntimeException("Membre non trouvé avec l'ID: " + membreId));		 
	     Offre offre = offreRep.findById(codeOffre).orElseThrow(() -> new RuntimeException("L'offre non trouvé avec le code : " + codeOffre));
	     membre.setStatus(Status.ACTIVE);
	     userRep.save(membre);
	     Abonnement abonnement = new Abonnement();
	     abonnement.setMembre(membre);
	     abonnement.setOffre(offre);
	     abonnement.setDateInscription(LocalDate.now());
	     abonnement.setDateFinInscription(abonnement.getDateInscription().plusDays(offre.getValidite()));
	     abonnementRep.save(abonnement);
	     
	     Notification notification = new Notification();
	      notification.setMessage("Félicitations " + membre.getPrénom() + "! Votre abonnement à l'offre "
	                 + offre.getNomOffre() + " a été confirmé avec succès. \n Votre abonnement est valable jusqu'au "
	                 + abonnement.getDateFinInscription()+ ". \n"
	                 		+ "Profitez de vos séances d'entraînement!");
	        
	      notificationSer.addNotification(membre.getId(), notification);
       return abonnement;
  }
	  
	  public void checkAndNotifyAbonnementsExpiry() {
	        List<Abonnement> abonnementsExpirant = abonnementRep.findByDateFinInscription(LocalDate.now());
	        
	        for (Abonnement abonnement : abonnementsExpirant) {
	        	Membre membre = abonnement.getMembre();
	        	Notification notification = new Notification();
	  	      	notification.setMessage("Votre abonnement à l'offre " + abonnement.getOffre().getNomOffre()
	  	                + " expire bientôt. Pensez à renouveler votre abonnement pour continuer à profiter de nos services!");
	            notificationSer.addNotification(membre.getId(),notification);
	        }
	    }

	  @Override
	  public List<Abonnement> getListAbonnements() {
	      return abonnementRep.findAll();
	  }
	  @Override
	  public List<Abonnement> getListAbonnementsByOffre(Long codeOffre) {
		Offre offre = offreRep.findById(codeOffre).orElseThrow(() -> new RuntimeException("L'offre non trouvé avec le code : " + codeOffre));
		return abonnementRep.findByOffre(offre);
	  }
	  @Override
	  public List<Abonnement> getListAbonnementsByMembre(Long membreId) {
	      Membre membre = membreRep.findById(membreId).orElseThrow(() -> new RuntimeException("Membre non trouvé avec l'ID: " + membreId));
	      return abonnementRep.findByMembre(membre);
	  }

		  
	  
	  
	  
}