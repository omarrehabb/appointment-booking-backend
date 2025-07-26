package com.omarehab.appointment_booking.service;

import com.omarehab.appointment_booking.domain.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AppointmentService {
    Appointment save(Appointment appointment);

    /** old: list all as a List */
    List<Appointment> findAll();

    /** new: list in a Page */
    Page<Appointment> findAll(Pageable pageable);

    Appointment findById(Long id);

    void deleteById(Long id);
}
