package com.Universal_pet_care.service.appointment;

import com.Universal_pet_care.enums.AppointmentStatus;
import com.Universal_pet_care.exception.ResourceNotFoundException;
import com.Universal_pet_care.model.Appointment;
import com.Universal_pet_care.model.User;
import com.Universal_pet_care.repository.AppointmentRepository;
import com.Universal_pet_care.repository.UserRepository;
import com.Universal_pet_care.request.AppointmentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentService implements  IAppointmentService{
    private final AppointmentRepository appointmentRepository;
   private  final UserRepository userRepository;
    @Override
    public Appointment createAppointment(Appointment appointment, Long senderId, Long recipientId) {
        Optional<User> sender=userRepository.findById(senderId);
        Optional<User> recipient=userRepository.findById(recipientId);
        if(sender.isPresent() && recipient.isPresent()){
            appointment.setPatient(sender.get());
            appointment.setVeterinarian(recipient.get());
            appointment.setAppointmentNo();
            appointment.setStatus(AppointmentStatus.WAITING_FOR_APPROVAL);
            return appointmentRepository.save(appointment);
        }
        throw new ResourceNotFoundException("sender or recipient not found");
    }

    @Override
    public List<Appointment> getAllAppointment() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment updateAppointment(Long id, AppointmentRequest request) {
        return null;
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.findById(id).ifPresent(appointmentRepository::delete);

    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("appointment not found")
        );
    }

    @Override
    public Appointment getAppointmentByNo(String appointmentNo) {
        return appointmentRepository.findByAppointmentNo(appointmentNo);
    }
}
