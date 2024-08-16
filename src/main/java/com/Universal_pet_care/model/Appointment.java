package com.Universal_pet_care.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    private Long id;
    private String reason;
    private LocalDateTime date;
    private LocalTime time;
    private String appointmentNo;
    private LocalDate createdAt;

    @Column(name = "sender")
    @ManyToOne(fetch = FetchType.LAZY)
    private User patient;

    @Column(name = "recipient")
    @ManyToOne(fetch = FetchType.LAZY)
    private User veterinarian;
}
