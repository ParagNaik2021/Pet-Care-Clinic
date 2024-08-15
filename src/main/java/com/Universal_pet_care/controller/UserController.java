package com.Universal_pet_care.controller;
import com.Universal_pet_care.Dto.EntityConverter;
import com.Universal_pet_care.Dto.UserDto;
import com.Universal_pet_care.exception.ResourceNotFoundException;
import com.Universal_pet_care.exception.UserAlreadyExistsException;
import com.Universal_pet_care.model.User;
import com.Universal_pet_care.request.RegistrationRequest;
import com.Universal_pet_care.request.UserUpdateRequest;
import com.Universal_pet_care.response.ApiResponse;
import com.Universal_pet_care.service.user.UserService;
import com.Universal_pet_care.utils.FeedBackMessage;
import com.Universal_pet_care.utils.UrlMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RequiredArgsConstructor
@RequestMapping(UrlMapping.USERS)
@RestController
public class UserController {

    private final UserService userService;
    private final EntityConverter<User, UserDto> entityConverter;


    @PostMapping(UrlMapping.REGISTER_USER)
    public ResponseEntity<ApiResponse> register(@RequestBody RegistrationRequest request) {
        try {
            User user = userService.register(request);
            UserDto registeredUser = entityConverter.mapEntityToDto(user, UserDto.class);
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.SUCCESS, registeredUser));
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.status(CONFLICT).body(new ApiResponse(e.getMessage(), null));
        }
        catch (Exception e){
            return  ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }
    }

    @PostMapping(UrlMapping.UPDATE_USER)
    public ResponseEntity<ApiResponse> update(@PathVariable  Long userId,@RequestBody UserUpdateRequest request){
        try{
            User user = userService.updateUser(userId, request);
            //convert it into userdto to mask important data which return once it is successfull
            UserDto updateUser=entityConverter.mapEntityToDto(user,UserDto.class);
    return ResponseEntity.ok(new ApiResponse(FeedBackMessage.UPDATE_SUCCESS,updateUser));
        }
        catch (ResourceNotFoundException e){
            return ResponseEntity.status(CONFLICT).body(new ApiResponse(e.getMessage(), null));
        }
        catch (Exception e){
            return  ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }
    }
}
