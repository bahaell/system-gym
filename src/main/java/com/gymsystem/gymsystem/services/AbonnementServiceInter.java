package com.gymsystem.gymsystem.services;

import java.util.List;

import com.gymsystem.gymsystem.entities.Abonnement;

public interface AbonnementServiceInter {

	//Abonnement abonnerOffre(Long membreId, Long codeOffre, Abonnement abonnement);

	void checkAndNotifyAbonnementsExpiry();


	List<Abonnement> getListAbonnements();

	List<Abonnement> getListAbonnementsByOffre(Long codeOffre);

	List<Abonnement> getListAbonnementsByMembre(Long membreId);

	Abonnement abonnerOffre(Long membreId, Long codeOffre);

}
