package com.Universal_pet_care.service.user;

import com.Universal_pet_care.exception.ResourceNotFoundException;
import com.Universal_pet_care.factory.UserFactory;
import com.Universal_pet_care.model.User;
import com.Universal_pet_care.repository.UserRepository;
import com.Universal_pet_care.request.RegistrationRequest;
import com.Universal_pet_care.request.UserUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {


    private final UserRepository userRepository;
    private final UserFactory userFactory;

    @Override
    public User register(RegistrationRequest request) {
        return userFactory.createUser(request);
    }

    @Override
    public User updateUser(Long userId, UserUpdateRequest request){
        User user = findById(userId);
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setGender(request.getGender());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setSpecialization(request.getSpecialization());
        return userRepository.save(user);
    }

    private User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User Not Found"));
    }
}
