package com.Universal_pet_care.request;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;

@Data
public class RegistrationRequest {
    private long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;
    private String email;
    private String password;
    private String userType;
    private boolean isEnabled;
    private String specialization;
}
