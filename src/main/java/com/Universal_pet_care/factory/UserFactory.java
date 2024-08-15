package com.Universal_pet_care.factory;

import com.Universal_pet_care.model.User;
import com.Universal_pet_care.request.RegistrationRequest;

public interface UserFactory {
    public User createUser(RegistrationRequest registrationRequest);
}
