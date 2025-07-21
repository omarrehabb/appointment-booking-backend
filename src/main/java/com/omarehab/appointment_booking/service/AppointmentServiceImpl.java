// src/main/java/com/omarehab/appointment_booking/service/AppointmentServiceImpl.java
package com.omarehab.appointment_booking.service;

import com.omarehab.appointment_booking.domain.Appointment;
import com.omarehab.appointment_booking.repository.AppointmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment save(Appointment appointment) {
        // you could add validation or conflict checks here
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment findById(Long id) {
        return appointmentRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("No appointment found with id " + id));
    }

    @Override
    public void deleteById(Long id) {
        appointmentRepository.deleteById(id);
    }
}
