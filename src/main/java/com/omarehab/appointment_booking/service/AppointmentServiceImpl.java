package com.omarehab.appointment_booking.service;

import com.omarehab.appointment_booking.domain.Appointment;
import com.omarehab.appointment_booking.repository.AppointmentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository repo;

    public AppointmentServiceImpl(AppointmentRepository repo) {
        this.repo = repo;
    }

    @Override
    public Appointment save(Appointment appointment) {
        return repo.save(appointment);
    }

    @Override
    public List<Appointment> findAll() {
        return repo.findAll();
    }

    @Override
    public Page<Appointment> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public Appointment findById(Long id) {
        return repo.findById(id)
                   .orElseThrow(() -> new NoSuchElementException("Appointment not found: " + id));
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
