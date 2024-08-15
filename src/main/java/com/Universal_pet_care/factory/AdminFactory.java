package com.Universal_pet_care.factory;

import com.Universal_pet_care.model.Admin;
import com.Universal_pet_care.model.User;
import com.Universal_pet_care.repository.AdminRepository;
import com.Universal_pet_care.request.RegistrationRequest;
import com.Universal_pet_care.service.user.UserAttributeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminFactory {
    private final AdminRepository adminRepository;
    private final UserAttributeMapper userAttributeMapper;

    public User createAdmin(RegistrationRequest request) {
        Admin admin=new Admin();
        userAttributeMapper.setCommonAttributes(request,admin);
        return adminRepository.save(admin);

    }
}
