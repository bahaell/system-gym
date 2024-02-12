package com.gymsystem.gymsystem.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.gymsystem.gymsystem.entities.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long>{
	
}
