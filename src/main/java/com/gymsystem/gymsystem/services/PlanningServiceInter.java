package com.gymsystem.gymsystem.services;

import java.util.List;

import com.gymsystem.gymsystem.entities.Planning;

public interface PlanningServiceInter {

	//Planning planifiercours(Long coachId, Long coursId, Planning planning);

	List<Planning> getListPlanning();

	List<Planning> getListPlanningByCoach(Long coachId);


	List<Planning> getListPlanningByCours(Long coursId);

	Planning planifiercours(Long coachId, Long coursId);


}
