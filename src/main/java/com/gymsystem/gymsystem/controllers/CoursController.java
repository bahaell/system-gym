package com.gymsystem.gymsystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gymsystem.gymsystem.entities.Cours;
import com.gymsystem.gymsystem.entities.Spécialité;
import com.gymsystem.gymsystem.services.CoursServiceImpl;

@RestController
public class CoursController {
	@Autowired /* appel le service injection de dependance*/
	CoursServiceImpl coursServ;
	
	
	@PostMapping(value = "/addcours")
	public Cours addCours(@RequestBody Cours cours) {
		return coursServ.addCours(cours);
	
	}
	@PostMapping(value = "/addListcours")
	public List<Cours> addListCours(@RequestBody List<Cours>  listcours) {
		return coursServ.addListCours(listcours);
	
	}
	@PostMapping(value = "/addcoursWTUN")
	public String addCoursWTUN(@RequestBody Cours cours) {
		return coursServ.addCoursWTUN(cours);
	
	}
	@PostMapping(value = "/updateCours/{idcours}")
	public Cours updateCours(@PathVariable Long coursId,@RequestBody Cours cours) {
		return coursServ.updateCours(coursId,cours);
	
	}
	@DeleteMapping(value = "/deletecours/{coursId}")
	public void deleteCours(@PathVariable Long coursId) {
		 coursServ.deleteCours(coursId);
	
	}
	@GetMapping(value = "/getListcours")
	public List<Cours> getListCours() {
		 return coursServ.getListCours();
	
	}
	@GetMapping(value = "/getByCoursname/{nom}")
	public Cours getByCoursname(@PathVariable Spécialité nomC) {
		 return coursServ.getByCoursname(nomC);
	
	}
	

}
