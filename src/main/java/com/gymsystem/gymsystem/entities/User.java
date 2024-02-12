package com.gymsystem.gymsystem.entities;


import java.time.LocalDate;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Inheritance(strategy = InheritanceType.JOINED )
@Data
@Entity

public class User {
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

	@OneToMany(mappedBy ="user",cascade = CascadeType.ALL)
	private Set<Notification> notifications= new HashSet<>();
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prénom;
    private LocalDate dateDeNaissance;
    private String email;
    private String mdp;
    private String telephone;
    private String photo;
    @Enumerated(EnumType.STRING)
    private Role role;
	

	

}
