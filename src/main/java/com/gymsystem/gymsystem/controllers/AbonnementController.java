package com.gymsystem.gymsystem.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gymsystem.gymsystem.entities.Abonnement;
import com.gymsystem.gymsystem.services.AbonnementServiceImpl;


@RestController

public class AbonnementController {
	@Autowired
	AbonnementServiceImpl abonnementSer;

    @PostMapping("/abonner/{memberId}/{codeOffre}")
    public Abonnement abonnerOffre(
            @PathVariable Long memberId,
            @PathVariable Long codeOffre
            
           ) {

    	return abonnementSer.abonnerOffre(memberId, codeOffre);

         
    }
    @PostMapping()
    public void checkAndNotifyAbonnementsExpiry() {
    	
    }
    @GetMapping(value = "/getListabonnementByMembre/{membreId}")
    public List<Abonnement> getListAbonnementsByMembre(@PathVariable Long membreId) {
        return abonnementSer.getListAbonnementsByMembre(membreId);
    }
    @GetMapping(value = "/getListabonnementByOffre/{codeOffre}")
    public List<Abonnement> getListAbonnementsByOffre(@PathVariable Long codeOffre) {
        return abonnementSer.getListAbonnementsByOffre(codeOffre);
    }
    @GetMapping(value = "/getListabonnement")
    public List<Abonnement> getListAbonnements() {
        return abonnementSer.getListAbonnements();
    }
}