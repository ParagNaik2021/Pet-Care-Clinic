package com.Universal_pet_care.factory;

import com.Universal_pet_care.exception.UserAlreadyExistsException;
import com.Universal_pet_care.model.Patient;
import com.Universal_pet_care.model.User;
import com.Universal_pet_care.repository.UserRepository;
import com.Universal_pet_care.repository.VeterinarianRepository;
import com.Universal_pet_care.request.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SimpleUserFactory implements UserFactory {

    private final UserRepository userRepository;
    private final VeterinarianFactory veterinarianFactory;
    private final PatientFactory patientFactory;
    private final AdminFactory adminFactory;

    @Override
    public User createUser(RegistrationRequest registrationRequest) {
        //we are checking if the user already exist or not
        if (userRepository.existsByEmail(registrationRequest.getEmail())) {
            throw new UserAlreadyExistsException("Oops!" + registrationRequest.getEmail() + " already exist");
        }
        //if not we will create
        switch (registrationRequest.getUserType()) {
            case "VET" -> {
                return veterinarianFactory.createVeterinarian(registrationRequest);
            }
            case "PATIENT" -> {
                return patientFactory.createPatient(registrationRequest);
            }

            case "ADMIN" -> {
                return adminFactory.createAdmin(registrationRequest);
            }
            default -> {
                return null;
            }

        }

    }
}
