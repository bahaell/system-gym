package com.gymsystem.gymsystem.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Coach extends User {
	 @JsonIgnore
	@OneToOne(mappedBy = "coach", cascade = CascadeType.ALL, orphanRemoval = true)
    private Contrat contrat;
	
	@OneToMany(mappedBy ="coach",cascade = CascadeType.ALL)
	private Set<Reservation> reservations= new HashSet<>();
	

	//@OneToMany(mappedBy ="membre",cascade = CascadeType.ALL)
	//private Set<Session> sessions= new HashSet<>();
	
	@OneToMany(mappedBy ="coach",cascade = CascadeType.ALL)
	
	private Set<Planning> planning= new HashSet<>();
	
    @Enumerated(EnumType.STRING)
	    private Spécialité spécialité;
		
		 
}
