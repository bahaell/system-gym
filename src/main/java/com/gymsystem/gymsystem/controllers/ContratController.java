package com.gymsystem.gymsystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gymsystem.gymsystem.entities.Contrat;
import com.gymsystem.gymsystem.services.ContratServiceImpl;

@RestController
public class ContratController {
	@Autowired /* appel le service injection de dependance*/
	ContratServiceImpl contratServ;
	
	
	@PostMapping(value = "/addcontrat")
	public Contrat addContrat(@RequestBody Contrat contrat) {
		return contratServ.addContrat(contrat);
	
	}
	@PostMapping(value = "/addListcontrat")
	public List<Contrat> addListContrat(@RequestBody List<Contrat>  listcontrat) {
		return contratServ.addListContrat(listcontrat);
	
	}
	@PostMapping(value = "/addcontratWTUN")
	public String addContratWTUN(@RequestBody Contrat contrat) {
		return contratServ.addContratWTUN(contrat);
	
	}
	@PostMapping(value = "/updatecontrat/{idContrat}")
	public Contrat updateContrat(@PathVariable Long idContrat,@RequestBody Contrat contrat) {
		return contratServ.updateContrat(idContrat,contrat);
	
	}
	@DeleteMapping(value = "/deletecontrat/{idContrat}")
	public void deleteContrat(@PathVariable Long idContrat) {
		 contratServ.deleteContrat(idContrat);
	
	}
	@GetMapping(value = "/getListcontrat")
	public List<Contrat> getListContrat() {
		 return contratServ.getListContrat();
	
	}
	@GetMapping(value = "/getBycontratname/{nomContrat}")
	public Contrat getByContratname(@PathVariable String nomContrat) {
		 return contratServ.getByContratname(nomContrat);
	
	}
	@GetMapping(value = "/getcontratSW/{ch}")
	public List<Contrat> getContratSW(@PathVariable String ch) {
		 return contratServ.getContratSW(ch);
	
	}

}
