package com.gymsystem.gymsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymsystem.gymsystem.entities.Contrat;
import com.gymsystem.gymsystem.repository.ContratRepository;
@Service
public class ContratServiceImpl implements ContratServiceInter{
	
	@Autowired
	ContratRepository contratRep;
	@Override
	public Contrat addContrat(Contrat contrat) {
		
		return contratRep.save(contrat);
	}
	@Override
	public List<Contrat> addListContrat(List<Contrat> listcontrat) {
		// TODO Auto-generated method stub
		return contratRep.saveAll(listcontrat);
	}
	@Override
	public String addContratWTUN(Contrat contrat) {
		String ch="";
		if(contratRep.existsByNomContrat(contrat.getNomContrat())) {
			ch="Nom est déja existé";
		}
		else {
			contratRep.save(contrat);
			ch="Contrat est ajouter avec succ";
		}
		return ch;
	}

	public Contrat updateContrat(Long idContrat, Contrat contrat) {

	    if (contratRep.existsById(idContrat)) {
			Contrat existingContrat = contratRep.findById(idContrat).get();
			existingContrat.setNomContrat(contrat.getNomContrat());
			existingContrat.setDateDep(contrat.getDateDep());
			existingContrat.setDateFin(contrat.getDateFin());

	        contratRep.save(existingContrat);
	    } else {
	        throw new RuntimeException("L'utilisateur avec l'ID " + idContrat + " n'existe pas.");
	    }
		return contrat;
	}
	@Override
	public void deleteContrat(Long idContrat) {
	    if (contratRep.existsById(idContrat)) {
		
	    	contratRep.deleteById(idContrat);
	        System.out.println("Le Contrat avec l'ID " + idContrat + " a été supprimé avec succès.");

	    } else {
	        throw new RuntimeException("Le Contrat avec l'ID " + idContrat + " n'existe pas.");
	    }
		
	}
	@Override
	public List<Contrat> getListContrat() {
		
		return contratRep.findAll();
	}
	@Override
	public Contrat getByContratname(String nomContrat) {
		
		return contratRep.findByNomContrat(nomContrat);
	}
	@Override
	public List<Contrat> getContratSW(String ch) {
		
		return contratRep.getContratSW(ch);
	}

}
