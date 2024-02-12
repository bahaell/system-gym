package com.gymsystem.gymsystem.services;

import java.util.List;

import com.gymsystem.gymsystem.entities.Contrat;

public interface ContratServiceInter {
	
	public Contrat addContrat(Contrat contrat);
	public List<Contrat> addListContrat(List<Contrat> listcontrat);
	public String addContratWTUN(Contrat contrat);
	public Contrat updateContrat(Long idContrat,Contrat contrat);
	public void deleteContrat(Long idContrat);
	public List<Contrat> getListContrat();
	public Contrat getByContratname(String nomContrat);
	public List<Contrat> getContratSW(String ch);

}
