package com.gymsystem.gymsystem.entities;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;


@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)

@Data
@Entity
public class Offre {
	 @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeOffre;
    private String nomOffre;
    private int validite;
    private float montant;
    private String description;

    
    @OneToMany(mappedBy ="offre",cascade = CascadeType.ALL)
	private Set<Cours> cours= new HashSet<>();

	@OneToMany(mappedBy ="offre")
	 
	private Set<Abonnement> abonnements = new HashSet<>();
	
	

}