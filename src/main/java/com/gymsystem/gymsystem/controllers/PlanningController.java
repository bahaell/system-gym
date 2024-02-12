package com.gymsystem.gymsystem.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gymsystem.gymsystem.entities.Planning;
import com.gymsystem.gymsystem.services.PlanningServiceImpl;


@RestController

public class PlanningController {
	@Autowired
	PlanningServiceImpl planningSer;

    @PostMapping("/planifier/{coachId}/{coursId}")
    public Planning abonnerOffre(
            @PathVariable Long coachId,
            @PathVariable Long coursId
           ) {

    	return planningSer.planifiercours(coachId, coursId );

         
    }
    
    @GetMapping(value = "/getListplanningByCoach/{coachId}")
    public List<Planning> getListPlanningByCoach(@PathVariable Long coachId) {
        return planningSer.getListPlanningByCoach(coachId);
    }
    @GetMapping(value = "/getListplanningByCours/{coursId}")
    public List<Planning> getListPlanningByCours(@PathVariable Long coursId) {
        return planningSer.getListPlanningByCours(coursId);
    }
    @GetMapping(value = "/getListplanning")
    public List<Planning> getListPlanning() {
        return planningSer.getListPlanning();
    }
}