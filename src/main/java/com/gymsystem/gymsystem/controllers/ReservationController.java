package com.gymsystem.gymsystem.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gymsystem.gymsystem.entities.Reservation;
import com.gymsystem.gymsystem.services.ReservationServiceImpl;


@RestController

public class ReservationController {
	@Autowired
	ReservationServiceImpl reservationSer;

    @PostMapping("/reserve/{memberId}/{coachId}")
    public Reservation reserverCoach(
            @PathVariable Long memberId,
            @PathVariable Long coachId,
            @RequestBody Reservation reservation
           ) {

    	return reservationSer.reserverCoach(memberId, coachId, reservation);

         
    }
    @DeleteMapping(value = "/annulerreservation/{reservationId}")
	public void annulerReservation(@PathVariable Long reservationId) {
    	reservationSer.annulerReservation(reservationId);
	
	}
    @GetMapping(value = "/getListreservationsByMembre/{membreId}")
    public List<Reservation> getListReservationsByMembre(@PathVariable Long membreId) {
        return reservationSer.getListReservationsByMembre(membreId);
    }
    @GetMapping(value = "/getListreservationsByCoach/{coachId}")
    public List<Reservation> getListReservationsByCoach(@PathVariable Long coachId) {
        return reservationSer.getListReservationsByCoach(coachId);
    }
    @GetMapping(value = "/getListreservations")
    public List<Reservation> getListReservations() {
        return reservationSer.getListReservations();
    }

}
