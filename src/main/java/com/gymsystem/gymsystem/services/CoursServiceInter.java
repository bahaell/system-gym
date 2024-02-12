package com.gymsystem.gymsystem.services;

import java.util.List;

import com.gymsystem.gymsystem.entities.Cours;
import com.gymsystem.gymsystem.entities.Spécialité;

public interface CoursServiceInter {
	
	public Cours addCours(Cours cours);
	public List<Cours> addListCours(List<Cours> listcours);
	public String addCoursWTUN(Cours Cours);
	public Cours updateCours(Long coursId,Cours cours);
	public void deleteCours(Long coursId);
	public List<Cours> getListCours();
	public Cours getByCoursname(Spécialité nomC);
	

}
