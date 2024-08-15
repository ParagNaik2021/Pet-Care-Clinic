package com.Universal_pet_care.factory;

import com.Universal_pet_care.model.User;
import com.Universal_pet_care.model.Veterinarian;
import com.Universal_pet_care.repository.UserRepository;
import com.Universal_pet_care.repository.VeterinarianRepository;
import com.Universal_pet_care.request.RegistrationRequest;
import com.Universal_pet_care.service.user.UserAttributeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VeterinarianFactory {
    private final VeterinarianRepository veterinarianRepository;
    private final UserAttributeMapper userAttributeMapper;

    public User createVeterinarian(RegistrationRequest request) {
        Veterinarian veterinarian = new Veterinarian();
        //extraction information from registration request we put in veterian object
        userAttributeMapper.setCommonAttributes(request, veterinarian);
        veterinarian.setSpecialization(request.getSpecialization());

        return veterinarianRepository.save(veterinarian);


    }
}
