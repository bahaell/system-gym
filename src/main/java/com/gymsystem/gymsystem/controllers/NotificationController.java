package com.gymsystem.gymsystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gymsystem.gymsystem.entities.Notification;
import com.gymsystem.gymsystem.services.NotificationServiceImpl;

@RestController
public class NotificationController {
	@Autowired /* appel le service injection de dependance*/
	NotificationServiceImpl notificationServ;
	
	
	@PostMapping(value = "/addnotification/{iduser}")
	public Notification addNotification(@PathVariable Long iduser,@RequestBody Notification notification) {
		return notificationServ.addNotification(iduser,notification);
	
	}
	

	@PostMapping(value = "/updateNotification/{codeNotif}")
	public Notification updatenotification(@PathVariable Long codeNotif,@RequestBody Notification notification) {
		return notificationServ.updateNotification(codeNotif,notification);
	
	}
	@DeleteMapping(value = "/deletenotification/{idNotification}")
	public void deleteNotification(@PathVariable Long codeNotif) {
		notificationServ.deleteNotification(codeNotif);
	}
	
	@GetMapping(value = "/getListnotification")
	public List<Notification> getListNotification() {
		 return notificationServ.getListNotification();
	}
	
	@GetMapping(value = "/getListnotificationByUser/{iduser}")
	public List<Notification> getListNotificationByUser(Long iduser){
		 return notificationServ.getListNotificationByUser(iduser);
	}
	 @PostMapping("/markNotificationAsRead/{notificationId}")
	    public void markNotificationAsRead(@PathVariable Long notificationId) {
	        notificationServ.markNotificationAsRead(notificationId);
	    }
	


}
