package com.Universal_pet_care.service.appointment;

import com.Universal_pet_care.model.Appointment;
import com.Universal_pet_care.request.AppointmentRequest;

import java.util.List;

public interface IAppointmentService {


    Appointment createAppointment(Appointment appointment,Long sender,Long recipient);
    List<Appointment> getAllAppointment();
    Appointment updateAppointment(Long id, AppointmentRequest request);
    void deleteAppointment(Long id);
    Appointment getAppointmentById(Long id);
    Appointment getAppointmentByNo(String appointmentNo);
}
