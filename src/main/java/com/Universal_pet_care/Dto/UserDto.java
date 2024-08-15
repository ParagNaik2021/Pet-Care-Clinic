package com.Universal_pet_care.Dto;


import lombok.Data;

@Data
public class UserDto {

    private long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;
    private String email;
    private String userType;
    private boolean isEnabled;
    private String specialization;
}
