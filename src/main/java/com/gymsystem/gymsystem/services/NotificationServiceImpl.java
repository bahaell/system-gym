package com.gymsystem.gymsystem.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymsystem.gymsystem.entities.Notification;
import com.gymsystem.gymsystem.entities.User;
import com.gymsystem.gymsystem.repository.NotificationRepository;
import com.gymsystem.gymsystem.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
@Service
public class NotificationServiceImpl implements NotificationServiceInter{
	
	@Autowired
	NotificationRepository notificationRep;
	@Autowired
	UserRepository userRep;
	@Override
	public Notification addNotification(Long iduser,Notification notification) {
		 User existingUser = userRep.getUserById(iduser);
		 if (existingUser != null) {
			 notification.setUser(existingUser);
			 notification.setMessage(notification.getMessage());
			 notification.setTimestamp(LocalDateTime.now());
			 return notificationRep.save(notification);}
		 else {
			 throw new IllegalArgumentException("Utilisateur n'existe pas. ");
		 }
		
	}


 
	public Notification updateNotification(Long codeNotif, Notification notification) {

	    if (notificationRep.existsById(codeNotif)) {
			Notification existingNotification = notificationRep.findById(codeNotif).get();
			existingNotification.setMessage(notification.getMessage()!= null ? notification.getMessage() : existingNotification.getMessage());


	        notificationRep.save(existingNotification);
	    } else {
	        throw new RuntimeException("La notification avec le code " + codeNotif + " n'existe pas.");
	    }
		return notification;
	}
	@Override
	public void deleteNotification(Long codeNotif) {
	    if (notificationRep.existsById(codeNotif)) {
		
	    	notificationRep.deleteById(codeNotif);
	        System.out.println("La notification avec le code" + codeNotif + " a été supprimé avec succès.");

	    } else {
	        throw new RuntimeException("La notification avec le code" + codeNotif + " n'existe pas.");
	    }
		
	}
	@Override
	 public void markNotificationAsRead(Long codeNotif) {
	        Notification notification = notificationRep.findById(codeNotif)
	                .orElseThrow(() -> new EntityNotFoundException("Notification not found with ID: " + codeNotif));

	        notification.markAsRead();
	        notificationRep.save(notification);
	    }
	@Override
	public List<Notification> getListNotification() {
		return notificationRep.findAll();
	}
	@Override
	public List<Notification> getListNotificationByUser(Long iduser) {
		 User existingUser = userRep.getUserById(iduser);
		 if (existingUser != null) {
			 return notificationRep.findAll();}
		 else {
			 throw new IllegalArgumentException("Utilisateur n'existe pas. ");
		 }
		
	}



}
