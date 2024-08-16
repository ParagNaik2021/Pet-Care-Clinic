package com.Universal_pet_care.response;

import com.Universal_pet_care.Dto.UserDto;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
public class ApiResponse<T> {
    private String message;
  //  private UserDto data;
   private T data;
    public ApiResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }


}
