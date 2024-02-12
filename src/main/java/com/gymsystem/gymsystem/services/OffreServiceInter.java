package com.gymsystem.gymsystem.services;

import java.util.List;

import com.gymsystem.gymsystem.entities.Offre;

public interface OffreServiceInter {
	
	public Offre addOffre(Offre Offre);
	public List<Offre> addListOffre(List<Offre> listoffre);
	public String addOffreWTUN(Offre offre);
	public Offre updateOffre(Long codeOffre,Offre offre);
	public void deleteOffre(Long codeOffre);
	public List<Offre> getListOffre();
	public Offre getByOffrename(String nom);
	public List<Offre> getOffreSW(String ch);

}
