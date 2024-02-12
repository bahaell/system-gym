package com.gymsystem.gymsystem.services;

import java.util.List;

import com.gymsystem.gymsystem.entities.Reservation;

public interface ReservationServiceInter {
	public Reservation reserverCoach(Long membreId, Long coachId,Reservation reservation) ;

	void annulerReservation(Long reservationId);

	List<Reservation> getListReservations();

	List<Reservation> getListReservationsByCoach(Long coachId);

	List<Reservation> getListReservationsByMembre(Long membreId);
}
