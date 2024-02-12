package com.gymsystem.gymsystem.entities;

import java.lang.reflect.Member;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Progression {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 
 private Long idProgr;
 private LocalDate date;
 private float poids;
 private float masseGrasse;
 private float objectif;

 @ManyToOne(fetch=FetchType.LAZY)
 private Membre membre;

	
}

