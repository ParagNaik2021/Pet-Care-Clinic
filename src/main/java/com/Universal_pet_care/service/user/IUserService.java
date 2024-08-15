package com.Universal_pet_care.service.user;

import com.Universal_pet_care.model.User;
import com.Universal_pet_care.request.RegistrationRequest;
import com.Universal_pet_care.request.UserUpdateRequest;

public interface IUserService {
    User register(RegistrationRequest request);



    User updateUser(Long userId, UserUpdateRequest request);
}
