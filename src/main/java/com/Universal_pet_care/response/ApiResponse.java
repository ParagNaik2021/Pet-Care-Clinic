package com.Universal_pet_care.response;

import com.Universal_pet_care.Dto.UserDto;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
public class ApiResponse {
    private String message;
    private UserDto data;
    public ApiResponse(String message, UserDto data) {
        this.message = message;
        this.data = data;
    }
}
