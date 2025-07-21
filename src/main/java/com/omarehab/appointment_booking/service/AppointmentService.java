package com.omarehab.appointment_booking.service;

import com.omarehab.appointment_booking.domain.Appointment;
import java.util.List;

public interface AppointmentService {
    Appointment save(Appointment appointment);
    List<Appointment> findAll();
    Appointment findById(Long id);
    void deleteById(Long id);
}
