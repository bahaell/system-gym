package com.gymsystem.gymsystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gymsystem.gymsystem.entities.Coach;
import com.gymsystem.gymsystem.entities.Membre;
import com.gymsystem.gymsystem.entities.Role;
import com.gymsystem.gymsystem.entities.User;
import com.gymsystem.gymsystem.services.UserServiceImpl;

@RestController
@RequestMapping("/user")  
public class UserController {
	@Autowired /* appel le service injection de dependance*/
	UserServiceImpl userServ;
	
	@PostMapping(value = "/addcoach")
	 public Coach addCoach(@RequestBody Coach coach) {
		 return userServ.addCoach(coach);
	    }
	 
	
	@PostMapping(value = "/addmembre", consumes = "application/json")
	 public Membre addMembre(@RequestBody Membre membre) {
		 return userServ.addMembre(membre);
	    }
	 
	
	@PostMapping(value = "/addListuser")
	public List<User> addListUser(@RequestBody List<User>  listuser) {
		return userServ.addListUser(listuser);
	
	}
	@PostMapping(value = "/adduserWTUN")
	public String addUserWTUN(@RequestBody User user) {
		return userServ.addUserWTUN(user);
	
	}
	@PutMapping(value = "/updateuser/{iduser}")
	public User updateUser(@PathVariable Long iduser,@RequestBody User user) {
		return userServ.updateUser(iduser,user);
	
	}
	@PutMapping(value = "/updatemembre/{iduser}")
	public User updateMembre(@PathVariable Long iduser,@RequestBody Membre membre) {
		return userServ.updateMembre(iduser,membre);
	
	}
	@PutMapping(value = "/updatecoach/{iduser}")
	public User updateCoach(@PathVariable Long iduser,@RequestBody Coach coach) {
		return userServ.updateCoach(iduser,coach);
	
	}
	
	@DeleteMapping(value = "/deleteuser/{iduser}")
	public void deleteUser(@PathVariable Long iduser) {
		 userServ.deleteUser(iduser);
	
	}
	
	
	@GetMapping(value = "/getListuser")
	public List<User> getListUser() {
		 return userServ.getListUser();
	
	}
	@GetMapping(value = "/getListByuserrole/{role}")
	public List<User> getListByUserrole(@PathVariable Role role) {
		 return userServ.getListByUserrole(role);
	
	}
	@GetMapping(value = "/getListByuserSOS/{ss}")
	public List<User> getListByUserSOS(@PathVariable String ss) {
		 return userServ.getListByUserSOS(ss);
	
	}
	@GetMapping(value = "/getByusername/{nom}")
	public User getByUsername(@PathVariable String nom) {
		 return userServ.getByUsername(nom);
	}
	
	@GetMapping(value = "/getuserSW/{ch}")
	public List<User> getUserSW(@PathVariable String ch) {
		 return userServ.getUserSW(ch);
	
	}

}
