package com.Universal_pet_care.model;

import com.Universal_pet_care.enums.AppointmentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    private String reason;
    private LocalDateTime date;
    private LocalTime time;
    private String appointmentNo;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    private LocalDate createdAt;

    @JoinColumn(name = "sender")
    @ManyToOne(fetch = FetchType.LAZY)
    private User patient;

    @JoinColumn(name = "recipient")
    @ManyToOne(fetch = FetchType.LAZY)
    private User veterinarian;

    public void addPatient(User sender){
        this.setPatient(sender);
        if(sender.getAppointments()==null){
            sender.setAppointments(new ArrayList<Appointment>());
        }
        sender.getAppointments().add(this);
    }

    public void addVeterian(User recipient){
        this.setVeterinarian(recipient);
        if(recipient.getAppointments()==null){
            recipient.setAppointments(new ArrayList<Appointment>());
        }
        recipient.getAppointments().add(this);
    }


    public void setAppointmentNo(){
        this.appointmentNo=String.valueOf(new Random().nextLong()).substring(1,11);
    }
}


