package com.Universal_pet_care.service.user;

import com.Universal_pet_care.Dto.UserDto;
import com.Universal_pet_care.model.User;
import com.Universal_pet_care.request.RegistrationRequest;
import com.Universal_pet_care.request.UserUpdateRequest;

import java.util.List;

public interface IUserService {
    User register(RegistrationRequest request);



    User updateUser(Long userId, UserUpdateRequest request);

    User findById(Long userId);

    void delete(Long userId);

    List<UserDto> getAllUser();
}
