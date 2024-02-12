package com.gymsystem.gymsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gymsystem.gymsystem.services.AbonnementServiceImpl;

@SpringBootApplication
public class GymsystemApplication {

	@Autowired
	
     AbonnementServiceImpl abonnementSer;
	public static void main(String[] args) {
		SpringApplication.run(GymsystemApplication.class, args);
		
	}
	  public void run(String... args) throws Exception {
	        abonnementSer.checkAndNotifyAbonnementsExpiry();
	    }


}
