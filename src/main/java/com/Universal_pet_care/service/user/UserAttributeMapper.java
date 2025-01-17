package com.Universal_pet_care.service.user;

import com.Universal_pet_care.model.User;
import com.Universal_pet_care.request.RegistrationRequest;
import org.springframework.stereotype.Component;

@Component
public class UserAttributeMapper {
    public void setCommonAttributes(RegistrationRequest source , User target){
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setGender(source.getGender());
        target.setPhoneNumber(source.getPhoneNumber());
        target.setEmail(source.getEmail());
        target.setPassword(source.getPassword());
        target.setEnabled(source.isEnabled());
        target.setUserType(source.getUserType());

    }


}
