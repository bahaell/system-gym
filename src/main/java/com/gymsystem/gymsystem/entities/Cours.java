package com.gymsystem.gymsystem.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
public class Cours {
	 @JsonIgnore
	@ManyToOne
    @JoinColumn(name = "offre_id")
    private Offre offre;
	
	@OneToMany(mappedBy ="cours",cascade = CascadeType.ALL)
	private Set<Planning> planning= new HashSet<>();
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coursId;
    @Enumerated(EnumType.STRING)
    private Spécialité nomC;
    private String description;
    private int capaciteMax;
	
}
