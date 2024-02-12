package com.gymsystem.gymsystem.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class Reservation {
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;   
    @Column(name = "day")

    private LocalDate day;
    @Column(name = "start_time")

    private LocalTime startTime;
    @Column(name = "end_time")

    private LocalTime endTime;
    private float prix;

    @ManyToOne
    private Membre membre;

    @ManyToOne
    
    private Coach coach;

	
}
