package com.Universal_pet_care.factory;

import com.Universal_pet_care.model.Patient;
import com.Universal_pet_care.model.User;
import com.Universal_pet_care.repository.PatientRepository;
import com.Universal_pet_care.request.RegistrationRequest;
import com.Universal_pet_care.service.user.UserAttributeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientFactory {
    private final PatientRepository patientRepository;
    private  final UserAttributeMapper userAttributeMapper;

    public User createPatient(RegistrationRequest request) {
        Patient patient=new Patient();
        userAttributeMapper.setCommonAttributes(request,patient);
        return patientRepository.save(patient);

    }
}
