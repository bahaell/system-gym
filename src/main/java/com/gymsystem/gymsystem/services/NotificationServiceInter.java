package com.gymsystem.gymsystem.services;

import java.util.List;

import com.gymsystem.gymsystem.entities.Notification;

public interface NotificationServiceInter {
	
	public Notification addNotification(Long iduser,Notification notification);
	public Notification updateNotification(Long codeNotif,Notification notification);
	public void deleteNotification(Long codeNotif);
	public List<Notification> getListNotification();
	public List<Notification> getListNotificationByUser(Long iduser);
	void markNotificationAsRead(Long codeNotif);
}
