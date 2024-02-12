package com.gymsystem.gymsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymsystem.gymsystem.entities.Cours;
import com.gymsystem.gymsystem.entities.Spécialité;
import com.gymsystem.gymsystem.repository.CoursRepository;
@Service
public class CoursServiceImpl implements CoursServiceInter{
	
	@Autowired
	CoursRepository coursRep;
	@Override
	public Cours addCours(Cours cours) {
		
		return coursRep.save(cours);
	}
	@Override
	public List<Cours> addListCours(List<Cours> listcours) {
		// TODO Auto-generated method stub
		return coursRep.saveAll(listcours);
	}
	@Override
	public String addCoursWTUN(Cours cours) {
		String ch="";
		if(coursRep.existsByNomC(cours.getNomC())) {
			ch="Nom est déja existé";
		}
		else {
			coursRep.save(cours);
			ch="Cours est ajouter avec succ";
		}
		return ch;
	}

	public Cours updateCours(Long coursId, Cours Cours) {

	    if (coursRep.existsById(coursId)) {
			Cours existingCours = coursRep.findById(coursId).get();
			existingCours.setNomC(Cours.getNomC());
			existingCours.setCapaciteMax(Cours.getCapaciteMax());
			existingCours.setDescription(Cours.getDescription());


	        coursRep.save(existingCours);
	    } else {
	        throw new RuntimeException("Le Cours avec le code " + coursId + " n'existe pas.");
	    }
		return Cours;
	}
	@Override
	public void deleteCours(Long coursId) {
	    if (coursRep.existsById(coursId)) {
		
	    	coursRep.deleteById(coursId);
	        System.out.println("Le Cours avec le code " + coursId + " a été supprimé avec succès.");

	    } else {
	        throw new RuntimeException("Le Cours avec le code" + coursId + " n'existe pas.");
	    }
		
	}
	@Override
	public List<Cours> getListCours() {
		
		return coursRep.findAll();
	}
	@Override
	public Cours getByCoursname(Spécialité nomC) {
		
		return coursRep.findByNomC(nomC);
	}


}
