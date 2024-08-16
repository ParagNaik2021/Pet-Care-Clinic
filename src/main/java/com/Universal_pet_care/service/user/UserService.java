package com.Universal_pet_care.service.user;

import com.Universal_pet_care.Dto.EntityConverter;
import com.Universal_pet_care.Dto.UserDto;
import com.Universal_pet_care.exception.ResourceNotFoundException;
import com.Universal_pet_care.factory.UserFactory;
import com.Universal_pet_care.model.User;
import com.Universal_pet_care.repository.UserRepository;
import com.Universal_pet_care.request.RegistrationRequest;
import com.Universal_pet_care.request.UserUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {


    private final UserRepository userRepository;
    private final UserFactory userFactory;

    public final EntityConverter<User,UserDto> entityConverter;

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

    @Override
    public  User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User Not Found"));
    }


    @Override
    public void delete(Long userId){
        userRepository.findById(userId).ifPresentOrElse(userRepository::delete,
                ()->{
            throw new ResourceNotFoundException("User not found");
        });
    }


    @Override
    public List<UserDto> getAllUser(){
        List<User> users=userRepository.findAll();
        return users.stream().map(user-> entityConverter.mapEntityToDto(user,UserDto.class)).collect(Collectors.toList());
    }
}
