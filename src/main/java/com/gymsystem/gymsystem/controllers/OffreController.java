package com.gymsystem.gymsystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gymsystem.gymsystem.entities.Offre;
import com.gymsystem.gymsystem.services.OffreServiceImpl;

@RestController
public class OffreController {
	@Autowired /* appel le service injection de dependance*/
	OffreServiceImpl offreServ;
	
	
	@PostMapping(value = "/addoffre")
	public Offre addOffre(@RequestBody Offre offre) {
		return offreServ.addOffre(offre);
	
	}
	@PostMapping(value = "/addListoffre")
	public List<Offre> addListOffre(@RequestBody List<Offre>  listoffre) {
		return offreServ.addListOffre(listoffre);
	
	}
	@PostMapping(value = "/addoffreWTN")
	public String addOffreWTUN(@RequestBody Offre offre) {
		return offreServ.addOffreWTUN(offre);
	
	}
	@PostMapping(value = "/updateoffre/{codeOffre}")
	public Offre updateOffre(@PathVariable Long codeOffre,@RequestBody Offre offre) {
		return offreServ.updateOffre(codeOffre,offre);
	
	}
	@DeleteMapping(value = "/deleteOffre/{codeOffre}")
	public void deleteOffre(@PathVariable Long codeOffre) {
		 offreServ.deleteOffre(codeOffre);
	
	}
	@GetMapping(value = "/getListoffre")
	public List<Offre> getListOffre() {
		 return offreServ.getListOffre();
	
	}
	@GetMapping(value = "/getByoffrename/{nom}")
	public Offre getByOffrename(@PathVariable String nomOffre) {
		 return offreServ.getByOffrename(nomOffre);
	}
	@GetMapping(value = "/getoffreSW/{ch}")
	public List<Offre> getOffreSW(@PathVariable String ch) {
		 return offreServ.getOffreSW(ch);
	
	}

}
