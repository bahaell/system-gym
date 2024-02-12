package com.gymsystem.gymsystem.services;

import java.util.List;


import com.gymsystem.gymsystem.entities.Coach;
import com.gymsystem.gymsystem.entities.Membre;
import com.gymsystem.gymsystem.entities.Role;
import com.gymsystem.gymsystem.entities.User;

public interface UserServiceInter {
	public Membre addMembre(Membre membre);
	public Coach addCoach(Coach coach);
	public List<User> addListUser(List<User> listuser);
	public String addUserWTUN(User user);
	public User updateUser(Long iduser,User user);
	public void deleteUser(Long iduser);
	public List<User> getListUser();
	public User getByUsername(String nom);
	public List<User> getUserSW(String ch);
	public List<User> getListByUserrole(Role role);
	public User updateMembre(Long iduser, Membre membre);
	public User updateCoach(Long iduser, Coach coach);
	public List<User> getListByUserSOS(String ss);

}
