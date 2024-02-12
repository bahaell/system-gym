package com.gymsystem.gymsystem.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Getter
@Setter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Membre extends User {
	
	@OneToMany(mappedBy ="membre",cascade = CascadeType.ALL)
	private Set<Progression> progressions= new HashSet<>();
	
	@OneToMany(mappedBy ="membre",cascade = CascadeType.ALL)
	
	private Set<Reservation> reservations= new HashSet<>();

	//@OneToMany(mappedBy ="membre",cascade = CascadeType.ALL)
	//private Set<Session> sessions= new HashSet<>();
	
	@OneToMany(mappedBy ="membre")
	private Set<Abonnement> abonnements = new HashSet<>();
	
	
    @Enumerated(EnumType.STRING)
	private Status status;

	
	
	
}
