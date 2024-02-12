package com.gymsystem.gymsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymsystem.gymsystem.entities.Offre;
import com.gymsystem.gymsystem.repository.CoursRepository;
import com.gymsystem.gymsystem.repository.OffreRepository;
@Service
public class OffreServiceImpl implements OffreServiceInter{
	
	@Autowired
	OffreRepository offreRep;
	@Autowired
	CoursRepository coursRep;
	@Override
	public Offre addOffre(Offre offre) {
		
		return offreRep.save(offre);
	}
	@Override
	public List<Offre> addListOffre(List<Offre> listoffre) {
		// TODO Auto-generated method stub
		return offreRep.saveAll(listoffre);
	}
	@Override
	public String addOffreWTUN(Offre offre) {
		String ch="";
		if(offreRep.existsByNomOffre(offre.getNomOffre())) {
			ch="Nom est déja existé";
		}
		else {
			offreRep.save(offre);
			ch="Offre est ajouter avec succ";
		}
		return ch;
	}

	public Offre updateOffre(Long codeOffre, Offre offre) {

	    if (offreRep.existsById(codeOffre)) {
			Offre existingOffre = offreRep.findById(codeOffre).get();
			existingOffre.setNomOffre(offre.getNomOffre());
			existingOffre.setValidite(offre.getValidite());
			existingOffre.setDescription(offre.getDescription());
			existingOffre.setMontant(offre.getMontant());


	        offreRep.save(existingOffre);
	    } else {
	        throw new RuntimeException("L'offre avec le code  " + codeOffre + " n'existe pas.");
	    }
		return offre;
	}
	@Override
	public void deleteOffre(Long codeOffre) {
	    if (offreRep.existsById(codeOffre)) {
		
	    	offreRep.deleteById(codeOffre);
	        System.out.println("L'offre avec le code  " + codeOffre + " a été supprimé avec succès.");

	    } else {
	        throw new RuntimeException("L'offre avec le code " + codeOffre + " n'existe pas.");
	    }
		
	}
	@Override
	public List<Offre> getListOffre() {
		
		return offreRep.findAll();
	}
	@Override
	public Offre getByOffrename(String nomOffre) {
		
		return offreRep.findByNomOffre(nomOffre);
	}
	@Override
	public List<Offre> getOffreSW(String ch) {
		
		return offreRep.getOffreSW(ch);
	}

}
